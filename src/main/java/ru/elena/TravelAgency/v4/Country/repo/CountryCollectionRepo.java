package main.java.ru.elena.TravelAgency.v4.Country.repo;

import main.java.ru.elena.TravelAgency.v4.Country.domain.Country;
import main.java.ru.elena.TravelAgency.v4.Country.search.CountrySearchCondition;

import java.util.List;

public interface CountryCollectionRepo extends CountryRepo {
    List<Country> search(CountrySearchCondition citySearchCondition);

}
