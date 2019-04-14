package ru.elena.TravelAgency.v0;

public class City {
    private String name;
    private boolean isCapital;
    private Integer population;

    public City(String name, boolean isCapital, Integer population) {
        this.name = name;
        this.isCapital = isCapital;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public Integer getPopulation() {
        return population;
    }

}
