package com.elena.TravelAgency.v4.common.application.servicefactory;

import com.elena.TravelAgency.v4.City.service.CityService;
import com.elena.TravelAgency.v4.Country.service.CountryService;
import com.elena.TravelAgency.v4.Order.service.OrderService;
import com.elena.TravelAgency.v4.User.service.UserService;

public interface ServiceFactory {
    CityService getCityService();
    CountryService getCountryService();
    OrderService getOrderService();
    UserService getUserService();
}
