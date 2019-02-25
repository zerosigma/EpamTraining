package com.elena.TravelAgency.v3.Country.repo;

import com.elena.TravelAgency.v3.Country.Country;
import com.elena.TravelAgency.v3.common.repo.BaseRepo;

public interface CountryRepo extends BaseRepo {
    void add(Country country);
    void delete(Country country);
    Country find(Long id);
    Country find(String name);
}
