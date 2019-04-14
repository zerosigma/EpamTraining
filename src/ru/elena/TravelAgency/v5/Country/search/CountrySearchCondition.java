package ru.elena.TravelAgency.v5.Country.search;

import ru.elena.TravelAgency.v5.Country.domain.CountryDiscriminator;
import ru.elena.TravelAgency.v5.common.business.search.BaseSearchCondition;

import static ru.elena.TravelAgency.v4.common.utils.StringUtils.isNotEmptyString;

public class CountrySearchCondition extends BaseSearchCondition<Long> {
    private String name;
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

    public boolean searchByCountryName() {
        return isNotEmptyString(name);
    }

    public boolean searchByCountryDiscriminator() {
        return discriminator != null;
    }
}
