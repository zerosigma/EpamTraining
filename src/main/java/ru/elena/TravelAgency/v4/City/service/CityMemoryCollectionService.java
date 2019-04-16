package main.java.ru.elena.TravelAgency.v4.City.service;

import main.java.ru.elena.TravelAgency.v4.City.domain.City;
import main.java.ru.elena.TravelAgency.v4.City.repo.CityCollectionRepo;
import main.java.ru.elena.TravelAgency.v4.City.search.CitySearchCondition;

import java.util.List;

public class CityMemoryCollectionService implements CityCollectionService {
    private final CityCollectionRepo cityRepo;

    public CityMemoryCollectionService(CityCollectionRepo cityRepo) {
        this.cityRepo = cityRepo;
    }

    public void add(City city) {
        if (city != null)
            cityRepo.add(city);
    }

    public void delete(Long id) {
        if (id != null)
            cityRepo.delete(id);
    }

    public void delete(City city) {
        if (city != null)
            cityRepo.delete(city);
    }

    public City find(Long id) {
        if (id != null)
            return cityRepo.find(id);

        return null;
    }

    public City find(String name) {
        if (name != null)
            return cityRepo.find(name);

        return null;
    }

    @Override
    public List<City> search(CitySearchCondition citySearchCondition) {
        return cityRepo.search(citySearchCondition);
    }
}
