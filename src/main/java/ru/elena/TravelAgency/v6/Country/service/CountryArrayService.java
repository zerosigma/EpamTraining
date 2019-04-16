package main.java.ru.elena.TravelAgency.v6.Country.service;

import main.java.ru.elena.TravelAgency.v5.Country.domain.BaseCountry;
import main.java.ru.elena.TravelAgency.v5.Country.search.CountrySearchCondition;
import main.java.ru.elena.TravelAgency.v5.Country.service.CountryService;

public interface CountryArrayService extends CountryService {
    BaseCountry[] search(CountrySearchCondition countrySearchCondition);
}
