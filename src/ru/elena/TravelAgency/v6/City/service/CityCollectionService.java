package ru.elena.TravelAgency.v6.City.service;

import ru.elena.TravelAgency.v5.City.domain.City;
import ru.elena.TravelAgency.v5.City.search.CitySearchCondition;
import ru.elena.TravelAgency.v5.City.service.CityService;

import java.util.List;

public interface CityCollectionService extends CityService {
    List<City> search(CitySearchCondition citySearchCondition);
}