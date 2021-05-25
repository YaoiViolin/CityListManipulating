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

    public void maxPopulationSearch() {
        City[] citiesArray = cities.toArray(new City[cities.size()]);
        int max = Integer.MIN_VALUE;
        int index = 0;

        for (int i = 0; i < citiesArray.length; i++) {
            if (max < citiesArray[i].getPopulation()) {
                max = citiesArray[i].getPopulation();
                index = i;
            }
        }
        System.out.printf("[%d] = %d\n", index + 1, max);
    }

    public void printCitiesAndRegions () {
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
