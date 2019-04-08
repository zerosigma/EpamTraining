package com.elena.TravelAgency.v5.Country.domain;

import java.util.HashMap;
import java.util.Map;

public enum CountryDiscriminator {
    HOT,
    COLD;

    private static Map<String, CountryDiscriminator> strCountryDiscriminatorMap = new HashMap<>();

    static {
        strCountryDiscriminatorMap = new HashMap<>();
        for (CountryDiscriminator discriminator : CountryDiscriminator.values())
            strCountryDiscriminatorMap.put(discriminator.name(), discriminator);
    }

    public static CountryDiscriminator getDiscriminatorByName(String discriminatorName) {
        return strCountryDiscriminatorMap.get(discriminatorName);
    }

    public static boolean isDiscriminatorExisting(String discriminatorName) {
        return strCountryDiscriminatorMap.containsKey(discriminatorName);
    }

    public static boolean isDiscriminatorNotExisting(String discriminatorName) {
        return !isDiscriminatorExisting(discriminatorName);
    }

}
