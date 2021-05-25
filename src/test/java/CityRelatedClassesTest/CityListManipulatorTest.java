package CityRelatedClassesTest;

import CityRelatedClasses.CityListManipulator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class CityListManipulatorTest {

    @Test
    void readCitiesListFromFile() {
        CityListManipulator cities = new CityListManipulator();
        try {
            cities.readCitiesListFromFile("src/main/resources/Cities.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assertions.assertNotNull(cities);
        Assertions.assertEquals(11, cities.getCities().size());
    }

    @Test
    void nameSorting() {
    }

    @Test
    void districtAndNameSorting() {
    }

    @Test
    void maxPopulationSearch() {
    }

    @Test
    void printCitiesAndRegions() {
    }
}