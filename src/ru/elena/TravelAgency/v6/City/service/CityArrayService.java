package ru.elena.TravelAgency.v6.City.service;

import ru.elena.TravelAgency.v5.City.domain.City;
import ru.elena.TravelAgency.v5.City.search.CitySearchCondition;
import ru.elena.TravelAgency.v5.City.service.CityService;

public interface CityArrayService extends CityService {
    City[] search(CitySearchCondition citySearchCondition);
}
