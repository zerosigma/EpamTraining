package com.elena.TravelAgency.v4.City.repo;

import com.elena.TravelAgency.v4.City.domain.City;
import com.elena.TravelAgency.v4.City.search.CitySearchCondition;

import static com.elena.TravelAgency.v4.Storage.Storage.cities;
import static com.elena.TravelAgency.v4.common.utils.ArrayUtils.deleteElement;

public class CityMemoryArrayRepo implements CityArrayRepo {
    private static final City[] EMPTY_CITY_ARRAY = new City[0];
    private int cityIndexInStorage = -1;

    @Override
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

    @Override
    public void delete(long id) {
        Integer cityIndex = findIndex(id);

        if (cityIndex != null) {
            deleteElement(cities, cityIndex);
            cityIndexInStorage--;
        }
    }

    @Override
    public void delete(City city) {
        Integer cityIndex = findIndex(city);

        if (cityIndex != null) {
            deleteElement(cities, cityIndex);
            cityIndexInStorage--;
        }
    }

    @Override
    public City find(long id) {
        for (City city : cities)
            if (city.getId().equals(id))
                return city;

        return null;
    }

    @Override
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

    @Override
    public City[] search(CitySearchCondition citySearchCondition) {
        if (citySearchCondition.searchById())
            return new City[]{find(citySearchCondition.getId())};
        else {
            City[] result = new City[cities.length];
            int resultIndex = 0;

            for (City city : cities)
                if (city != null) {
                    boolean found = true;

                    if (citySearchCondition.searchByCityName())
                        found = citySearchCondition.getName().equals(city.getName());

                    if (found) {
                        result[resultIndex] = city;
                        resultIndex++;
                    }
                }

            if (resultIndex > 0) {
                City[] returnableResult = new City[resultIndex];
                System.arraycopy(result, 0, returnableResult, 0, resultIndex);
                return returnableResult;
            }

            return EMPTY_CITY_ARRAY;
        }
    }
}
