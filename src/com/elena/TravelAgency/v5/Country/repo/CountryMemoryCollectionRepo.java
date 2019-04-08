package com.elena.TravelAgency.v5.Country.repo;

import com.elena.TravelAgency.v5.Country.domain.BaseCountry;
import com.elena.TravelAgency.v5.Country.search.CountrySearchCondition;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.elena.TravelAgency.v5.Storage.GlobalIDGenerator.generateNextValue;
import static com.elena.TravelAgency.v5.Storage.Storage.countriesList;

public class CountryMemoryCollectionRepo implements CountryCollectionRepo {
    @Override
    public void insert(BaseCountry country) {
        country.setId(generateNextValue());
        countriesList.add(country);
    }

    @Override
    public void delete(BaseCountry country) {
        BaseCountry countryElem = findByEntity(country);

        if (countryElem != null)
            countriesList.remove(country);
    }

    @Override
    public void update(BaseCountry entity) {

    }

    @Override
    public BaseCountry findByID(Long id) {
        return findByIndex(id);
    }

    @Override
    public BaseCountry find(String name) {
        for (BaseCountry country : countriesList)
            if (country.getName().equals(name))
                return country;

        return null;
    }

    @Override
    public void deleteByID(Long id) {
        BaseCountry country = findByID(id);

        if (country != null) {
            countriesList.remove(country);
        }
    }

    @Override
    public void insert(Collection<BaseCountry> countries) {
        countries.forEach(this::insert);
    }

    private BaseCountry findByIndex(long id) {
        for (BaseCountry country : countriesList)
            if (Long.valueOf(id).equals(country.getId()))
                return country;

        return null;
    }

    private BaseCountry findByEntity(BaseCountry countryToFind) {
        for (BaseCountry country : countriesList)
            if (country.equals(countryToFind))
                return country;

        return null;
    }

    @Override
    public List<? extends BaseCountry> search(CountrySearchCondition countrySearchCondition) {
        if (countrySearchCondition.searchById())
            return Collections.singletonList(findByID(countrySearchCondition.getId()));
        else {
            List<BaseCountry> result = new ArrayList<>();

            for (BaseCountry country : countriesList) {
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
