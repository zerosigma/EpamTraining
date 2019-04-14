package ru.elena.TravelAgency.v4.City.search;

import ru.elena.TravelAgency.v4.common.search.BaseSearchCondition;
import ru.elena.TravelAgency.v4.common.utils.StringUtils;

public class CitySearchCondition extends BaseSearchCondition {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean searchByCityName() {
        return StringUtils.isNotEmptyString(name);
    }
}
