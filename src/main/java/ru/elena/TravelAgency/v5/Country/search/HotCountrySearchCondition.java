package main.java.ru.elena.TravelAgency.v5.Country.search;

import java.time.Month;

public class HotCountrySearchCondition extends CountrySearchCondition {
    private Month hottestMonth;
    private Integer averageTemperature;

    public Month getHottestMonth() {
        return hottestMonth;
    }

    public void setHottestMonth(Month hottestMonth) {
        this.hottestMonth = hottestMonth;
    }

    public Integer getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(Integer averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public boolean searchByHottestMonth() {
        return hottestMonth != null;
    }

    public boolean searchByAverageTemperature() {
        return averageTemperature != null;
    }
}
