package ru.elena.TravelAgency.v5.City.dto;

import ru.elena.TravelAgency.v5.City.domain.ClimateType;
import ru.elena.TravelAgency.v5.common.business.dto.BaseDTO;

public class CityDTO extends BaseDTO<Long> {
    private String name;
    private boolean isCapital;
    private ClimateType climateType;

    public CityDTO() {}

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
}
