package ru.elena.TravelAgency.v4.Country.repo;

import ru.elena.TravelAgency.v4.Country.domain.Country;
import ru.elena.TravelAgency.v4.Country.search.CountrySearchCondition;

public interface CountryArrayRepo extends CountryRepo {
    Country[] search(CountrySearchCondition countrySearchCondition);
}
