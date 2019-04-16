package main.java.ru.elena.TravelAgency.v5.City.repo;

import main.java.ru.elena.TravelAgency.v5.City.domain.City;
import main.java.ru.elena.TravelAgency.v5.City.search.CitySearchCondition;

public interface CityArrayRepo extends CityRepo {
    City[] search(CitySearchCondition citySearchCondition);
}
