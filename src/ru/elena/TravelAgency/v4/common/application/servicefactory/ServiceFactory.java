package ru.elena.TravelAgency.v4.common.application.servicefactory;

import ru.elena.TravelAgency.v4.City.service.CityService;
import ru.elena.TravelAgency.v4.Country.service.CountryService;
import ru.elena.TravelAgency.v4.Order.service.OrderService;
import ru.elena.TravelAgency.v4.User.service.UserService;

public interface ServiceFactory {
    CityService getCityService();
    CountryService getCountryService();
    OrderService getOrderService();
    UserService getUserService();
}
