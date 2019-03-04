package com.elena.TravelAgency.v4.Country.search;

import com.elena.TravelAgency.v4.common.search.BaseSearchCondition;

import static com.elena.TravelAgency.v4.common.utils.StringUtils.isNotEmptyString;

public class CountrySearchCondition extends BaseSearchCondition {
    private String name;
    private String language;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean searchByCountryName() {
        return isNotEmptyString(name);
    }

    public boolean searchByLanguage() {
        return isNotEmptyString(language);
    }
}
