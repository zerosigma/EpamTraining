package ru.elena.TravelAgency.v5.City.search;

import ru.elena.TravelAgency.v3.City.ClimateType;
import ru.elena.TravelAgency.v5.common.business.search.BaseSearchCondition;

import static ru.elena.TravelAgency.v4.common.utils.StringUtils.isNotEmptyString;

public class CitySearchCondition extends BaseSearchCondition<Long> {
    private String name;
    private ClimateType climateType;
    private CityFieldOrder cityFieldOrder;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClimateType getClimateType() {
        return climateType;
    }

    public void setClimateType(ClimateType climateType) {
        this.climateType = climateType;
    }

    public CityFieldOrder getCityFieldOrder() {
        return cityFieldOrder;
    }

    public void setCityFieldOrder(CityFieldOrder cityFieldOrder) {
        this.cityFieldOrder = cityFieldOrder;
    }

    public boolean searchByCityName() {
        return isNotEmptyString(name);
    }

    public boolean searchByClimateType() {
        return climateType != null;
    }

    public boolean needOrdering() {
        return super.needOrdering() && cityFieldOrder != null;
    }
}
