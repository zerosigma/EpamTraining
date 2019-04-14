package ru.elena.TravelAgency.v6.Country.repo;

import ru.elena.TravelAgency.v5.Country.domain.BaseCountry;
import ru.elena.TravelAgency.v5.common.business.repo.BaseRepo;

public interface CountryRepo extends BaseRepo<BaseCountry, Long> {
    BaseCountry find(String name);
}
