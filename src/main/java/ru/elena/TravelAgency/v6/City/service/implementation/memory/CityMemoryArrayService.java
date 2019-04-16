package main.java.ru.elena.TravelAgency.v6.City.service.implementation.memory;

import main.java.ru.elena.TravelAgency.v6.City.domain.City;
import main.java.ru.elena.TravelAgency.v6.City.repo.CityArrayRepo;
import main.java.ru.elena.TravelAgency.v6.City.search.CitySearchCondition;
import main.java.ru.elena.TravelAgency.v6.City.service.CityArrayService;
import main.java.ru.elena.TravelAgency.v6.common.business.exception.BaseTravelAgencyCheckedException;

import java.util.Collection;
import java.util.Optional;

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
        if (cities != null && !cities.isEmpty())
            cityRepo.insert(cities);
    }

    @Override
    public void delete(City city) throws BaseTravelAgencyCheckedException {
        if (city != null && city.getId() != null)
            deleteByID(city.getId());
    }

    public void deleteByID(Long id) {
        if (id != null)
            cityRepo.deleteByID(id);
    }

    @Override
    public void update(City city) {
        if (city.getId() != null)
            cityRepo.update(city);
    }

    public Optional<City> findByID(Long id) {
        if (id != null)
            return cityRepo.findByID(id);

        return Optional.empty();
    }

    public Optional<City> find(String name) {
        if (name != null)
           return cityRepo.find(name);

        return Optional.empty();
    }

    @Override
    public City[] search(CitySearchCondition citySearchCondition) {
        return cityRepo.search(citySearchCondition);
    }
}
