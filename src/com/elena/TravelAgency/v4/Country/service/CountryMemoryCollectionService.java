package com.elena.TravelAgency.v4.Country.service;

import com.elena.TravelAgency.v4.City.domain.City;
import com.elena.TravelAgency.v4.City.repo.CityCollectionRepo;
import com.elena.TravelAgency.v4.Country.domain.Country;
import com.elena.TravelAgency.v4.Country.repo.CountryCollectionRepo;
import com.elena.TravelAgency.v4.Country.search.CountrySearchCondition;

import java.util.List;

public class CountryMemoryCollectionService implements CountryCollectionService {
    private final CountryCollectionRepo countryRepo;
    private final CityCollectionRepo cityRepo;

    public CountryMemoryCollectionService(CountryCollectionRepo countryRepo, CityCollectionRepo cityRepo) {
        this.countryRepo = countryRepo;
        this.cityRepo = cityRepo;
    }

    public void add(Country country) {
        if (country != null) {
            countryRepo.add(country);

            if (country.getCities() != null)
                for (City city : country.getCities())
                    cityRepo.add(city);
        }
    }

    public void delete(Long id) {
        if (id != null)
            countryRepo.delete(id);
    }

    public void delete(Country country) {
        if (country != null)
            countryRepo.delete(country);
    }

    public Country find(Long id) {
        if (id != null)
            countryRepo.find(id);

        return null;
    }

    public Country find(String name) {
        if (name != null)
            countryRepo.find(name);

        return null;
    }

    @Override
    public List<Country> search(CountrySearchCondition countrySearchCondition) {
        return countryRepo.search(countrySearchCondition);
    }
}
