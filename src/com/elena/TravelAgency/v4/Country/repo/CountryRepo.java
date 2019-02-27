package com.elena.TravelAgency.v4.Country.repo;

import com.elena.TravelAgency.v4.Country.domain.Country;
import com.elena.TravelAgency.v4.common.repo.BaseRepo;

public interface CountryRepo extends BaseRepo {
    void add(Country country);
    void delete(Country country);
    Country find(long id);
    Country find(String name);
}
