package main.java.ru.elena.TravelAgency.v6.Country.service.implementation.memory;

import main.java.ru.elena.TravelAgency.v6.Country.exception.CountryExceptionMeta;
import main.java.ru.elena.TravelAgency.v6.City.service.CityArrayService;
import main.java.ru.elena.TravelAgency.v6.Country.domain.BaseCountry;
import main.java.ru.elena.TravelAgency.v6.Country.exception.checked.CountryDeletionException;
import main.java.ru.elena.TravelAgency.v6.Country.repo.CountryArrayRepo;
import main.java.ru.elena.TravelAgency.v6.Country.search.CountrySearchCondition;
import main.java.ru.elena.TravelAgency.v6.Country.service.CountryArrayService;
import main.java.ru.elena.TravelAgency.v6.Order.repo.OrderArrayRepo;
import main.java.ru.elena.TravelAgency.v6.common.business.exception.BaseTravelAgencyCheckedException;

import java.util.Collection;
import java.util.Optional;

public class CountryMemoryArrayService implements CountryArrayService {
    private final CountryArrayRepo countryRepo;
    private final CityArrayService cityService;
    private final OrderArrayRepo orderRepo;


    public CountryMemoryArrayService(CountryArrayRepo countryRepo, CityArrayService cityService, OrderArrayRepo orderRepo) {
        this.countryRepo = countryRepo;
        this.cityService = cityService;
        this.orderRepo = orderRepo;
    }

    @Override
    public BaseCountry insert(BaseCountry country) {
        if (country != null) {
            countryRepo.insert(country);

            if (country.getCities() != null && !country.getCities().isEmpty())
                country.getCities().forEach(city -> {
                    city.setIdCountry(country.getId());
                    cityService.insert(city);
                });
        }

        return country;
    }

    @Override
    public void insert(Collection<BaseCountry> countries) {
        if (countries != null && !countries.isEmpty())
            countryRepo.insert(countries);
    }

    @Override
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

    @Override
    public void delete(BaseCountry country) throws BaseTravelAgencyCheckedException {
        if (country != null && country.getId() != null)
            deleteByID(country.getId());
    }

    private void deleteAllCitiesFromCountry(Long id) {
        findByID(id).ifPresent(country -> {
            if (country.getCities() != null && !country.getCities().isEmpty())
                country.getCities().forEach(city -> {
                    try {
                        cityService.deleteByID(city.getId());
                    } catch (BaseTravelAgencyCheckedException e) {
                        e.printStackTrace();
                    }
                });
        });
    }

    @Override
    public void update(BaseCountry country) {
        if (country.getId() != null)
            countryRepo.update(country);
    }

    @Override
    public Optional<BaseCountry> findByID(Long id) {
        if (id != null)
            countryRepo.findByID(id);

        return Optional.empty();
    }

    @Override
    public Optional<BaseCountry> find(String name) {
        if (name != null)
            countryRepo.find(name);

        return Optional.empty();
    }

    @Override
    public BaseCountry[] search(CountrySearchCondition countrySearchCondition) {
        return countryRepo.search(countrySearchCondition);
    }
}
