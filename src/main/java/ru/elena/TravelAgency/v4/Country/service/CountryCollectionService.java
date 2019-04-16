package main.java.ru.elena.TravelAgency.v4.Country.service;

import main.java.ru.elena.TravelAgency.v4.Country.domain.Country;
import main.java.ru.elena.TravelAgency.v4.Country.search.CountrySearchCondition;

import java.util.List;

public interface CountryCollectionService extends CountryService {
    List<Country> search(CountrySearchCondition countrySearchCondition);
}
