package com.elena.TravelAgency.v5.Country.repo;

import com.elena.TravelAgency.v5.Country.domain.BaseCountry;
import com.elena.TravelAgency.v5.common.business.repo.BaseRepo;

public interface CountryRepo extends BaseRepo<BaseCountry, Long> {
    BaseCountry find(String name);
}
