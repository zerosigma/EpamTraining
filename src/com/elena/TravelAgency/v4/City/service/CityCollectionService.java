package com.elena.TravelAgency.v4.City.service;

import com.elena.TravelAgency.v4.City.domain.City;
import com.elena.TravelAgency.v4.City.search.CitySearchCondition;

import java.util.List;

public interface CityCollectionService extends CityService {
    List<City> search(CitySearchCondition citySearchCondition);
}
