package main.java.ru.elena.TravelAgency.v6.Country.service;

import main.java.ru.elena.TravelAgency.v6.Country.domain.BaseCountry;
import main.java.ru.elena.TravelAgency.v6.common.solution.service.BaseService;

import java.util.Optional;

public interface CountryService extends BaseService<BaseCountry, Long> {
   Optional<BaseCountry> find(String name);
}
