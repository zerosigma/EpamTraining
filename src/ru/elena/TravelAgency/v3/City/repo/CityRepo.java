package ru.elena.TravelAgency.v3.City.repo;

import ru.elena.TravelAgency.v3.City.City;
import ru.elena.TravelAgency.v3.common.repo.BaseRepo;

public interface CityRepo extends BaseRepo {
    void add(City city);
    void delete(City city);
    City find(long id);
    City find(String name);
}
