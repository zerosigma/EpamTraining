package com.elena.TravelAgency.v5.City.service;

import com.elena.TravelAgency.v5.City.domain.City;
import com.elena.TravelAgency.v5.City.search.CitySearchCondition;

public interface CityArrayService extends CityService {
    City[] search(CitySearchCondition citySearchCondition);
}
