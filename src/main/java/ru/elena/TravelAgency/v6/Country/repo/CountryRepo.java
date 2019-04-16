package main.java.ru.elena.TravelAgency.v6.Country.repo;

import main.java.ru.elena.TravelAgency.v5.Country.domain.BaseCountry;
import main.java.ru.elena.TravelAgency.v5.common.business.repo.BaseRepo;

public interface CountryRepo extends BaseRepo<BaseCountry, Long> {
    BaseCountry find(String name);
}
