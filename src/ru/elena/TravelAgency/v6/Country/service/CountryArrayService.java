package ru.elena.TravelAgency.v6.Country.service;

import ru.elena.TravelAgency.v5.Country.domain.BaseCountry;
import ru.elena.TravelAgency.v5.Country.search.CountrySearchCondition;
import ru.elena.TravelAgency.v5.Country.service.CountryService;

public interface CountryArrayService extends CountryService {
    BaseCountry[] search(CountrySearchCondition countrySearchCondition);
}
