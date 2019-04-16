package main.java.ru.elena.TravelAgency.v5.City.repo;

import main.java.ru.elena.TravelAgency.v5.City.domain.City;
import main.java.ru.elena.TravelAgency.v5.common.business.repo.BaseRepo;

public interface CityRepo extends BaseRepo<City, Long> {
    City find(String name);
}
