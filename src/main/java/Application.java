import CityRelatedClasses.CityListManipulator;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        CityListManipulator cities = new CityListManipulator();
        cities.readCitiesListFromFile("src/main/resources/Cities.txt");

        System.out.println("Первый модуль:");
        cities.printCitiesList();
        System.out.println("_______________");

        System.out.println("Второй модуль:");
        cities.nameSorting();
        cities.districtAndNameSorting();
        System.out.println("_______________");

        System.out.println("Третий модуль:");
        cities.maxPopulationSearch();
        System.out.println("_______________");

        System.out.println("Четвертый модуль:");
        cities.printCitiesAndRegions();


    }
}
