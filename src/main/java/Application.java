import java.io.IOException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {
        CityListManipulator cities = new CityListManipulator();
        cities.readCitiesListFromFile("src/main/resources/Cities.txt");
        cities.printCitiesList();



    }
}
