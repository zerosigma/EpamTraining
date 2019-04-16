package main.java.ru.elena.TravelAgency.v4.City.service;

import main.java.ru.elena.TravelAgency.v4.City.domain.City;
import main.java.ru.elena.TravelAgency.v4.City.search.CitySearchCondition;

public interface CityArrayService extends CityService {
    City[] search(CitySearchCondition citySearchCondition);
}
