package main.java.ru.elena.TravelAgency.v4.City.domain;

import main.java.ru.elena.TravelAgency.v4.common.domain.BaseDomain;

import java.util.Objects;

public class City extends BaseDomain {
    private String name;
    private boolean isCapital;
    private ClimateType climateType;

    public City(String name, boolean isCapital) {
        this.name = name;
        this.isCapital = isCapital;
    }

    public City(Long id, String name, boolean isCapital) {
        this.id = id;
        this.name = name;
        this.isCapital = isCapital;
    }

    public City(Long id, String name, boolean isCapital, ClimateType climateType) {
        this.id = id;
        this.name = name;
        this.isCapital = isCapital;
        this.climateType = climateType;
    }

    public enum ClimateType {
        ARCTIC,
        SUBARCTIC,
        SUBANTARCTICAL,
        MILD,
        TROPIC,
        SUBTROPIC
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public void setCapital(boolean capital) {
        isCapital = capital;
    }

    public ClimateType getClimateType() {
        return climateType;
    }

    public void setClimateType(ClimateType climateType) {
        this.climateType = climateType;
    }

    @Override
    public String toString() {
        return "City " +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", isCapital = " + isCapitalAsString() +
                ", climate: " + climateType;
    }

    private String isCapitalAsString() {
        return isCapital ? "Is capital" : "Is not capital";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        City city = (City) o;
        return isCapital == city.isCapital &&
                id.equals(city.id) &&
                name.equals(city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isCapital);
    }
}
