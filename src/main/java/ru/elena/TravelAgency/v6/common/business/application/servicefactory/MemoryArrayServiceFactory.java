package main.java.ru.elena.TravelAgency.v6.common.business.application.servicefactory;

import main.java.ru.elena.TravelAgency.v6.City.repo.implementation.memory.CityMemoryArrayRepo;
import main.java.ru.elena.TravelAgency.v6.City.service.CityService;
import main.java.ru.elena.TravelAgency.v6.City.service.implementation.memory.CityMemoryArrayService;
import main.java.ru.elena.TravelAgency.v6.Country.repo.implementation.memory.CountryMemoryArrayRepo;
import main.java.ru.elena.TravelAgency.v6.Country.service.CountryService;
import main.java.ru.elena.TravelAgency.v6.Country.service.implementation.memory.CountryMemoryArrayService;
import main.java.ru.elena.TravelAgency.v6.Order.repo.implementation.memory.OrderMemoryArrayRepo;
import main.java.ru.elena.TravelAgency.v6.Order.service.OrderService;
import main.java.ru.elena.TravelAgency.v6.Order.service.implementation.memory.OrderMemoryArrayService;
import main.java.ru.elena.TravelAgency.v6.User.repo.implementation.memory.UserMemoryArrayRepo;
import main.java.ru.elena.TravelAgency.v6.User.service.UserService;
import main.java.ru.elena.TravelAgency.v6.User.service.implementation.memory.UserMemoryArrayService;

public class MemoryArrayServiceFactory implements ServiceFactory {

    @Override
    public CityService getCityService() {
        return new CityMemoryArrayService(new CityMemoryArrayRepo(),
                                          new OrderMemoryArrayRepo());
    }

    @Override
    public CountryService getCountryService() {
        return new CountryMemoryArrayService(new CountryMemoryArrayRepo(),
                                             new CityMemoryArrayService(new CityMemoryArrayRepo(),
                                                                        new OrderMemoryArrayRepo()),
                                             new OrderMemoryArrayRepo());
    }

    @Override
    public OrderService getOrderService() {
        return new OrderMemoryArrayService(new OrderMemoryArrayRepo());
    }

    @Override
    public UserService getUserService() {
        return new UserMemoryArrayService(new UserMemoryArrayRepo());
    }
}
