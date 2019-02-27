package com.elena.TravelAgency.v4.Country.service;

import com.elena.TravelAgency.v4.City.domain.City;
import com.elena.TravelAgency.v4.City.repo.CityMemoryRepo;
import com.elena.TravelAgency.v4.Country.domain.Country;
import com.elena.TravelAgency.v4.Country.repo.CountryMemoryRepo;

public class CountryMemoryService implements CountryService {
    private CountryMemoryRepo countryMemoryRepo = new CountryMemoryRepo();
    private CityMemoryRepo cityMemoryRepo = new CityMemoryRepo();

    public void add(Country country) {
        if (country != null) {
            countryMemoryRepo.add(country);

            if (country.getCities() != null)
                for (City city : country.getCities())
                    cityMemoryRepo.add(city);
        }
    }

    public void delete(Long id) {
        if (id != null)
            countryMemoryRepo.delete(id);
    }

    public void delete(Country country) {
        if (country != null)
            countryMemoryRepo.delete(country);
    }

    public void find(Long id) {
        if (id != null)
            countryMemoryRepo.find(id);
    }

    public void find(String name) {
        if (name != null)
            countryMemoryRepo.find(name);
    }
}
