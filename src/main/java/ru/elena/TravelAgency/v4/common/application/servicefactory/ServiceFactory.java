package main.java.ru.elena.TravelAgency.v4.common.application.servicefactory;

import main.java.ru.elena.TravelAgency.v4.City.service.CityService;
import main.java.ru.elena.TravelAgency.v4.Country.service.CountryService;
import main.java.ru.elena.TravelAgency.v4.Order.service.OrderService;
import main.java.ru.elena.TravelAgency.v4.User.service.UserService;

public interface ServiceFactory {
    CityService getCityService();
    CountryService getCountryService();
    OrderService getOrderService();
    UserService getUserService();
}
