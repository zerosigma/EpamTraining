package ru.elena.TravelAgency.v5.common.business.application.servicefactory;

import ru.elena.TravelAgency.v5.City.repo.implementation.memory.CityMemoryArrayRepo;
import ru.elena.TravelAgency.v5.City.service.implementation.memory.CityMemoryArrayService;
import ru.elena.TravelAgency.v5.City.service.CityService;
import ru.elena.TravelAgency.v5.Country.repo.CountryMemoryArrayRepo;
import ru.elena.TravelAgency.v5.Country.service.CountryMemoryArrayService;
import ru.elena.TravelAgency.v5.Country.service.CountryService;
import ru.elena.TravelAgency.v5.Order.repo.OrderMemoryArrayRepo;
import ru.elena.TravelAgency.v5.Order.service.OrderMemoryArrayService;
import ru.elena.TravelAgency.v5.Order.service.OrderService;
import ru.elena.TravelAgency.v5.User.repo.UserMemoryArrayRepo;
import ru.elena.TravelAgency.v5.User.service.UserMemoryArrayService;
import ru.elena.TravelAgency.v5.User.service.UserService;

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
