package com.elena.TravelAgency.v5.Country.repo;

import com.elena.TravelAgency.v5.Country.domain.BaseCountry;
import com.elena.TravelAgency.v5.Country.search.CountrySearchCondition;

public interface CountryArrayRepo extends CountryRepo {
    BaseCountry[] search(CountrySearchCondition countrySearchCondition);
}
