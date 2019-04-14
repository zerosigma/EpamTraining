package ru.elena.TravelAgency.v6.City.repo;

import ru.elena.TravelAgency.v5.City.domain.City;
import ru.elena.TravelAgency.v5.common.business.repo.BaseRepo;

public interface CityRepo extends BaseRepo<City, Long> {
    City find(String name);
}
