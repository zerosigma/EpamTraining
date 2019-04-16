package main.java.ru.elena.TravelAgency.v5.City.service;

import main.java.ru.elena.TravelAgency.v5.City.domain.City;
import main.java.ru.elena.TravelAgency.v5.City.search.CitySearchCondition;

public interface CityArrayService extends CityService {
    City[] search(CitySearchCondition citySearchCondition);
}
