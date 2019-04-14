package ru.elena.TravelAgency.v4.Country.service;

import ru.elena.TravelAgency.v4.City.repo.CityArrayRepo;
import ru.elena.TravelAgency.v4.Country.repo.CountryArrayRepo;
import ru.elena.TravelAgency.v4.City.domain.City;
import ru.elena.TravelAgency.v4.Country.domain.Country;
import ru.elena.TravelAgency.v4.Country.search.CountrySearchCondition;

public class CountryMemoryArrayService implements CountryArrayService {
    private final CountryArrayRepo countryRepo;
    private final CityArrayRepo cityRepo;

    public CountryMemoryArrayService(CountryArrayRepo countryRepo, CityArrayRepo cityRepo) {
        this.countryRepo = countryRepo;
        this.cityRepo = cityRepo;
    }

    public void add(Country country) {
        if (country != null) {
            countryRepo.add(country);

            if (country.getCities() != null)
                for (City city : country.getCities())
                    cityRepo.add(city);
        }
    }

    public void delete(Long id) {
        if (id != null)
            countryRepo.delete(id);
    }

    public void delete(Country country) {
        if (country != null)
            countryRepo.delete(country);
    }

    public Country find(Long id) {
        if (id != null)
            countryRepo.find(id);

        return null;
    }

    public Country find(String name) {
        if (name != null)
            countryRepo.find(name);

        return null;
    }

    @Override
    public Country[] search(CountrySearchCondition countrySearchCondition) {
        return countryRepo.search(countrySearchCondition);
    }
}
