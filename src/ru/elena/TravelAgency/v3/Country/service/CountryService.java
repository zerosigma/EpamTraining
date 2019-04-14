package ru.elena.TravelAgency.v3.Country.service;

import ru.elena.TravelAgency.v3.Country.Country;
import ru.elena.TravelAgency.v3.common.service.BaseService;

public interface CountryService extends BaseService {
    void add(Country country);
    void delete(Country country);
    void find(String name);
}