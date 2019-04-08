package com.elena.TravelAgency.v5.common.business.application.servicefactory;

import com.elena.TravelAgency.v5.City.repo.CityMemoryCollectionRepo;
import com.elena.TravelAgency.v5.City.service.CityMemoryCollectionService;
import com.elena.TravelAgency.v5.City.service.CityService;
import com.elena.TravelAgency.v5.Country.repo.CountryMemoryCollectionRepo;
import com.elena.TravelAgency.v5.Country.service.CountryMemoryCollectionService;
import com.elena.TravelAgency.v5.Country.service.CountryService;
import com.elena.TravelAgency.v5.Order.repo.OrderMemoryCollectionRepo;
import com.elena.TravelAgency.v5.Order.service.OrderMemoryCollectionService;
import com.elena.TravelAgency.v5.Order.service.OrderService;
import com.elena.TravelAgency.v5.User.repo.UserMemoryCollectionRepo;
import com.elena.TravelAgency.v5.User.service.UserMemoryCollectionService;
import com.elena.TravelAgency.v5.User.service.UserService;

public class MemoryCollectionServiceFactory implements ServiceFactory {
    @Override
    public CityService getCityService() {
        return new CityMemoryCollectionService(new CityMemoryCollectionRepo());
    }

    @Override
    public CountryService getCountryService() {
        return new CountryMemoryCollectionService(new CountryMemoryCollectionRepo(), new CityMemoryCollectionRepo());
    }

    @Override
    public OrderService getOrderService() {
        return new OrderMemoryCollectionService(new OrderMemoryCollectionRepo());
    }

    @Override
    public UserService getUserService() {
        return new UserMemoryCollectionService(new UserMemoryCollectionRepo(), new OrderMemoryCollectionRepo());
    }
}
