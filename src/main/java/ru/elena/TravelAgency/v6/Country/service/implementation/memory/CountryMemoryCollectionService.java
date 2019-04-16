package main.java.ru.elena.TravelAgency.v6.Country.service.implementation.memory;

import main.java.ru.elena.TravelAgency.v5.City.service.CityCollectionService;
import main.java.ru.elena.TravelAgency.v5.City.domain.City;
import main.java.ru.elena.TravelAgency.v5.Country.domain.BaseCountry;
import main.java.ru.elena.TravelAgency.v5.Country.exception.CountryExceptionMeta;
import main.java.ru.elena.TravelAgency.v5.Country.exception.checked.CountryDeletionException;
import main.java.ru.elena.TravelAgency.v5.Country.repo.CountryCollectionRepo;
import main.java.ru.elena.TravelAgency.v5.Country.search.CountrySearchCondition;
import main.java.ru.elena.TravelAgency.v5.Country.service.CountryCollectionService;
import main.java.ru.elena.TravelAgency.v5.Order.repo.OrderCollectionRepo;
import main.java.ru.elena.TravelAgency.v5.common.business.exception.BaseTravelAgencyCheckedException;

import java.util.Collection;
import java.util.List;

public class CountryMemoryCollectionService implements CountryCollectionService {
    private final CountryCollectionRepo countryRepo;
    private final CityCollectionService cityService;
    private final OrderCollectionRepo orderRepo;

    public CountryMemoryCollectionService(CountryCollectionRepo countryRepo, CityCollectionService cityService, OrderCollectionRepo orderRepo) {
        this.countryRepo = countryRepo;
        this.cityService = cityService;
        this.orderRepo = orderRepo;
    }

    public BaseCountry insert(BaseCountry country) {
        if (country != null) {
            countryRepo.insert(country);

            if (country.getCities() != null)
                for (City city : country.getCities()) {
                    city.setIdCountry(country.getId());
                    cityService.insert(city);
                }
        }

        return country;
    }

    @Override
    public void insert(Collection<BaseCountry> countries) {
        if (!countries.isEmpty())
            countryRepo.insert(countries);
    }

    public void deleteByID(Long id) throws BaseTravelAgencyCheckedException {
        if (id != null) {
            boolean noOrdersWithCountry = orderRepo.countOrdersWithCountry(id) == 0;

            if (noOrdersWithCountry) {
                deleteAllCitiesFromCountry(id);
                countryRepo.deleteByID(id);
            }
            else
                throw new CountryDeletionException(CountryExceptionMeta.COUNTRY_DELETION_CONSTRAINT_ERROR);
        }
    }

    public void delete(BaseCountry country) throws BaseTravelAgencyCheckedException {
        if (country != null && country.getId() != null) {
            deleteByID(country.getId());
        }
    }

    private void deleteAllCitiesFromCountry(Long id) throws BaseTravelAgencyCheckedException {
        BaseCountry country = findByID(id);
        if (country != null && country.getCities() != null)
            for (City city : country.getCities())
                cityService.delete(city);
    }

    @Override
    public void update(BaseCountry country) {
        if (country.getId() != null)
            countryRepo.update(country);
    }

    public BaseCountry findByID(Long id) {
        if (id != null)
            countryRepo.findByID(id);

        return null;
    }

    public BaseCountry find(String name) {
        if (name != null)
            countryRepo.find(name);

        return null;
    }

    @Override
    public List<? extends BaseCountry> search(CountrySearchCondition countrySearchCondition) {
        return countryRepo.search(countrySearchCondition);
    }
}
