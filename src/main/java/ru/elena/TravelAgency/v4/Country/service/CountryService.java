package main.java.ru.elena.TravelAgency.v4.Country.service;

import main.java.ru.elena.TravelAgency.v4.Country.domain.Country;
import main.java.ru.elena.TravelAgency.v4.common.service.BaseService;

public interface CountryService extends BaseService {
    void add(Country country);
    void delete(Country country);
    Country find(String name);
    Country find(Long id);
}
