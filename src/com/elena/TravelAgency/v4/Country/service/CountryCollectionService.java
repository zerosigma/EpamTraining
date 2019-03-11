package com.elena.TravelAgency.v4.Country.service;

import com.elena.TravelAgency.v4.Country.domain.Country;
import com.elena.TravelAgency.v4.Country.search.CountrySearchCondition;

import java.util.List;

public interface CountryCollectionService extends CountryService {
    List<Country> search(CountrySearchCondition countrySearchCondition);
}
