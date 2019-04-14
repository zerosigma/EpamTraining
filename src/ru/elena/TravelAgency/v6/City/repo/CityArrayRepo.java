package ru.elena.TravelAgency.v6.City.repo;

import ru.elena.TravelAgency.v5.City.domain.City;
import ru.elena.TravelAgency.v5.City.repo.CityRepo;
import ru.elena.TravelAgency.v5.City.search.CitySearchCondition;

public interface CityArrayRepo extends CityRepo {
    City[] search(CitySearchCondition citySearchCondition);
}
