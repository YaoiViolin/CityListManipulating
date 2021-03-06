package CityRelatedClassesTest;

import ru.sberbank.dyakovskayamp.service.City;
import ru.sberbank.dyakovskayamp.service.CityListManipulator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.io.IOException;

class CityListManipulatorTest {
    static CityListManipulator cities;
    @BeforeAll
    static void beforeAll() {
        cities = new CityListManipulator();
        List<City> list = cities.getDataAccessObject().getCities();
        list.add(new City(1,"Алдан", "Якутия", "Дальневосточный", 21255, 1924));
        list.add(new City(2,"Абакан", "Хакасия", "Сибирский", 165183, 1931));
        list.add(new City(3,"Майкоп", "Адыгея", "Южный", 144246, 1857));
        list.add(new City(4,"Абаза", "Хакасия", "Сибирский", 17111, 1867));

    }

    @Test
    void readCitiesListFromFile() {
        CityListManipulator cities = new CityListManipulator();
        try {
            cities.readCitiesListFromFile("src/main/resources/Cities.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assertions.assertNotNull(cities);
        Assertions.assertEquals(11, cities.getDataAccessObject().getCities().size());
    }

    @Test
    void nameSorting() {
        List<City> testList = new ArrayList<>();
        testList.add(new City(1,"Майкоп", "Адыгея", "Южный", 144246, 1857));
        testList.add(new City(2,"Алдан", "Якутия", "Дальневосточный", 21255, 1924));
        testList.add(new City(3,"Абакан", "Хакасия", "Сибирский", 165183, 1931));
        testList.add(new City(4,"Абаза", "Хакасия", "Сибирский", 17111, 1867));

        List<City> actual = cities.nameSorting();

        Assertions.assertEquals(testList,actual);
    }

    @Test
    void districtAndNameSorting() {
        List<City> testList = new ArrayList<>();
        testList.add(new City(1,"Майкоп", "Адыгея", "Южный", 144246, 1857));
        testList.add(new City(2,"Абакан", "Хакасия", "Сибирский", 165183, 1931));
        testList.add(new City(3,"Абаза", "Хакасия", "Сибирский", 17111, 1867));
        testList.add(new City(4,"Алдан", "Якутия", "Дальневосточный", 21255, 1924));

        List<City> actual = cities.districtAndNameSorting();

        Assertions.assertEquals(testList, actual);
    }

    @Test
    void maxPopulationSearch() {
        String expected = "[2] = 165183";
        String actual = cities.maxPopulationSearch();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void printCitiesAndRegions() {
        Map<String, Long> expected = new HashMap<>();
        expected.put("Хакасия", 2L);
        expected.put("Якутия", 1L);
        expected.put("Адыгея", 1L);

        Map<String, Long> actual = cities.printCitiesAndRegions();
        Assertions.assertEquals(expected, actual);
    }
}