package main.java.ru.elena.TravelAgency.v3.City.service;

import main.java.ru.elena.TravelAgency.v3.City.City;
import main.java.ru.elena.TravelAgency.v3.common.service.BaseService;

public interface CityService extends BaseService {
    void add(City city);
    void delete(City city);
    void find(String name);
}
