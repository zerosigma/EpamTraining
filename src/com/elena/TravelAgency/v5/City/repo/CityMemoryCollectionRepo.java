package com.elena.TravelAgency.v5.City.repo;

import com.elena.TravelAgency.v5.City.domain.City;
import com.elena.TravelAgency.v5.City.search.CitySearchCondition;
import com.elena.TravelAgency.v5.Storage.GlobalIDGenerator;
import com.elena.TravelAgency.v5.Storage.SequenceGenerator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.elena.TravelAgency.v5.Storage.GlobalIDGenerator.generateNextValue;
import static com.elena.TravelAgency.v5.Storage.Storage.citiesList;

public class CityMemoryCollectionRepo implements CityCollectionRepo {
    @Override
    public void insert(City city) {
        city.setId(generateNextValue());
        citiesList.add(city);
    }

    @Override
    public void insert(Collection<City> cities) {
        cities.forEach(this::insert);
    }

    @Override
    public void deleteByID(Long id) {
        City city = findByID(id);

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
    public void update(City entity) {

    }

    @Override
    public City findByID(Long id) {
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
            return Collections.singletonList(findByID(citySearchCondition.getId()));
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
