package com.elena.TravelAgency.v4.City.repo;

import com.elena.TravelAgency.v4.City.domain.City;
import com.elena.TravelAgency.v4.City.search.CitySearchCondition;

public interface CityArrayRepo extends CityRepo {
    City[] search(CitySearchCondition citySearchCondition);
}
