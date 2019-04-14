package ru.elena.TravelAgency.v6.City.repo;

import ru.elena.TravelAgency.v5.City.domain.City;
import ru.elena.TravelAgency.v5.City.repo.CityRepo;
import ru.elena.TravelAgency.v5.City.search.CitySearchCondition;

import java.util.List;

public interface CityCollectionRepo extends CityRepo {
    List<City> search(CitySearchCondition citySearchCondition);
}
