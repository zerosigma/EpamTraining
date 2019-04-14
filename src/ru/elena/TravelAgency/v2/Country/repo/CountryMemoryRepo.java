package ru.elena.TravelAgency.v2.Country.repo;

import ru.elena.TravelAgency.v2.Country.Country;
import ru.elena.TravelAgency.v2.Storage.Storage;

import static ru.elena.TravelAgency.v2.utils.ArrayUtils.ArrayUtils.deleteElement;

public class CountryMemoryRepo {
    private int countryIndexInStorage = -1;

    public void addCountry(Country country) {
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

    public void deleteCountry(Long id) {
        Integer countryIndex = findIndex(id);

        if (countryIndex != null) {
            deleteElement(Storage.countries, countryIndex);
            countryIndexInStorage--;
        }
    }

    public void deleteCountry(Country country) {
        Integer countryIndex = findIndex(country);

        if (countryIndex != null) {
            deleteElement(Storage.countries, countryIndex);
            countryIndexInStorage--;
        }
    }

    public Country findCountry(Long id) {
        for (Country country : Storage.countries)
            if (country.getId().equals(id))
                return country;

        return null;
    }

    public Country findCountry(String name) {
        for (Country country : Storage.countries)
            if (country.getName().equals(name))
                return country;

        return null;
    }

    private Integer findIndex(Long id) {
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
}
