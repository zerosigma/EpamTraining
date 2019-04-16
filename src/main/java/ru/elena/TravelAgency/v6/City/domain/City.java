package main.java.ru.elena.TravelAgency.v6.City.domain;

import main.java.ru.elena.TravelAgency.v5.City.domain.ClimateType;
import main.java.ru.elena.TravelAgency.v5.common.business.domain.BaseDomain;

import java.util.Objects;

public class City extends BaseDomain<Long> {
    private String name;
    private boolean isCapital;
    private ClimateType climateType;
    private Long idCountry;

    public City() {}

    public City(String name, Long idCountry, boolean isCapital) {
        this.name = name;
        this.idCountry = idCountry;
        this.isCapital = isCapital;
    }

    public City(String name, Long idCountry, boolean isCapital, ClimateType climateType) {
        this.name = name;
        this.idCountry = idCountry;
        this.isCapital = isCapital;
        this.climateType = climateType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Long idCountry) {
        this.idCountry = idCountry;
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
