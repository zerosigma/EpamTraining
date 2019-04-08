package com.elena.TravelAgency.v5.Country.service;

import com.elena.TravelAgency.v5.Country.domain.BaseCountry;
import com.elena.TravelAgency.v5.Country.search.CountrySearchCondition;

import java.util.List;

public interface CountryCollectionService extends CountryService {
    List<? extends BaseCountry> search(CountrySearchCondition countrySearchCondition);
}
