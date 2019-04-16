package main.java.ru.elena.TravelAgency.v6.City.service;

import main.java.ru.elena.TravelAgency.v6.City.domain.City;
import main.java.ru.elena.TravelAgency.v6.common.solution.service.BaseService;

import java.util.Optional;

public interface CityService extends BaseService<City, Long> {
    Optional<City> find(String name);
}
