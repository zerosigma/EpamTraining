package main.java.ru.elena.TravelAgency.v4.common.application.servicefactory;

import main.java.ru.elena.TravelAgency.v4.City.repo.CityMemoryArrayRepo;
import main.java.ru.elena.TravelAgency.v4.City.service.CityMemoryArrayService;
import main.java.ru.elena.TravelAgency.v4.City.service.CityService;
import main.java.ru.elena.TravelAgency.v4.Country.repo.CountryMemoryArrayRepo;
import main.java.ru.elena.TravelAgency.v4.Country.service.CountryMemoryArrayService;
import main.java.ru.elena.TravelAgency.v4.Country.service.CountryService;
import main.java.ru.elena.TravelAgency.v4.Order.repo.OrderMemoryArrayRepo;
import main.java.ru.elena.TravelAgency.v4.Order.service.OrderMemoryArrayService;
import main.java.ru.elena.TravelAgency.v4.Order.service.OrderService;
import main.java.ru.elena.TravelAgency.v4.User.repo.UserMemoryArrayRepo;
import main.java.ru.elena.TravelAgency.v4.User.service.UserMemoryArrayService;
import main.java.ru.elena.TravelAgency.v4.User.service.UserService;

public class MemoryArrayServiceFactory implements ServiceFactory  {

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
