package main.java.ru.elena.TravelAgency.v5.common.business.application.servicefactory;

import main.java.ru.elena.TravelAgency.v5.City.repo.implementation.memory.CityMemoryCollectionRepo;
import main.java.ru.elena.TravelAgency.v5.City.service.implementation.memory.CityMemoryCollectionService;
import main.java.ru.elena.TravelAgency.v5.City.service.CityService;
import main.java.ru.elena.TravelAgency.v5.Country.repo.CountryMemoryCollectionRepo;
import main.java.ru.elena.TravelAgency.v5.Country.service.CountryMemoryCollectionService;
import main.java.ru.elena.TravelAgency.v5.Country.service.CountryService;
import main.java.ru.elena.TravelAgency.v5.Order.repo.OrderMemoryCollectionRepo;
import main.java.ru.elena.TravelAgency.v5.Order.service.OrderMemoryCollectionService;
import main.java.ru.elena.TravelAgency.v5.Order.service.OrderService;
import main.java.ru.elena.TravelAgency.v5.User.repo.UserMemoryCollectionRepo;
import main.java.ru.elena.TravelAgency.v5.User.service.UserMemoryCollectionService;
import main.java.ru.elena.TravelAgency.v5.User.service.UserService;

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
