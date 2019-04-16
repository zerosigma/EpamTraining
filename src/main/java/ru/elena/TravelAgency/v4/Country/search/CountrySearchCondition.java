package main.java.ru.elena.TravelAgency.v4.Country.search;

import main.java.ru.elena.TravelAgency.v4.common.search.BaseSearchCondition;
import main.java.ru.elena.TravelAgency.v4.common.utils.StringUtils;

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
        return StringUtils.isNotEmptyString(name);
    }

    public boolean searchByLanguage() {
        return StringUtils.isNotEmptyString(language);
    }
}
