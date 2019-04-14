package ru.elena.TravelAgency.v5.Country.repo;

import ru.elena.TravelAgency.v5.Country.domain.BaseCountry;
import ru.elena.TravelAgency.v5.Country.search.CountrySearchCondition;

import java.util.List;

public interface CountryCollectionRepo extends CountryRepo {
    List<? extends BaseCountry> search(CountrySearchCondition citySearchCondition);

}
