package ru.elena.TravelAgency.v3.Storage;

import ru.elena.TravelAgency.v3.City.City;
import ru.elena.TravelAgency.v3.Country.Country;
import ru.elena.TravelAgency.v3.Order.Order;
import ru.elena.TravelAgency.v3.User.User;

public class Storage {
    private static final int CAPACITY = 5;

    public static Country[] countries = new Country[CAPACITY];
    public static City[] cities = new City[CAPACITY];
    public static User[] users = new User[CAPACITY];
    public static Order[] orders = new Order[CAPACITY];
}
