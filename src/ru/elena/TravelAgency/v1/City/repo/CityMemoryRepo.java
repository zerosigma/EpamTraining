package ru.elena.TravelAgency.v1.City.repo;

import ru.elena.TravelAgency.v1.City.City;

import static ru.elena.TravelAgency.v1.Storage.Storage.cities;
import static ru.elena.TravelAgency.v1.utils.ArrayUtils.ArrayUtils.deleteElement;

public class CityMemoryRepo {
    private int cityIndexInStorage = -1;

    public void addCity(City city) {
        if (cityIndexInStorage == cities.length - 1) {
            City[] newCities = new City[cities.length * 2];
            System.arraycopy(cities, 0, newCities, 0, cities.length);
            cities = newCities;
        }

        cityIndexInStorage++;
        cities[cityIndexInStorage] = city;
    }

    public void deleteCity(Long id) {
        Integer cityIndex = findIndex(id);

        if (cityIndex != null) {
            deleteElement(cities, cityIndex);
            cityIndexInStorage--;
        }
    }

    public void deleteCity(City city) {
        Integer cityIndex = findIndex(city);

        if (cityIndex != null) {
            deleteElement(cities, cityIndex);
            cityIndexInStorage--;
        }
    }

    public City findCity(Long id) {
        for (City city : cities)
            if (city.getId().equals(id))
                return city;

        return null;
    }

    public City findCity(String name) {
        for (City city : cities)
            if (city.getName().equals(name))
                return city;

        return null;
    }

    private Integer findIndex(Long id) {
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
