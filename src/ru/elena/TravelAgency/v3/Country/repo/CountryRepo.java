package ru.elena.TravelAgency.v3.Country.repo;

import ru.elena.TravelAgency.v3.Country.Country;
import ru.elena.TravelAgency.v3.common.repo.BaseRepo;

public interface CountryRepo extends BaseRepo {
    void add(Country country);
    void delete(Country country);
    Country find(long id);
    Country find(String name);
}
