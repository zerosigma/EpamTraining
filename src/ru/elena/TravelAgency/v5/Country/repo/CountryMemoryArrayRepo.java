package ru.elena.TravelAgency.v5.Country.repo;

import ru.elena.TravelAgency.v5.Country.domain.BaseCountry;
import ru.elena.TravelAgency.v5.Country.search.CountrySearchCondition;

import java.util.Collection;

import static ru.elena.TravelAgency.v5.Storage.Storage.countries;
import static ru.elena.TravelAgency.v5.common.solution.utils.ArrayUtils.deleteElement;

public class CountryMemoryArrayRepo implements CountryArrayRepo {
    private static final BaseCountry[] EMPTY_COUNTRY_ARRAY = new BaseCountry[0];
    private int countryIndexInStorage = -1;

    public BaseCountry insert(BaseCountry country) {
        if (countryIndexInStorage == countries.length - 1) {
            BaseCountry[] newCountries = new BaseCountry[countries.length * 2];
            System.arraycopy(countries, 0, newCountries, 0, countries.length);
            countries = newCountries;
        }

        countryIndexInStorage++;
        countries[countryIndexInStorage] = country;

        return country;
    }

    @Override
    public void insert(Collection<BaseCountry> countries) {
        countries.forEach(this::insert);
    }

    public void deleteByID(Long id) {
        Integer countryIndex = findIndex(id);

        if (countryIndex != null) {
            deleteElement(countries, countryIndex);
            countryIndexInStorage--;
        }
    }

    public void delete(BaseCountry country) {
        Integer countryIndex = findIndex(country);

        if (countryIndex != null) {
            deleteElement(countries, countryIndex);
            countryIndexInStorage--;
        }
    }

    @Override
    public void update(BaseCountry entity) {

    }

    public BaseCountry findByID(Long id) {
        for (BaseCountry country : countries)
            if (country.getId().equals(id))
                return country;

        return null;
    }

    public BaseCountry find(String name) {
        for (BaseCountry country : countries)
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

    private Integer findIndex(BaseCountry country) {
        for (int i = 0; i < countries.length; i++)
            if (countries[i].equals(country))
                return i;

        return null;
    }

    @Override
    public BaseCountry[] search(CountrySearchCondition countrySearchCondition) {
        if (countrySearchCondition.searchById())
            return new BaseCountry[]{findByID(countrySearchCondition.getId())};
        else {
            BaseCountry[] result = new BaseCountry[countries.length];
            int resultIndex = 0;

            for (BaseCountry country : countries)
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
                BaseCountry[] returnableResult = new BaseCountry[resultIndex];
                System.arraycopy(result, 0, returnableResult, 0, resultIndex);
                return returnableResult;
            }

            return EMPTY_COUNTRY_ARRAY;
        }
    }
}
