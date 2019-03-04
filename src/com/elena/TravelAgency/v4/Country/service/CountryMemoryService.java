package com.elena.TravelAgency.v4.Country.service;

import com.elena.TravelAgency.v4.City.repo.CityRepo;
import com.elena.TravelAgency.v4.Country.repo.CountryRepo;
import com.elena.TravelAgency.v4.City.domain.City;
import com.elena.TravelAgency.v4.Country.domain.Country;

public class CountryMemoryService implements CountryService {
    private final CountryRepo countryRepo;
    private final CityRepo cityRepo;

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

    public void find(Long id) {
        if (id != null)
            countryRepo.find(id);
    }

    public void find(String name) {
        if (name != null)
            countryRepo.find(name);
    }
}
