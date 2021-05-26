package CityRelatedClasses;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Класс, реализующий все требуемые операции со списков городов
 *
 * @author Дьяковская Маргарита
 * @version 1.1
 */


public class CityListManipulator {
    private List<City> cities;

    /**
     * Конструктор, инициализирующий список
     */

    public CityListManipulator() {
        cities = new ArrayList<>();
    }
    /**
     * Геттер и сеттер
     */
    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
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
            cities.add(parseLineToCity(scanner.nextLine()));
        }
        scanner.close();
    }
    /**
     * Функция печатает в консоль содержимое списка городов
     */
    public void printCitiesList(List<City> list) {
        for (City city :
                list) {
            System.out.println(city);
        }
    }
    /**
     * Функция сортирует список городов по имени в обратном порядке (от Я до А)
     */
    public List<City> nameSorting () {
        List<City> sorted = new ArrayList<>(cities);
        Comparator<City> names = Comparator.comparing(city -> city.getName().toLowerCase(Locale.ROOT));
        sorted.sort(names.reversed());
        return sorted;
    }
    /**
     * Функция сортирует список городов в рамках каждого региона в обратном порядке (от Я до А)
     */
    public List<City> districtAndNameSorting() {
        List<City> sorted = new ArrayList<>(cities);
        Comparator<City> namesAndRegions = Comparator.comparing(City::getDistrict);
        Comparator<City> names = Comparator.comparing(City::getName);
        sorted.sort(namesAndRegions.thenComparing(names).reversed());
        return sorted;
    }
    /**
     * Функция ищет в списке городов город с наибольшим населением и возвращает строку, содержащую порядковый номер (индекс) города и население
     */
    public String maxPopulationSearch() {
        City[] citiesArray = cities.toArray(new City[cities.size()]);
        City city = Arrays.stream(citiesArray).max(Comparator.comparing(City::getPopulation)).get();
        return String.format("[%d] = %d", city.getId(), city.getPopulation());
    }
    /**
     * Функция возвращает кол-во городов в каждом регионе
     * @return карта, где ключ - название региона, а значение - кол-во городов в этом регионе
     */
    public Map<String, Integer> printCitiesAndRegions () {
        City[] citiesArray = cities.toArray(new City[cities.size()]);
        Map<String,Integer> map = new HashMap<>();
        for (City city : citiesArray) {
            String region = city.getRegion();
            if (map.containsKey(region)) {
                map.replace(region, map.get(region) + 1);
            } else map.put(region, 1);
        }

        for (Map.Entry<String, Integer> pair :
                map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
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
