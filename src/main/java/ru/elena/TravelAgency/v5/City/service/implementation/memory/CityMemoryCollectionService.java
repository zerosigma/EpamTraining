package main.java.ru.elena.TravelAgency.v5.City.service.implementation.memory;

import main.java.ru.elena.TravelAgency.v5.City.domain.City;
import main.java.ru.elena.TravelAgency.v5.City.exception.CityExceptionMeta;
import main.java.ru.elena.TravelAgency.v5.City.exception.checked.CityDeletionException;
import main.java.ru.elena.TravelAgency.v5.City.repo.CityCollectionRepo;
import main.java.ru.elena.TravelAgency.v5.City.search.CitySearchCondition;
import main.java.ru.elena.TravelAgency.v5.City.service.CityCollectionService;
import main.java.ru.elena.TravelAgency.v5.Order.repo.OrderCollectionRepo;
import main.java.ru.elena.TravelAgency.v5.common.business.exception.BaseTravelAgencyCheckedException;

import java.util.Collection;
import java.util.List;

public class CityMemoryCollectionService implements CityCollectionService {
    private final CityCollectionRepo cityRepo;
    private final OrderCollectionRepo orderRepo;

    public CityMemoryCollectionService(CityCollectionRepo cityRepo, OrderCollectionRepo orderRepo) {
        this.cityRepo = cityRepo;
        this.orderRepo = orderRepo;
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

    public void deleteByID(Long id) throws BaseTravelAgencyCheckedException {
        if (id != null) {
            boolean noOrdersWithCity = orderRepo.countOrdersWithCity(id) == 0;

            if (noOrdersWithCity)
                cityRepo.deleteByID(id);
            else
                throw new CityDeletionException(CityExceptionMeta.CITY_DELETION_CONSTRAINT_ERROR);
        }
    }

    public void delete(City city) throws BaseTravelAgencyCheckedException {
        if (city != null && city.getId() != null)
            deleteByID(city.getId());
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
    public List<City> search(CitySearchCondition citySearchCondition) {
        return cityRepo.search(citySearchCondition);
    }
}
