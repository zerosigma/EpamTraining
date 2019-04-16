package main.java.ru.elena.TravelAgency.v5.Country.service;

import main.java.ru.elena.TravelAgency.v5.Country.domain.BaseCountry;
import main.java.ru.elena.TravelAgency.v5.Country.search.CountrySearchCondition;

public interface CountryArrayService extends CountryService {
    BaseCountry[] search(CountrySearchCondition countrySearchCondition);
}
