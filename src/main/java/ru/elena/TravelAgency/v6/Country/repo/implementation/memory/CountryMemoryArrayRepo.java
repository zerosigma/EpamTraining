package main.java.ru.elena.TravelAgency.v6.Country.repo.implementation.memory;

import main.java.ru.elena.TravelAgency.v6.Country.domain.BaseCountry;
import main.java.ru.elena.TravelAgency.v6.Country.repo.CountryArrayRepo;
import main.java.ru.elena.TravelAgency.v6.Country.search.CountrySearchCondition;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import static main.java.ru.elena.TravelAgency.v6.Storage.GlobalIDGenerator.generateNextValue;
import static main.java.ru.elena.TravelAgency.v6.Storage.Storage.countries;
import static main.java.ru.elena.TravelAgency.v6.common.solution.utils.ArrayUtils.deleteElement;

public class CountryMemoryArrayRepo implements CountryArrayRepo {
    private static final BaseCountry[] EMPTY_COUNTRY_ARRAY = new BaseCountry[0];
    private int countryIndexInStorage = -1;

    @Override
    public BaseCountry insert(BaseCountry country) {
        if (countryIndexInStorage == countries.length - 1) {
            BaseCountry[] newCountries = new BaseCountry[countries.length * 2];
            System.arraycopy(countries, 0, newCountries, 0, countries.length);
            countries = newCountries;
        }

        countryIndexInStorage++;
        country.setId(generateNextValue());
        countries[countryIndexInStorage] = country;

        return country;
    }

    @Override
    public void insert(Collection<BaseCountry> countries) {
        countries.forEach(this::insert);
    }

    @Override
    public void deleteByID(Long id) {
        Integer countryIndex = findIndex(id);

        if (countryIndex != null) {
            deleteElement(countries, countryIndex);
            countryIndexInStorage--;
        }
    }

    @Override
    public void update(BaseCountry entity) {

    }

    @Override
    public Optional<BaseCountry> findByID(Long id) {
        return Arrays.stream(countries).filter(country -> country.getId().equals(id)).findAny();
    }

    @Override
    public Optional<BaseCountry> find(String name) {
        return Arrays.stream(countries).filter(country -> country.getName().equals(name)).findAny();
    }

    private Integer findIndex(long id) {
        for (int i = 0; i < countries.length; i++)
            if (countries[i].getId().equals(id))
                return i;

        return null;
    }

    @Override
    public BaseCountry[] search(CountrySearchCondition countrySearchCondition) {
        if (countrySearchCondition.searchById()) {
            Optional<BaseCountry> foundCountry = findByID(countrySearchCondition.getId());
            return foundCountry.map(country -> new BaseCountry[]{country}).orElse(EMPTY_COUNTRY_ARRAY);
        }
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
