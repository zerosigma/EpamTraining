package main.java.ru.elena.TravelAgency.v4.Country.repo;

import main.java.ru.elena.TravelAgency.v4.Country.domain.Country;
import main.java.ru.elena.TravelAgency.v4.Country.search.CountrySearchCondition;

public interface CountryArrayRepo extends CountryRepo {
    Country[] search(CountrySearchCondition countrySearchCondition);
}
