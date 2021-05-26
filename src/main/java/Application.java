import CityRelatedClasses.CityListManipulator;

import java.io.IOException;

/**
 * Класс - точка входа в приложение
 * Читает txt файл из файловой системы
 * Если такого файла нет, программа закрывается
 */
public class Application {
    public static void main(String[] args) {
        CityListManipulator cities = new CityListManipulator();

        try {
            cities.readCitiesListFromFile("src/main/resources/Cities.txt");

            System.out.println("Первый модуль:");
            cities.printCitiesList(cities.getCities());
            System.out.println("_______________");

            System.out.println("Второй модуль:");
            cities.printCitiesList(cities.nameSorting());
            System.out.println("_______________");
            cities.printCitiesList(cities.districtAndNameSorting());
            System.out.println("_______________");

            System.out.println("Третий модуль:");
            System.out.println(cities.maxPopulationSearch());
            System.out.println("_______________");

            System.out.println("Четвертый модуль:");
            cities.printCitiesAndRegions();
        } catch (IOException e) {
            System.out.println("Несуществующий файл");
        }
    }
}
