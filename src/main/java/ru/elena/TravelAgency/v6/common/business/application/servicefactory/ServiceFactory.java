package main.java.ru.elena.TravelAgency.v6.common.business.application.servicefactory;

import main.java.ru.elena.TravelAgency.v6.City.service.CityService;
import main.java.ru.elena.TravelAgency.v6.Country.service.CountryService;
import main.java.ru.elena.TravelAgency.v6.Order.service.OrderService;
import main.java.ru.elena.TravelAgency.v6.User.service.UserService;

public interface ServiceFactory {
    CityService getCityService();
    CountryService getCountryService();
    OrderService getOrderService();
    UserService getUserService();
}
