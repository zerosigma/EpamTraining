package main.java.ru.elena.TravelAgency.v6.Country.repo;

import main.java.ru.elena.TravelAgency.v6.Country.domain.BaseCountry;
import main.java.ru.elena.TravelAgency.v6.common.solution.repo.BaseRepo;

import java.util.Optional;

public interface CountryRepo extends BaseRepo<BaseCountry, Long> {
    Optional<BaseCountry> find(String name);
}
