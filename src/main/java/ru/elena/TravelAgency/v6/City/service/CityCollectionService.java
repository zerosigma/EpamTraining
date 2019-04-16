package main.java.ru.elena.TravelAgency.v6.City.service;

import main.java.ru.elena.TravelAgency.v6.City.domain.City;
import main.java.ru.elena.TravelAgency.v6.City.search.CitySearchCondition;

import java.util.List;

public interface CityCollectionService extends CityService {
    List<City> search(CitySearchCondition citySearchCondition);
}
