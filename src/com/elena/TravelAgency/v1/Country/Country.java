package com.elena.TravelAgency.v1.Country;

import com.elena.TravelAgency.v1.City.City;

public class Country {
    private Long id;
    private String name;
    private String language;

    private City[] cities;

    public Country(String name, String language) {
        this.name = name;
        this.language = language;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public City[] getCities() {
        return cities;
    }

    public void setCities(City[] cities) {
        this.cities = cities;
    }
}
