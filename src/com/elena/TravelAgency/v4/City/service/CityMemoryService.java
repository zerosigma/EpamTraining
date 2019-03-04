package com.elena.TravelAgency.v4.City.service;

import com.elena.TravelAgency.v4.City.repo.CityRepo;
import com.elena.TravelAgency.v4.City.domain.City;

public class CityMemoryService implements CityService {
    private final CityRepo cityRepo;

    public void add(City city) {
        if (city != null)
            cityRepo.add(city);
    }

    public void delete(Long id) {
        if ( id != null)
            cityRepo.delete(id);
    }

    public void delete(City city) {
        if (city != null)
            cityRepo.delete(city);
    }

    public void find(Long id) {
        if (id != null)
            cityRepo.find(id);
    }

    public void find(String name) {
        if (name != null)
            cityRepo.find(name);
    }
}
