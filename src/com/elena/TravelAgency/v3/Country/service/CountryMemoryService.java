package com.elena.TravelAgency.v3.Country.service;

import com.elena.TravelAgency.v3.City.City;
import com.elena.TravelAgency.v3.City.repo.CityMemoryRepo;
import com.elena.TravelAgency.v3.Country.Country;
import com.elena.TravelAgency.v3.Country.repo.CountryMemoryRepo;

public class CountryMemoryService implements CountryService {
    private CountryMemoryRepo countryMemoryRepo = new CountryMemoryRepo();
    private CityMemoryRepo cityMemoryRepo = new CityMemoryRepo();

    public void add(Country country) {
        countryMemoryRepo.add(country);

        if (country.getCities() != null)
            for (City city : country.getCities())
                cityMemoryRepo.add(city);
    }

    public void delete(Long id) {
        countryMemoryRepo.delete(id);
    }

    public void delete(Country country) {
        countryMemoryRepo.delete(country);
    }

    public void find(Long id) {
        countryMemoryRepo.find(id);
    }

    public void find(String name) {
        countryMemoryRepo.find(name);
    }
}
