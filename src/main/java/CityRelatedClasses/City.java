package CityRelatedClasses;

import java.util.Objects;

public class City {
    private String name;
    private String region;
    private String district;
    private int population;
    private int foundation;

    public City(String name, String region, String district, int population, int foundation) {
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getDistrict() {
        return district;
    }

    public int getPopulation() {
        return population;
    }

    public int getFoundation() {
        return foundation;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                ", foundation=" + foundation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return getPopulation() == city.getPopulation() && getFoundation() == city.getFoundation() && getName().equals(city.getName()) && getRegion().equals(city.getRegion()) && getDistrict().equals(city.getDistrict());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getRegion(), getDistrict(), getPopulation(), getFoundation());
    }
}
