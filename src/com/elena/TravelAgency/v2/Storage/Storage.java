package com.elena.TravelAgency.v2.Storage;

import com.elena.TravelAgency.v2.City.City;
import com.elena.TravelAgency.v2.Country.Country;
import com.elena.TravelAgency.v2.Order.Order;
import com.elena.TravelAgency.v2.User.User;

public class Storage {
    public static final int CAPACITY = 10;

    public static Country[] countries = new Country[CAPACITY];
    public static City[] cities = new City[CAPACITY];
    public static User[] users = new User[CAPACITY];
    public static Order[] orders = new Order[CAPACITY];
}
