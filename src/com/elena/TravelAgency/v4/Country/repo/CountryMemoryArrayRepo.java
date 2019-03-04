package com.elena.TravelAgency.v4.Country.repo;

import com.elena.TravelAgency.v4.City.domain.City;
import com.elena.TravelAgency.v4.City.search.CitySearchCondition;
import com.elena.TravelAgency.v4.Country.domain.Country;
import com.elena.TravelAgency.v4.Country.search.CountrySearchCondition;

import static com.elena.TravelAgency.v4.Storage.Storage.countries;
import static com.elena.TravelAgency.v4.common.utils.ArrayUtils.deleteElement;

public class CountryMemoryArrayRepo implements CountryArrayRepo {
    private static final Country[] EMPTY_COUNTRY_ARRAY = new Country[0];
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

    @Override
    public Country[] search(CountrySearchCondition countrySearchCondition) {
        if (countrySearchCondition.searchById())
            return new Country[]{find(countrySearchCondition.getId())};
        else {
            Country[] result = new Country[countries.length];
            int resultIndex = 0;

            for (Country country : countries)
                if (country != null) {
                    boolean found = true;

                    if (countrySearchCondition.searchByCountryName())
                        found = countrySearchCondition.getName().equals(country.getName());

                    if (found) {
                        result[resultIndex] = country;
                        resultIndex++;
                    }
                }

            if (resultIndex > 0) {
                Country[] returnableResult = new Country[resultIndex];
                System.arraycopy(result, 0, returnableResult, 0, resultIndex);
                return returnableResult;
            }

            return EMPTY_COUNTRY_ARRAY;
        }
    }
}
