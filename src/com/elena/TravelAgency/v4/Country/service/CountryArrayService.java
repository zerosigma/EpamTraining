package com.elena.TravelAgency.v4.Country.service;

import com.elena.TravelAgency.v4.Country.domain.Country;
import com.elena.TravelAgency.v4.Country.search.CountrySearchCondition;

public interface CountryArrayService extends CountryService {
    Country[] search(CountrySearchCondition countrySearchCondition);
}
