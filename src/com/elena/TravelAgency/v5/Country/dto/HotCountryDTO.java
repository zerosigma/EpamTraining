package com.elena.TravelAgency.v5.Country.dto;

import com.elena.TravelAgency.v5.Country.domain.CountryDiscriminator;

import java.time.Month;

public class HotCountryDTO extends  BaseCountryDTO {
    private Month hottestMonth;
    private int averageTemperature;

    public Month getHottestMonth() {
        return hottestMonth;
    }

    public void setHottestMonth(Month hottestMonth) {
        this.hottestMonth = hottestMonth;
    }

    public int getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(int averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    @Override
    protected void initDiscriminator() {
        discriminator = CountryDiscriminator.HOT;
    }
}