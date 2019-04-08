package com.elena.TravelAgency.v5.Country.repo;

import com.elena.TravelAgency.v5.Country.domain.BaseCountry;
import com.elena.TravelAgency.v5.Country.search.CountrySearchCondition;

import java.util.List;

public interface CountryCollectionRepo extends CountryRepo {
    List<? extends BaseCountry> search(CountrySearchCondition citySearchCondition);

}
