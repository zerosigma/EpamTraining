package ru.elena.TravelAgency.v3.City.service;

import ru.elena.TravelAgency.v3.City.City;
import ru.elena.TravelAgency.v3.common.service.BaseService;

public interface CityService extends BaseService {
    void add(City city);
    void delete(City city);
    void find(String name);
}