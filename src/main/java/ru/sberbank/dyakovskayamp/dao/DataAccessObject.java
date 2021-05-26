package ru.sberbank.dyakovskayamp.dao;

import ru.sberbank.dyakovskayamp.db.CityDataBase;
import ru.sberbank.dyakovskayamp.service.City;

import java.util.ArrayList;
import java.util.List;

public class DataAccessObject {
    private final CityDataBase dataBaseInstance;

    public DataAccessObject(CityDataBase dataBaseInstance) {
        this.dataBaseInstance = dataBaseInstance;
        dataBaseInstance.cities = new ArrayList<>();
    }

    public List<City> getCities() {
        return dataBaseInstance.cities;
    }

    public void add(City city) {
        dataBaseInstance.cities.add(city);
    }
}
