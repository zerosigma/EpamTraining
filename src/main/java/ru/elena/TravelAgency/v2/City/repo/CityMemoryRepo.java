package main.java.ru.elena.TravelAgency.v2.City.repo;

import main.java.ru.elena.TravelAgency.v2.City.City;
import main.java.ru.elena.TravelAgency.v2.Storage.Storage;

import static main.java.ru.elena.TravelAgency.v2.utils.ArrayUtils.ArrayUtils.deleteElement;
import static main.java.ru.elena.TravelAgency.v2.utils.ArrayUtils.ArrayUtils.extendArray;

public class CityMemoryRepo {
    private int cityIndexInStorage = -1;

    public void addCity(City city) {
        if (findIndex(city) == null) {
            if (cityIndexInStorage == Storage.cities.length - 1) {
                extendArray(Storage.cities);
                //City[] newCities = new City[cities.length * 2];
                //System.arraycopy(cities, 0, newCities, 0, cities.length);
                //cities = newCities;
            }

            cityIndexInStorage++;
            Storage.cities[cityIndexInStorage] = city;
        }
    }

    public void deleteCity(Long id) {
        Integer cityIndex = findIndex(id);

        if (cityIndex != null) {
            deleteElement(Storage.cities, cityIndex);
            cityIndexInStorage--;
        }
    }

    public void deleteCity(City city) {
        Integer cityIndex = findIndex(city);

        if (cityIndex != null) {
            deleteElement(Storage.cities, cityIndex);
            cityIndexInStorage--;
        }
    }

    public City findCity(Long id) {
        for (City city : Storage.cities)
            if (city.getId().equals(id))
                return city;

        return null;
    }

    public City findCity(String name) {
        for (City city : Storage.cities)
            if (city.getName().equals(name))
                return city;

        return null;
    }

    private Integer findIndex(Long id) {
        for (int i = 0; i < Storage.cities.length; i++)
            if (Storage.cities[i].getId().equals(id))
                return i;

         return null;
    }

    private Integer findIndex(City city) {
        for (int i = 0; i < Storage.cities.length; i++)
            if (Storage.cities[i].equals(city))
                return i;

        return null;
    }
}
