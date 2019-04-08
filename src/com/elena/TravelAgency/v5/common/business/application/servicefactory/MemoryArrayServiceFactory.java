package com.elena.TravelAgency.v5.common.business.application.servicefactory;

import com.elena.TravelAgency.v5.City.repo.CityMemoryArrayRepo;
import com.elena.TravelAgency.v5.City.service.CityMemoryArrayService;
import com.elena.TravelAgency.v5.City.service.CityService;
import com.elena.TravelAgency.v5.Country.repo.CountryMemoryArrayRepo;
import com.elena.TravelAgency.v5.Country.service.CountryMemoryArrayService;
import com.elena.TravelAgency.v5.Country.service.CountryService;
import com.elena.TravelAgency.v5.Order.repo.OrderMemoryArrayRepo;
import com.elena.TravelAgency.v5.Order.service.OrderMemoryArrayService;
import com.elena.TravelAgency.v5.Order.service.OrderService;
import com.elena.TravelAgency.v5.User.repo.UserMemoryArrayRepo;
import com.elena.TravelAgency.v5.User.service.UserMemoryArrayService;
import com.elena.TravelAgency.v5.User.service.UserService;

public class MemoryArrayServiceFactory implements ServiceFactory {

    @Override
    public CityService getCityService() {
        return new CityMemoryArrayService(new CityMemoryArrayRepo());
    }

    @Override
    public CountryService getCountryService() {
        return new CountryMemoryArrayService(new CountryMemoryArrayRepo(), new CityMemoryArrayRepo());
    }

    @Override
    public OrderService getOrderService() {
        return new OrderMemoryArrayService(new OrderMemoryArrayRepo());
    }

    @Override
    public UserService getUserService() {
        return new UserMemoryArrayService(new UserMemoryArrayRepo(), new OrderMemoryArrayRepo());
    }
}
