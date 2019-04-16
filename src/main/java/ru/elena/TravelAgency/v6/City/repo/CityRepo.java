package main.java.ru.elena.TravelAgency.v6.City.repo;

import main.java.ru.elena.TravelAgency.v6.City.domain.City;
import main.java.ru.elena.TravelAgency.v6.common.solution.repo.BaseRepo;

import java.util.Optional;

public interface CityRepo extends BaseRepo<City, Long> {
    Optional<City> find(String name);
}
