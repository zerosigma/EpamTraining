package main.java.ru.elena.TravelAgency.v6.City.repo;

import main.java.ru.elena.TravelAgency.v6.City.domain.City;
import main.java.ru.elena.TravelAgency.v6.City.search.CitySearchCondition;

public interface CityArrayRepo extends CityRepo {
    City[] search(CitySearchCondition citySearchCondition);
}
