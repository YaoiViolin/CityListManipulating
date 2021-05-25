import city_related_classes.City;
import city_related_classes.CityListManipulator;

import java.io.IOException;
import java.util.Set;

public class Application {
    public static void main(String[] args) throws IOException {
        CityListManipulator cities = new CityListManipulator();
        cities.readCitiesListFromFile("src/main/resources/Cities.txt");
        /*cities.printCitiesList();
        cities.nameSorting();
        cities.districtAndNameSorting();*/
        cities.maxPopulationSearch();
        cities.printCitiesAndRegions();

    }
}
