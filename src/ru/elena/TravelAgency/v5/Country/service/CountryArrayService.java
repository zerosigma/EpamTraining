package ru.elena.TravelAgency.v5.Country.service;

import ru.elena.TravelAgency.v5.Country.domain.BaseCountry;
import ru.elena.TravelAgency.v5.Country.search.CountrySearchCondition;

public interface CountryArrayService extends CountryService {
    BaseCountry[] search(CountrySearchCondition countrySearchCondition);
}
