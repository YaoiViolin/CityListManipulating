package ru.sberbank.dyakovskayamp.service;

import java.util.Objects;

/**
 * Класс, описывающий город со свойствами
 *
 * @author Дьяковская Маргарита
 * @version 1.1

 */

public class City {
    private long id;
    private String name;
    private String region;
    private String district;
    private int population;
    private int foundation;

    /**
     * Конструктор, принимающий на вход следующие параметры
     * @param name - название города
     * @param region - регион, в котором находится город
     * @param district - федеральный округ, в котором находится город
     * @param population - население города
     * @param foundation - дата основания иои первого упоминания о городе
     */


    public City(long id, String name, String region, String district, int population, int foundation) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    /**
     * Геттеры
     */
    public long getId() { return id; }

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

    /**
     * Переопределение методов по умолчанию
     */

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
