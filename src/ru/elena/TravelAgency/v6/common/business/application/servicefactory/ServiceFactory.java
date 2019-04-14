package ru.elena.TravelAgency.v6.common.business.application.servicefactory;

import ru.elena.TravelAgency.v5.City.service.CityService;
import ru.elena.TravelAgency.v5.Country.service.CountryService;
import ru.elena.TravelAgency.v5.Order.service.OrderService;
import ru.elena.TravelAgency.v5.User.service.UserService;

public interface ServiceFactory {
    CityService getCityService();
    CountryService getCountryService();
    OrderService getOrderService();
    UserService getUserService();
}
