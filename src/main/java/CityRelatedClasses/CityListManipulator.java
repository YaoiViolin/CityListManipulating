package CityRelatedClasses;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Класс, реализующий все требуемые операции со списков городов
 *
 * @author Дьяковская Маргарита
 * @version 1.4

 */

public class CityListManipulator {
    private List<City> cities;

    public CityListManipulator() {
        cities = new ArrayList<>();
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public void readCitiesListFromFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        while(scanner.hasNext()){
            cities.add(parseLineToCity(scanner.nextLine()));
        }
        scanner.close();
    }

    public void printCitiesList(List<City> list) {
        for (City city :
                list) {
            System.out.println(city);
        }
    }

    public List<City> nameSorting () {
        List<City> sorted = new ArrayList<>(cities);
        Comparator<City> names = Comparator.comparing(city -> city.getName().toLowerCase(Locale.ROOT));
        sorted.sort(names.reversed());
        return sorted;
    }

    public List<City> districtAndNameSorting() {
        List<City> sorted = new ArrayList<>(cities);
        Comparator<City> namesAndRegions = Comparator.comparing(City::getDistrict);
        Comparator<City> names = Comparator.comparing(City::getName);
        sorted.sort(namesAndRegions.thenComparing(names).reversed());
        return sorted;
    }

    public String maxPopulationSearch() {
        City[] citiesArray = cities.toArray(new City[cities.size()]);
        int max = Integer.MIN_VALUE;
        int index = 0;

        for (int i = 0; i < citiesArray.length; i++) {
            if (max < citiesArray[i].getPopulation()) {
                max = citiesArray[i].getPopulation();
                index = i;
            }
        }
        return String.format("[%d] = %d", index + 1, max);
    }

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

    private City parseLineToCity(String line) {
        String[] cityProps = line.split(";");
        return new City(cityProps[1],
                cityProps[2],
                cityProps[3],
                Integer.parseInt(cityProps[4]),
                Integer.parseInt(cityProps[5]));
    }
}
