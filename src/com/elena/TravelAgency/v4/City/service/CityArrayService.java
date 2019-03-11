package com.elena.TravelAgency.v4.City.service;

import com.elena.TravelAgency.v4.City.domain.City;
import com.elena.TravelAgency.v4.City.search.CitySearchCondition;

public interface CityArrayService extends CityService {
    City[] search(CitySearchCondition citySearchCondition);
}
