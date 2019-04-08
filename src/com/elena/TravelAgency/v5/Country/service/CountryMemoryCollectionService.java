package com.elena.TravelAgency.v5.Country.service;

import com.elena.TravelAgency.v5.City.domain.City;
import com.elena.TravelAgency.v5.City.repo.CityCollectionRepo;
import com.elena.TravelAgency.v5.Country.domain.BaseCountry;
import com.elena.TravelAgency.v5.Country.repo.CountryCollectionRepo;
import com.elena.TravelAgency.v5.Country.search.CountrySearchCondition;

import java.util.Collection;
import java.util.List;

public class CountryMemoryCollectionService implements CountryCollectionService {
    private final CountryCollectionRepo countryRepo;
    private final CityCollectionRepo cityRepo;

    public CountryMemoryCollectionService(CountryCollectionRepo countryRepo, CityCollectionRepo cityRepo) {
        this.countryRepo = countryRepo;
        this.cityRepo = cityRepo;
    }

    public void insert(BaseCountry country) {
        if (country != null) {
            countryRepo.insert(country);

            if (country.getCities() != null)
                for (City city : country.getCities()) {
                    city.setIdCountry(country.getId());
                    cityRepo.insert(city);
                }
        }
    }

    @Override
    public void insert(Collection<BaseCountry> countries) {
        if (!countries.isEmpty())
            countryRepo.insert(countries);
    }

    public void deleteByID(Long id) {
        if (id != null)
            countryRepo.deleteByID(id);
    }

    public void delete(BaseCountry country) {
        if (country != null)
            countryRepo.delete(country);
    }

    @Override
    public void update(BaseCountry country) {
        if (country.getId() != null)
            countryRepo.update(country);
    }

    public BaseCountry findByID(Long id) {
        if (id != null)
            countryRepo.findByID(id);

        return null;
    }

    public BaseCountry find(String name) {
        if (name != null)
            countryRepo.find(name);

        return null;
    }

    @Override
    public List<? extends BaseCountry> search(CountrySearchCondition countrySearchCondition) {
        return countryRepo.search(countrySearchCondition);
    }
}
