package ru.elena.TravelAgency.v4.Country.service;

import ru.elena.TravelAgency.v4.Country.domain.Country;
import ru.elena.TravelAgency.v4.Country.search.CountrySearchCondition;

import java.util.List;

public interface CountryCollectionService extends CountryService {
    List<Country> search(CountrySearchCondition countrySearchCondition);
}
