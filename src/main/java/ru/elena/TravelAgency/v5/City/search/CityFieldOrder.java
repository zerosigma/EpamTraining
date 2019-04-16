package main.java.ru.elena.TravelAgency.v5.City.search;

public enum CityFieldOrder {
    NAME("cityname"),
    CLIMATE_TYPE("cityclimatetype");

    private String requestParameterName;

    CityFieldOrder(String requestParameterName) {
        this.requestParameterName = requestParameterName;
    }

    public String getRequestParameterName() {
        return requestParameterName;
    }
}
