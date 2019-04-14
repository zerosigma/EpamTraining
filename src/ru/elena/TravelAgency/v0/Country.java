package ru.elena.TravelAgency.v0;

import java.util.ArrayList;

public class Country {
    private String name;
    private String language;

    private ArrayList<City> cities;

    public Country(String name, String language) {
        this.name = name;
        this.language = language;
        this.cities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }
}
