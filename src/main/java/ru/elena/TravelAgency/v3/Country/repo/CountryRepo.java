package main.java.ru.elena.TravelAgency.v3.Country.repo;

import main.java.ru.elena.TravelAgency.v3.Country.Country;
import main.java.ru.elena.TravelAgency.v3.common.repo.BaseRepo;

public interface CountryRepo extends BaseRepo {
    void add(Country country);
    void delete(Country country);
    Country find(long id);
    Country find(String name);
}
