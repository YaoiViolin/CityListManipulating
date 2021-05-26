package ru.sberbank.dyakovskayamp.service;

import ru.sberbank.dyakovskayamp.dao.DataAccessObject;
import ru.sberbank.dyakovskayamp.db.CityDataBase;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Класс, реализующий все требуемые операции со списков городов
 *
 * @author Дьяковская Маргарита
 * @version 1.1
 */


public class CityListManipulator {
    private final DataAccessObject dataAccessObject;

    /**
     * Конструктор
     */

    public CityListManipulator() {
        dataAccessObject = new DataAccessObject(new CityDataBase());
    }

    public DataAccessObject getDataAccessObject() {
        return dataAccessObject;
    }

    /**
     * Функция принимает на вход файл со списком городов, парсит его, заполняя список
     * @param fileName - путь к файлу
     * @throws IOException - пробрасывает наверх исключение, если что-то не так с файлом; оно обрабатывается в main
     */
    public void readCitiesListFromFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        while(scanner.hasNext()){
            dataAccessObject.add(parseLineToCity(scanner.nextLine()));
        }
        scanner.close();
    }
    /**
     * Функция печатает в консоль содержимое списка городов
     */
    public void printAllCities() {
        List<City> list = dataAccessObject.getCities();
        printList(list);
    }
    /**
     * Функция печатает в консоль содержимое списка
     */
    public void printList(List<City> list) {
        for (City city :
                list) {
            System.out.println(city);
        }
    }
    /**
     * Функция сортирует список городов по имени в обратном порядке (от Я до А)
     */
    public List<City> nameSorting () {
        List<City> sorted = new ArrayList<>(dataAccessObject.getCities());
        Comparator<City> names = Comparator.comparing(city -> city.getName().toLowerCase(Locale.ROOT));
        sorted.sort(names.reversed());
        return sorted;
    }
    /**
     * Функция сортирует список городов в рамках каждого региона в обратном порядке (от Я до А)
     */
    public List<City> districtAndNameSorting() {
        List<City> sorted = new ArrayList<>(dataAccessObject.getCities());
        Comparator<City> namesAndRegions = Comparator.comparing(City::getDistrict);
        Comparator<City> names = Comparator.comparing(City::getName);
        sorted.sort(namesAndRegions.thenComparing(names).reversed());
        return sorted;
    }
    /**
     * Функция ищет в списке городов город с наибольшим населением и возвращает строку, содержащую порядковый номер (индекс) города и население
     */
    public String maxPopulationSearch() {
        City[] citiesArray = dataAccessObject.getCities().toArray(new City[0]);
        City city = Arrays.stream(citiesArray).max(Comparator.comparing(City::getPopulation)).get();
        return String.format("[%d] = %d", city.getId(), city.getPopulation());
    }
    /**
     * Функция возвращает кол-во городов в каждом регионе
     * @return карта, где ключ - название региона, а значение - кол-во городов в этом регионе
     */
    public Map<String, Long> printCitiesAndRegions () {
        City[] citiesArray = dataAccessObject.getCities().toArray(new City[0]);
        Map<String, Long> map = Arrays.stream(citiesArray).collect(Collectors.groupingBy(City::getRegion, Collectors.counting()));

        map.forEach((key, value) -> System.out.println(key + " - " + value));
        return map;
    }

    /**
     * Приватная функция
     * @param line - строка из файла со списком городов, которую надо парсить
     * @return - экзмепляр класса City, инициализированный параметрами класса
     */
    private City parseLineToCity(String line) {
        String[] cityProps = line.split(";");
        return new City(Long.parseLong(cityProps[0]),
                cityProps[1],
                cityProps[2],
                cityProps[3],
                Integer.parseInt(cityProps[4]),
                Integer.parseInt(cityProps[5]));
    }


}
