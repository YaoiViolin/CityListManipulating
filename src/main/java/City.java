
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

    @Override
    public String toString() {
        return String.format("City{name='%s', region='%s', district='%s', population='%d', foundation='%d",
                this.name, this.region, this.district, this.population, this.foundation);
    }
}
