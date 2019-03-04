package com.elena.TravelAgency.v4.City.repo;

import com.elena.TravelAgency.v4.City.domain.City;
import com.elena.TravelAgency.v4.City.search.CitySearchCondition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.elena.TravelAgency.v4.Storage.Storage.citiesList;

public class CityMemoryCollectionRepo implements CityCollectionRepo {
    @Override
    public void add(City city) {
        if (findByEntity(city) == null)
            citiesList.add(city);
    }

    @Override
    public void delete(long id) {
        City city = find(id);

        if (city != null)
            citiesList.remove(city);
    }

    @Override
    public void delete(City city) {
        City cityElem = findByEntity(city);

        if (cityElem != null)
            citiesList.remove(city);
    }

    @Override
    public City find(long id) {
        return findByIndex(id);
    }

    @Override
    public City find(String name) {
        for (City city : citiesList)
            if (city.getName().equals(name))
                return city;

        return null;
    }

    private City findByIndex(long id) {
        for (City city : citiesList)
            if (Long.valueOf(id).equals(city.getId()))
                return city;

        return null;
    }

    private City findByEntity(City cityToFind) {
        for (City city : citiesList)
            if (city.equals(cityToFind))
                return city;

        return null;
    }

    @Override
    public List<City> search(CitySearchCondition citySearchCondition) {
        if (citySearchCondition.searchById())
            return Collections.singletonList(find(citySearchCondition.getId()));
        else {
            List<City> result = new ArrayList<>();

            for (City city : citiesList) {
                boolean found = true;

                if (citySearchCondition.searchByCityName())
                    found = citySearchCondition.getName().equals(city.getName());

                if (found)
                    result.add(city);
            }

            return Collections.emptyList();
        }
    }
}
