package main.java.ru.elena.TravelAgency.v4.City.repo;

import main.java.ru.elena.TravelAgency.v4.City.domain.City;
import main.java.ru.elena.TravelAgency.v4.City.search.CitySearchCondition;

public interface CityArrayRepo extends CityRepo {
    City[] search(CitySearchCondition citySearchCondition);
}
