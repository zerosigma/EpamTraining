package com.elena.TravelAgency.v1.Country.repo;

import com.elena.TravelAgency.v1.Country.Country;

import static com.elena.TravelAgency.v1.Storage.Storage.countries;
import static com.elena.TravelAgency.v1.utils.ArrayUtils.ArrayUtils.deleteElement;

public class CountryMemoryRepo {
    private int countryIndexInStorage = -1;

    public void addCountry(Country country) {
        if (countryIndexInStorage == countries.length - 1) {
            Country[] newCountries = new Country[countries.length * 2];
            System.arraycopy(countries, 0, newCountries, 0, countries.length);
            countries = newCountries;
        }

        countryIndexInStorage++;
        countries[countryIndexInStorage] = country;
    }

    public void deleteCountry(Long id) {
        Integer countryIndex = findIndex(id);

        if (countryIndex != null) {
            deleteElement(countries, countryIndex);
            countryIndexInStorage--;
        }
    }

    public void deleteCountry(Country country) {
        Integer countryIndex = findIndex(country);

        if (countryIndex != null) {
            deleteElement(countries, countryIndex);
            countryIndexInStorage--;
        }
    }

    public Country findCountry(Long id) {
        for (Country country : countries)
            if (country.getId().equals(id))
                return country;

        return null;
    }

    public Country findCountry(String name) {
        for (Country country : countries)
            if (country.getName().equals(name))
                return country;

        return null;
    }

    private Integer findIndex(Long id) {
        for (int i = 0; i < countries.length; i++)
            if (countries[i].getId().equals(id))
                return i;

        return null;
    }

    private Integer findIndex(Country country) {
        for (int i = 0; i < countries.length; i++)
            if (countries[i].equals(country))
                return i;

        return null;
    }
}
