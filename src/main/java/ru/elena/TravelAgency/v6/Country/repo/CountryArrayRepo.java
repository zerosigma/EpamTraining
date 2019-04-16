package main.java.ru.elena.TravelAgency.v6.Country.repo;

import main.java.ru.elena.TravelAgency.v5.Country.domain.BaseCountry;
import main.java.ru.elena.TravelAgency.v5.Country.repo.CountryRepo;
import main.java.ru.elena.TravelAgency.v5.Country.search.CountrySearchCondition;

public interface CountryArrayRepo extends CountryRepo {
    BaseCountry[] search(CountrySearchCondition countrySearchCondition);
}
