package comparators;

import city_related_classes.City;
import java.util.Comparator;

public class CityNameComparator implements Comparator<City> {
    @Override
    public int compare(City city1, City city2) {
        return city1.getName().compareTo(city2.getName());
    }
}
