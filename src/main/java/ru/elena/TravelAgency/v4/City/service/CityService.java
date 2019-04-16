package main.java.ru.elena.TravelAgency.v4.City.service;

import main.java.ru.elena.TravelAgency.v4.City.domain.City;
import main.java.ru.elena.TravelAgency.v4.common.service.BaseService;

public interface CityService extends BaseService {
    void add(City city);
    void delete(City city);
    City find(String name);
    City find(Long id);
}
