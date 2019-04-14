package ru.elena.TravelAgency.v3.City.service;

import ru.elena.TravelAgency.v3.City.City;
import ru.elena.TravelAgency.v3.City.repo.CityMemoryRepo;

public class CityMemoryService implements CityService {
    private final CityMemoryRepo cityMemoryRepo = new CityMemoryRepo();

    public void add(City city) {
        if (city != null)
            cityMemoryRepo.add(city);
    }

    public void delete(Long id) {
        if ( id != null)
            cityMemoryRepo.delete(id);
    }

    public void delete(City city) {
        if (city != null)
            cityMemoryRepo.delete(city);
    }

    public void find(Long id) {
        if (id != null)
            cityMemoryRepo.find(id);
    }

    public void find(String name) {
        if (name != null)
            cityMemoryRepo.find(name);
    }
}
