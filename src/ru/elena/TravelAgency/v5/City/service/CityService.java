package ru.elena.TravelAgency.v5.City.service;

import ru.elena.TravelAgency.v5.City.domain.City;
import ru.elena.TravelAgency.v5.common.business.service.BaseService;

public interface CityService extends BaseService<City, Long> {
    City find(String name);
}
