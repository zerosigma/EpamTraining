package main.java.ru.elena.TravelAgency.v2.Country;

import main.java.ru.elena.TravelAgency.v2.City.City;

import java.util.Arrays;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Country country = (Country) o;
        return id.equals(country.id) &&
                name.equals(country.name) &&
                language.equals(country.language) &&
                Arrays.equals(cities, country.cities);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, language);
        result = 31 * result + Arrays.hashCode(cities);
        return result;
    }
}
