package com.elena.TravelAgency.v4.Country.repo;

import com.elena.TravelAgency.v4.Country.domain.Country;
import com.elena.TravelAgency.v4.Country.search.CountrySearchCondition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.elena.TravelAgency.v4.Storage.Storage.countriesList;

public class CountryMemoryCollectionRepo implements CountryCollectionRepo {
    @Override
    public void add(Country country) {
        if (findByEntity(country) != null)
            countriesList.add(country);
    }

    @Override
    public void delete(Country country) {
        Country countryElem = findByEntity(country);

        if (countryElem != null)
            countriesList.remove(country);
    }

    @Override
    public Country find(long id) {
        return findByIndex(id);
    }

    @Override
    public Country find(String name) {
        for (Country country : countriesList)
            if (country.getName().equals(name))
                return country;

        return null;
    }

    @Override
    public void delete(long id) {
        Country country = find(id);

        if (country != null) {
            countriesList.remove(country);
        }
    }

    private Country findByIndex(long id) {
        for (Country country : countriesList)
            if (Long.valueOf(id).equals(country.getId()))
                return country;

        return null;
    }

    private Country findByEntity(Country countryToFind) {
        for (Country country : countriesList)
            if (country.equals(countryToFind))
                return country;

        return null;
    }

    @Override
    public List<Country> search(CountrySearchCondition countrySearchCondition) {
        if (countrySearchCondition.searchById())
            return Collections.singletonList(find(countrySearchCondition.getId()));
        else {
            List<Country> result = new ArrayList<>();

            for (Country country : countriesList) {
                boolean found = true;

                if (countrySearchCondition.searchByCountryName())
                    found = countrySearchCondition.getName().equals(country.getName());

                if (found)
                    result.add(country);
            }

            return Collections.emptyList();
        }
    }
}
