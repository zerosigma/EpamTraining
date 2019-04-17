package main.java.ru.elena.TravelAgency.v6.common.business.application.servicefactory;

import main.java.ru.elena.TravelAgency.v6.City.repo.implementation.memory.CityMemoryCollectionRepo;
import main.java.ru.elena.TravelAgency.v6.City.service.CityService;
import main.java.ru.elena.TravelAgency.v6.City.service.implementation.memory.CityMemoryCollectionService;
import main.java.ru.elena.TravelAgency.v6.Country.repo.implementation.memory.CountryMemoryCollectionRepo;
import main.java.ru.elena.TravelAgency.v6.Country.service.CountryService;
import main.java.ru.elena.TravelAgency.v6.Country.service.implementation.memory.CountryMemoryCollectionService;
import main.java.ru.elena.TravelAgency.v6.Order.repo.implementation.memory.OrderMemoryCollectionRepo;
import main.java.ru.elena.TravelAgency.v6.Order.service.OrderService;
import main.java.ru.elena.TravelAgency.v6.Order.service.implementation.memory.OrderMemoryCollectionService;
import main.java.ru.elena.TravelAgency.v6.User.repo.implementation.memory.UserMemoryCollectionRepo;
import main.java.ru.elena.TravelAgency.v6.User.service.UserService;
import main.java.ru.elena.TravelAgency.v6.User.service.implementation.memory.UserMemoryCollectionService;

public class MemoryCollectionServiceFactory implements ServiceFactory {
    @Override
    public CityService getCityService() {
        return new CityMemoryCollectionService(new CityMemoryCollectionRepo(),
                                               new OrderMemoryCollectionRepo());
    }

    @Override
    public CountryService getCountryService() {
        return new CountryMemoryCollectionService(new CountryMemoryCollectionRepo(),
                                                  new CityMemoryCollectionService(new CityMemoryCollectionRepo(),
                                                                                  new OrderMemoryCollectionRepo()),
                                                  new OrderMemoryCollectionRepo());
    }

    @Override
    public OrderService getOrderService() {
        return new OrderMemoryCollectionService(new OrderMemoryCollectionRepo());
    }

    @Override
    public UserService getUserService() {
        return new UserMemoryCollectionService(new UserMemoryCollectionRepo());
    }
}
