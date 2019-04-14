package ru.elena.TravelAgency.v4.Storage;

import ru.elena.TravelAgency.v4.City.domain.City;
import ru.elena.TravelAgency.v4.Country.domain.Country;
import ru.elena.TravelAgency.v4.Order.domain.Order;
import ru.elena.TravelAgency.v4.User.domain.User;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final int CAPACITY = 5;
    public static Country[] countries = new Country[CAPACITY];
    public static City[] cities = new City[CAPACITY];
    public static User[] users = new User[CAPACITY];
    public static Order[] orders = new Order[CAPACITY];

    public static List<Country> countriesList = new ArrayList<>();
    public static List<City> citiesList = new ArrayList<>();
    public static List<User> usersList = new ArrayList<>();
    public static List<Order> ordersList = new ArrayList<>();
}
