package main.java.ru.elena.TravelAgency.v4.Country.service;

import main.java.ru.elena.TravelAgency.v4.Country.domain.Country;
import main.java.ru.elena.TravelAgency.v4.Country.search.CountrySearchCondition;

public interface CountryArrayService extends CountryService {
    Country[] search(CountrySearchCondition countrySearchCondition);
}
