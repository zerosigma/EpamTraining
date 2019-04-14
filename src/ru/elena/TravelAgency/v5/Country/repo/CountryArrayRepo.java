package ru.elena.TravelAgency.v5.Country.repo;

import ru.elena.TravelAgency.v5.Country.domain.BaseCountry;
import ru.elena.TravelAgency.v5.Country.search.CountrySearchCondition;

public interface CountryArrayRepo extends CountryRepo {
    BaseCountry[] search(CountrySearchCondition countrySearchCondition);
}
