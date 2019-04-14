package ru.elena.TravelAgency.v6.Country.service;

import ru.elena.TravelAgency.v5.Country.domain.BaseCountry;
import ru.elena.TravelAgency.v5.Country.search.CountrySearchCondition;
import ru.elena.TravelAgency.v5.Country.service.CountryService;

import java.util.List;

public interface CountryCollectionService extends CountryService {
    List<? extends BaseCountry> search(CountrySearchCondition countrySearchCondition);
}
