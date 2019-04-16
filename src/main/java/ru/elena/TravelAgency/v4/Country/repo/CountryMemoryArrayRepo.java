package main.java.ru.elena.TravelAgency.v4.Country.repo;

import main.java.ru.elena.TravelAgency.v4.Country.domain.Country;
import main.java.ru.elena.TravelAgency.v4.Country.search.CountrySearchCondition;
import main.java.ru.elena.TravelAgency.v4.Storage.Storage;
import main.java.ru.elena.TravelAgency.v4.common.utils.ArrayUtils;

public class CountryMemoryArrayRepo implements CountryArrayRepo {
    private static final Country[] EMPTY_COUNTRY_ARRAY = new Country[0];
    private int countryIndexInStorage = -1;

    public void add(Country country) {
        if (findIndex(country) == null) {
            if (countryIndexInStorage == Storage.countries.length - 1) {
                Country[] newCountries = new Country[Storage.countries.length * 2];
                System.arraycopy(Storage.countries, 0, newCountries, 0, Storage.countries.length);
                Storage.countries = newCountries;
            }

            countryIndexInStorage++;
            Storage.countries[countryIndexInStorage] = country;
        }
    }

    public void delete(long id) {
        Integer countryIndex = findIndex(id);

        if (countryIndex != null) {
            ArrayUtils.deleteElement(Storage.countries, countryIndex);
            countryIndexInStorage--;
        }
    }

    public void delete(Country country) {
        Integer countryIndex = findIndex(country);

        if (countryIndex != null) {
            ArrayUtils.deleteElement(Storage.countries, countryIndex);
            countryIndexInStorage--;
        }
    }

    public Country find(long id) {
        for (Country country : Storage.countries)
            if (country.getId().equals(id))
                return country;

        return null;
    }

    public Country find(String name) {
        for (Country country : Storage.countries)
            if (country.getName().equals(name))
                return country;

        return null;
    }

    private Integer findIndex(long id) {
        for (int i = 0; i < Storage.countries.length; i++)
            if (Storage.countries[i].getId().equals(id))
                return i;

        return null;
    }

    private Integer findIndex(Country country) {
        for (int i = 0; i < Storage.countries.length; i++)
            if (Storage.countries[i].equals(country))
                return i;

        return null;
    }

    @Override
    public Country[] search(CountrySearchCondition countrySearchCondition) {
        if (countrySearchCondition.searchById())
            return new Country[]{find(countrySearchCondition.getId())};
        else {
            Country[] result = new Country[Storage.countries.length];
            int resultIndex = 0;

            for (Country country : Storage.countries)
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
