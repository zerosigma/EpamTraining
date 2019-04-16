package main.java.ru.elena.TravelAgency.v5.Country.service;

import main.java.ru.elena.TravelAgency.v5.Country.domain.BaseCountry;
import main.java.ru.elena.TravelAgency.v5.common.business.service.BaseService;

public interface CountryService extends BaseService<BaseCountry, Long> {
    BaseCountry find(String name);
}
