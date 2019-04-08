package com.elena.TravelAgency.v5.City.repo;

import com.elena.TravelAgency.v5.City.domain.City;
import com.elena.TravelAgency.v5.City.search.CitySearchCondition;

public interface CityArrayRepo extends CityRepo {
    City[] search(CitySearchCondition citySearchCondition);
}
