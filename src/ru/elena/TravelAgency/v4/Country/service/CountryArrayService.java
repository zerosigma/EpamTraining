package ru.elena.TravelAgency.v4.Country.service;

import ru.elena.TravelAgency.v4.Country.domain.Country;
import ru.elena.TravelAgency.v4.Country.search.CountrySearchCondition;

public interface CountryArrayService extends CountryService {
    Country[] search(CountrySearchCondition countrySearchCondition);
}
