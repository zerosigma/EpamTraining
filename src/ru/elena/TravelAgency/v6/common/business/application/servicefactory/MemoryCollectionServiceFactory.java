package ru.elena.TravelAgency.v6.common.business.application.servicefactory;

import ru.elena.TravelAgency.v5.City.repo.implementation.memory.CityMemoryCollectionRepo;
import ru.elena.TravelAgency.v5.City.service.implementation.memory.CityMemoryCollectionService;
import ru.elena.TravelAgency.v5.City.service.CityService;
import ru.elena.TravelAgency.v5.Country.repo.CountryMemoryCollectionRepo;
import ru.elena.TravelAgency.v5.Country.service.CountryMemoryCollectionService;
import ru.elena.TravelAgency.v5.Country.service.CountryService;
import ru.elena.TravelAgency.v5.Order.repo.OrderMemoryCollectionRepo;
import ru.elena.TravelAgency.v5.Order.service.OrderMemoryCollectionService;
import ru.elena.TravelAgency.v5.Order.service.OrderService;
import ru.elena.TravelAgency.v5.User.repo.UserMemoryCollectionRepo;
import ru.elena.TravelAgency.v5.User.service.UserMemoryCollectionService;
import ru.elena.TravelAgency.v5.User.service.UserService;
import ru.elena.TravelAgency.v5.common.business.application.servicefactory.ServiceFactory;

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
