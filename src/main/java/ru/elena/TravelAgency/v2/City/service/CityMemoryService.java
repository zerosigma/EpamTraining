package main.java.ru.elena.TravelAgency.v2.City.service;

import main.java.ru.elena.TravelAgency.v2.City.City;
import main.java.ru.elena.TravelAgency.v2.City.repo.CityMemoryRepo;

public class CityMemoryService {
    private CityMemoryRepo cityMemoryRepo = new CityMemoryRepo();

    public void addCity(City city) {
        cityMemoryRepo.addCity(city);
    }

    public void deleteCity(Long id) {
        cityMemoryRepo.deleteCity(id);
    }

    public void deleteCity(City city) {
        cityMemoryRepo.deleteCity(city);
    }

    public void findCity(Long id) {
        cityMemoryRepo.findCity(id);
    }

    public void findCity(String name) {
        cityMemoryRepo.findCity(name);
    }
}
