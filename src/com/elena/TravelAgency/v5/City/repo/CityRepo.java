package com.elena.TravelAgency.v5.City.repo;

import com.elena.TravelAgency.v5.City.domain.City;
import com.elena.TravelAgency.v5.common.business.repo.BaseRepo;

public interface CityRepo extends BaseRepo<City, Long> {
    City find(String name);
}
