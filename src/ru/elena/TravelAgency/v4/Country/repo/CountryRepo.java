package ru.elena.TravelAgency.v4.Country.repo;

import ru.elena.TravelAgency.v4.Country.domain.Country;
import ru.elena.TravelAgency.v4.common.repo.BaseRepo;

public interface CountryRepo extends BaseRepo {
    Country find(String name);
}
