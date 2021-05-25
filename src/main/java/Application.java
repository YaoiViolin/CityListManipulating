import CityRelatedClasses.CityListManipulator;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        CityListManipulator cities = new CityListManipulator();
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


    }
}
