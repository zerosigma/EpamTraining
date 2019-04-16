package main.java.ru.elena.TravelAgency.v4.City.repo;

import main.java.ru.elena.TravelAgency.v4.City.domain.City;
import main.java.ru.elena.TravelAgency.v4.common.repo.BaseRepo;

public interface CityRepo extends BaseRepo {
    void add(City city);
    void delete(City city);
    City find(long id);
    City find(String name);
}
