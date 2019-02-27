package com.elena.TravelAgency.v4.Storage;

import com.elena.TravelAgency.v4.City.domain.City;
import com.elena.TravelAgency.v4.Country.domain.Country;
import com.elena.TravelAgency.v4.Order.domain.Order;
import com.elena.TravelAgency.v4.User.domain.User;

public class Storage {
    private static final int CAPACITY = 5;

    public static Country[] countries = new Country[CAPACITY];
    public static City[] cities = new City[CAPACITY];
    public static User[] users = new User[CAPACITY];
    public static Order[] orders = new Order[CAPACITY];
}
