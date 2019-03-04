package com.elena.TravelAgency.v4.City.search;

import com.elena.TravelAgency.v4.City.domain.City;
import com.elena.TravelAgency.v4.common.search.BaseSearchCondition;

import static com.elena.TravelAgency.v4.common.utils.StringUtils.isNotEmptyString;

public class CitySearchCondition extends BaseSearchCondition {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean searchByCityName() {
        return isNotEmptyString(name);
    }
}
