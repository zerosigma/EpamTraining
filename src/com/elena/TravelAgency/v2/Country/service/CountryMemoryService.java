package com.elena.TravelAgency.v2.Country.service;

import com.elena.TravelAgency.v2.City.City;
import com.elena.TravelAgency.v2.City.repo.CityMemoryRepo;
import com.elena.TravelAgency.v2.Country.Country;
import com.elena.TravelAgency.v2.Country.repo.CountryMemoryRepo;

public class CountryMemoryService {
    private CountryMemoryRepo countryMemoryRepo = new CountryMemoryRepo();
    private CityMemoryRepo cityMemoryRepo = new CityMemoryRepo();

    public void addCountry(Country country) {
        countryMemoryRepo.addCountry(country);

        if (country.getCities() != null)
            for (City city : country.getCities())
                cityMemoryRepo.addCity(city);
    }

    public void deleteCountry(Long id) {
        countryMemoryRepo.deleteCountry(id);
    }

    public void deleteCountry(Country country) {
        countryMemoryRepo.deleteCountry(country);
    }

    public void findCountry(Long id) {
        countryMemoryRepo.findCountry(id);
    }

    public void findCountry(String name) {
        countryMemoryRepo.findCountry(name);
    }
}
