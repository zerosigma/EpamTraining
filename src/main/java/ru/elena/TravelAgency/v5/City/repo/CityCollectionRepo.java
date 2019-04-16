package main.java.ru.elena.TravelAgency.v5.City.repo;

import main.java.ru.elena.TravelAgency.v5.City.domain.City;
import main.java.ru.elena.TravelAgency.v5.City.search.CitySearchCondition;

import java.util.List;

public interface CityCollectionRepo extends CityRepo {
    List<City> search(CitySearchCondition citySearchCondition);
}
