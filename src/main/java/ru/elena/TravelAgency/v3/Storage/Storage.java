package main.java.ru.elena.TravelAgency.v3.Storage;

import main.java.ru.elena.TravelAgency.v3.City.City;
import main.java.ru.elena.TravelAgency.v3.Country.Country;
import main.java.ru.elena.TravelAgency.v3.Order.Order;
import main.java.ru.elena.TravelAgency.v3.User.User;

public class Storage {
    private static final int CAPACITY = 5;

    public static Country[] countries = new Country[CAPACITY];
    public static City[] cities = new City[CAPACITY];
    public static User[] users = new User[CAPACITY];
    public static Order[] orders = new Order[CAPACITY];
}
