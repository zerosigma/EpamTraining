package com.elena.TravelAgency.v3.Country.repo;

import com.elena.TravelAgency.v3.Country.Country;

import static com.elena.TravelAgency.v3.Storage.Storage.countries;
import static com.elena.TravelAgency.v3.common.utils.ArrayUtils.deleteElement;

public class CountryMemoryRepo implements CountryRepo {
    private int countryIndexInStorage = -1;

    public void add(Country country) {
        if (findIndex(country) == null) {
            if (countryIndexInStorage == countries.length - 1) {
                Country[] newCountries = new Country[countries.length * 2];
                System.arraycopy(countries, 0, newCountries, 0, countries.length);
                countries = newCountries;
            }

            countryIndexInStorage++;
            countries[countryIndexInStorage] = country;
        }
    }

    public void delete(long id) {
        Integer countryIndex = findIndex(id);

        if (countryIndex != null) {
            deleteElement(countries, countryIndex);
            countryIndexInStorage--;
        }
    }

    public void delete(Country country) {
        Integer countryIndex = findIndex(country);

        if (countryIndex != null) {
            deleteElement(countries, countryIndex);
            countryIndexInStorage--;
        }
    }

    public Country find(long id) {
        for (Country country : countries)
            if (country.getId().equals(id))
                return country;

        return null;
    }

    public Country find(String name) {
        for (Country country : countries)
            if (country.getName().equals(name))
                return country;

        return null;
    }

    private Integer findIndex(long id) {
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
