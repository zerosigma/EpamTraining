package ru.elena.TravelAgency.v5.Country.domain;

import ru.elena.TravelAgency.v5.City.domain.City;
import ru.elena.TravelAgency.v5.common.business.domain.BaseDomain;

import java.util.List;

public abstract class BaseCountry extends BaseDomain<Long> {
    protected String name;
    protected String language;
    protected String dialingCode;

    protected CountryDiscriminator discriminator;

    private List<City> cities;

    public BaseCountry() {
        initDiscriminator();
    }

    protected abstract void initDiscriminator();

    public CountryDiscriminator getDiscriminator() {
        return discriminator;
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

    public String getDialingCode() {
        return dialingCode;
    }

    public void setDialingCode(String dialingCode) {
        this.dialingCode = dialingCode;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "Country " +
                "id = " + id +
                ", name: " + name +
                ", language: " + language +
                "\nCities:\n" + getCitiesAsString();
    }

    private String getCitiesAsString() {
        StringBuilder citiesAsString = new StringBuilder();
        for (City city : cities)
            citiesAsString.append(city.toString()).append("\n");

        return citiesAsString.toString();
    }
}
