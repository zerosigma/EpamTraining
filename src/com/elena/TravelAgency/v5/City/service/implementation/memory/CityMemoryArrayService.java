package com.elena.TravelAgency.v5.City.service.implementation.memory;

import com.elena.TravelAgency.v5.City.domain.City;
import com.elena.TravelAgency.v5.City.repo.CityArrayRepo;
import com.elena.TravelAgency.v5.City.search.CitySearchCondition;
import com.elena.TravelAgency.v5.City.service.CityArrayService;

import java.util.Collection;

public class CityMemoryArrayService implements CityArrayService {
    private final CityArrayRepo cityRepo;

    public CityMemoryArrayService(CityArrayRepo cityRepo) {
        this.cityRepo = cityRepo;
    }

    public City insert(City city) {
        if (city != null)
            cityRepo.insert(city);
        return city;
    }

    @Override
    public void insert(Collection<City> cities) {
        if (!cities.isEmpty())
            cityRepo.insert(cities);
    }

    public void deleteByID(Long id) {
        if (id != null)
            cityRepo.deleteByID(id);
    }

    public void delete(City city) {
        if (city != null)
            cityRepo.delete(city);
    }

    @Override
    public void update(City city) {
        if (city.getId() != null)
            cityRepo.update(city);
    }

    public City findByID(Long id) {
        if (id != null)
            return cityRepo.findByID(id);

        return null;
    }

    public City find(String name) {
        if (name != null)
           return cityRepo.find(name);

        return null;
    }

    @Override
    public City[] search(CitySearchCondition citySearchCondition) {
        return cityRepo.search(citySearchCondition);
    }
}
