package ru.elena.TravelAgency.v6.Storage;

import ru.elena.TravelAgency.v5.City.domain.City;
import ru.elena.TravelAgency.v5.Country.domain.BaseCountry;
import ru.elena.TravelAgency.v5.Order.domain.Order;
import ru.elena.TravelAgency.v5.User.domain.User;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final int CAPACITY = 5;
    public static BaseCountry[] countries = new BaseCountry[CAPACITY];
    public static City[] cities = new City[CAPACITY];
    public static User[] users = new User[CAPACITY];
    public static Order[] orders = new Order[CAPACITY];

    public static List<BaseCountry> countriesList = new ArrayList<>();
    public static List<City> citiesList = new ArrayList<>();
    public static List<User> usersList = new ArrayList<>();
    public static List<Order> ordersList = new ArrayList<>();
}
