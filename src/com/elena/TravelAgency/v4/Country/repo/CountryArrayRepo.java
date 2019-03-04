package com.elena.TravelAgency.v4.Country.repo;

import com.elena.TravelAgency.v4.Country.domain.Country;
import com.elena.TravelAgency.v4.Country.search.CountrySearchCondition;

public interface CountryArrayRepo extends CountryRepo {
    Country[] search(CountrySearchCondition citySearchCondition);
}
