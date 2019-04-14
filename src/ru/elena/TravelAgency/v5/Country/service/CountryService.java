package ru.elena.TravelAgency.v5.Country.service;

import ru.elena.TravelAgency.v5.Country.domain.BaseCountry;
import ru.elena.TravelAgency.v5.common.business.service.BaseService;

public interface CountryService extends BaseService<BaseCountry, Long> {
    BaseCountry find(String name);
}
