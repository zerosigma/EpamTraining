package com.elena.TravelAgency.v3.City.service;

import com.elena.TravelAgency.v3.City.City;
import com.elena.TravelAgency.v3.City.repo.CityMemoryRepo;

public class CityMemoryService implements CityService {
    private CityMemoryRepo cityMemoryRepo = new CityMemoryRepo();

    public void add(City city) {
        cityMemoryRepo.add(city);
    }

    public void delete(Long id) {
        cityMemoryRepo.delete(id);
    }

    public void delete(City city) {
        cityMemoryRepo.delete(city);
    }

    public void find(Long id) {
        cityMemoryRepo.find(id);
    }

    public void find(String name) {
        cityMemoryRepo.find(name);
    }
}
