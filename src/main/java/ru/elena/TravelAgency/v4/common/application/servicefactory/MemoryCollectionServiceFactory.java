package main.java.ru.elena.TravelAgency.v4.common.application.servicefactory;

import main.java.ru.elena.TravelAgency.v4.City.repo.CityMemoryCollectionRepo;
import main.java.ru.elena.TravelAgency.v4.City.service.CityMemoryCollectionService;
import main.java.ru.elena.TravelAgency.v4.City.service.CityService;
import main.java.ru.elena.TravelAgency.v4.Country.repo.CountryMemoryCollectionRepo;
import main.java.ru.elena.TravelAgency.v4.Country.service.CountryMemoryCollectionService;
import main.java.ru.elena.TravelAgency.v4.Country.service.CountryService;
import main.java.ru.elena.TravelAgency.v4.Order.repo.OrderMemoryCollectionRepo;
import main.java.ru.elena.TravelAgency.v4.Order.service.OrderMemoryCollectionService;
import main.java.ru.elena.TravelAgency.v4.Order.service.OrderService;
import main.java.ru.elena.TravelAgency.v4.User.repo.UserMemoryCollectionRepo;
import main.java.ru.elena.TravelAgency.v4.User.service.UserMemoryCollectionService;
import main.java.ru.elena.TravelAgency.v4.User.service.UserService;

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
