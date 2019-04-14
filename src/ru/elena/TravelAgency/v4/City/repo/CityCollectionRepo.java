package ru.elena.TravelAgency.v4.City.repo;

import ru.elena.TravelAgency.v4.City.domain.City;
import ru.elena.TravelAgency.v4.City.search.CitySearchCondition;

import java.util.List;

public interface CityCollectionRepo extends CityRepo {
    List<City> search(CitySearchCondition citySearchCondition);
}
