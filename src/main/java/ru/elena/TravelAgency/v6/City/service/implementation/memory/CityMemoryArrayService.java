package main.java.ru.elena.TravelAgency.v6.City.service.implementation.memory;

import main.java.ru.elena.TravelAgency.v6.City.domain.City;
import main.java.ru.elena.TravelAgency.v6.City.exception.CityExceptionMeta;
import main.java.ru.elena.TravelAgency.v6.City.exception.checked.CityDeletionException;
import main.java.ru.elena.TravelAgency.v6.City.repo.CityArrayRepo;
import main.java.ru.elena.TravelAgency.v6.City.search.CitySearchCondition;
import main.java.ru.elena.TravelAgency.v6.City.service.CityArrayService;
import main.java.ru.elena.TravelAgency.v6.Order.repo.OrderArrayRepo;
import main.java.ru.elena.TravelAgency.v6.common.business.exception.BaseTravelAgencyCheckedException;

import java.util.Collection;
import java.util.Optional;

public class CityMemoryArrayService implements CityArrayService {
    private final CityArrayRepo cityRepo;
    private final OrderArrayRepo orderRepo;

    public CityMemoryArrayService(CityArrayRepo cityRepo, OrderArrayRepo orderRepo) {
        this.cityRepo = cityRepo;
        this.orderRepo = orderRepo;
    }

    @Override
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

    @Override
    public void deleteByID(Long id) throws BaseTravelAgencyCheckedException {
        if (id != null) {
            boolean noOrdersWithCity = orderRepo.countOrdersWithCity(id) == 0;

            if (noOrdersWithCity)
                cityRepo.deleteByID(id);
            else
                throw new CityDeletionException(CityExceptionMeta.CITY_DELETION_CONSTRAINT_ERROR);

        }
    }

    @Override
    public void update(City city) {
        if (city.getId() != null)
            cityRepo.update(city);
    }

    @Override
    public Optional<City> findByID(Long id) {
        if (id != null)
            return cityRepo.findByID(id);

        return Optional.empty();
    }

    @Override
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
