package main.java.ru.elena.TravelAgency.v3.Country.service;

import main.java.ru.elena.TravelAgency.v3.Country.Country;
import main.java.ru.elena.TravelAgency.v3.common.service.BaseService;

public interface CountryService extends BaseService {
    void add(Country country);
    void delete(Country country);
    void find(String name);
}
