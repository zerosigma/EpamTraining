package com.elena.TravelAgency.v5.Country.service;

import com.elena.TravelAgency.v5.Country.domain.BaseCountry;
import com.elena.TravelAgency.v5.Country.search.CountrySearchCondition;

public interface CountryArrayService extends CountryService {
    BaseCountry[] search(CountrySearchCondition countrySearchCondition);
}
