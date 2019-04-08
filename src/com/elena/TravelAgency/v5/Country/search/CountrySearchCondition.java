package com.elena.TravelAgency.v5.Country.search;

import com.elena.TravelAgency.v5.Country.domain.CountryDiscriminator;
import com.elena.TravelAgency.v5.common.business.search.BaseSearchCondition;

import static com.elena.TravelAgency.v4.common.utils.StringUtils.isNotEmptyString;

public class CountrySearchCondition extends BaseSearchCondition<Long> {
    private String name;
    private String language;
    private CountryDiscriminator discriminator;

    public CountryDiscriminator getDiscriminator() {
        return discriminator;
    }

    public void setDiscriminator(CountryDiscriminator discriminator) {
        this.discriminator = discriminator;
    }

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

    public boolean searchByCountryDiscriminator() {
        return discriminator != null;
    }
}
