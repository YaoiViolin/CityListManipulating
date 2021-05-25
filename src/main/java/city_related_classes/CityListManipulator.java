package city_related_classes;

import comparators.CityNameAndDistrictComparator;
import comparators.CityNameComparator;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CityListManipulator {
    private List<City> cities;

    public CityListManipulator() {
        cities = new ArrayList<>();
    }

    public List<City> getCities() {
        return cities;
    }

    public void readCitiesListFromFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        while(scanner.hasNext()){
            cities.add(parseLineToCity(scanner.nextLine()));
        }
        scanner.close();
    }

    public void printCitiesList() {
        for (City city :
                cities) {
            System.out.println(city);
        }
    }

    public void nameSorting () {
        sorting(new CityNameComparator());
    }

    public void districtAndNameSorting() {
        sorting(new CityNameAndDistrictComparator().thenComparing(new CityNameComparator()));
    }


    private City parseLineToCity(String line) {
        String[] cityProps = line.split(";");
        City city = new City(cityProps[1],
                cityProps[2],
                cityProps[3],
                Integer.parseInt(cityProps[4]),
                Integer.parseInt(cityProps[5]));
        return city;
    }

    private void sorting(Comparator<City> comparator) {
        TreeSet<City> sorted = new TreeSet<>(comparator);
        sorted.addAll(cities);
        for (City city :
                sorted) {
            System.out.println(city);
        }
    }
}
