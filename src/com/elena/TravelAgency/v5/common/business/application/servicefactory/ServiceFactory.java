package com.elena.TravelAgency.v5.common.business.application.servicefactory;

import com.elena.TravelAgency.v5.City.service.CityService;
import com.elena.TravelAgency.v5.Country.service.CountryService;
import com.elena.TravelAgency.v5.Order.service.OrderService;
import com.elena.TravelAgency.v5.User.service.UserService;

public interface ServiceFactory {
    CityService getCityService();
    CountryService getCountryService();
    OrderService getOrderService();
    UserService getUserService();
}
