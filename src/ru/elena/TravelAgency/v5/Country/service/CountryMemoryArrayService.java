package ru.elena.TravelAgency.v5.Country.service;

import ru.elena.TravelAgency.v5.City.domain.City;
import ru.elena.TravelAgency.v5.City.repo.CityArrayRepo;
import ru.elena.TravelAgency.v5.Country.domain.BaseCountry;
import ru.elena.TravelAgency.v5.Country.repo.CountryArrayRepo;
import ru.elena.TravelAgency.v5.Country.search.CountrySearchCondition;

import java.util.Collection;

public class CountryMemoryArrayService implements CountryArrayService {
    private final CountryArrayRepo countryRepo;
    private final CityArrayRepo cityRepo;

    public CountryMemoryArrayService(CountryArrayRepo countryRepo, CityArrayRepo cityRepo) {
        this.countryRepo = countryRepo;
        this.cityRepo = cityRepo;
    }

    public BaseCountry insert(BaseCountry country) {
        if (country != null) {
            countryRepo.insert(country);

            if (country.getCities() != null)
                for (City city : country.getCities()) {
                    city.setIdCountry(country.getId());
                    cityRepo.insert(city);
                }
        }

        return country;
    }

    @Override
    public void insert(Collection<BaseCountry> countries) {
        if (!countries.isEmpty())
            countryRepo.insert(countries);
    }

    public void deleteByID(Long id) {
        if (id != null)
            countryRepo.deleteByID(id);
    }

    public void delete(BaseCountry country) {
        if (country != null)
            countryRepo.delete(country);
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
    public BaseCountry[] search(CountrySearchCondition countrySearchCondition) {
        return countryRepo.search(countrySearchCondition);
    }
}
