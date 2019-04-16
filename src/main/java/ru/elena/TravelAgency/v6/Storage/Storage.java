package main.java.ru.elena.TravelAgency.v6.Storage;

import main.java.ru.elena.TravelAgency.v6.City.domain.City;
import main.java.ru.elena.TravelAgency.v6.Country.domain.BaseCountry;
import main.java.ru.elena.TravelAgency.v6.Order.domain.Order;
import main.java.ru.elena.TravelAgency.v6.User.domain.User;

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
