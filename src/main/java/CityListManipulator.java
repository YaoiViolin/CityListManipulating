import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    private City parseLineToCity(String line) {
        String[] cityProps = line.split(";");
        City city = new City(cityProps[1],
                            cityProps[2],
                            cityProps[3],
                            Integer.parseInt(cityProps[4]),
                            Integer.parseInt(cityProps[5]));
        return city;
    }
}
