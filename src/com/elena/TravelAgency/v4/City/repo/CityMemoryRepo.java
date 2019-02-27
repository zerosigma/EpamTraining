package com.elena.TravelAgency.v4.City.repo;

import com.elena.TravelAgency.v4.City.domain.City;

import static com.elena.TravelAgency.v3.Storage.Storage.cities;
import static com.elena.TravelAgency.v3.common.utils.ArrayUtils.deleteElement;

public class CityMemoryRepo implements CityRepo {
    private int cityIndexInStorage = -1;

    public void add(City city) {
        if (findIndex(city) == null) {
            if (cityIndexInStorage == cities.length - 1) {
                City[] newCities = new City[cities.length * 2];
                System.arraycopy(cities, 0, newCities, 0, cities.length);
                cities = newCities;
            }

            cityIndexInStorage++;
            cities[cityIndexInStorage] = city;
        }
    }

    public void delete(long id) {
        Integer cityIndex = findIndex(id);

        if (cityIndex != null) {
            deleteElement(cities, cityIndex);
            cityIndexInStorage--;
        }
    }

    public void delete(City city) {
        Integer cityIndex = findIndex(city);

        if (cityIndex != null) {
            deleteElement(cities, cityIndex);
            cityIndexInStorage--;
        }
    }

    public City find(long id) {
        for (City city : cities)
            if (city.getId().equals(id))
                return city;

        return null;
    }

    public City find(String name) {
        for (City city : cities)
            if (city.getName().equals(name))
                return city;

        return null;
    }

    private Integer findIndex(long id) {
        for (int i = 0; i < cities.length; i++)
            if (cities[i].getId().equals(id))
                return i;

         return null;
    }

    private Integer findIndex(City city) {
        for (int i = 0; i < cities.length; i++)
            if (cities[i].equals(city))
                return i;

        return null;
    }
}
