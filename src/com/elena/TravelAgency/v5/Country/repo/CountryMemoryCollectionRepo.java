package com.elena.TravelAgency.v5.Country.repo;

import com.elena.TravelAgency.v5.Country.domain.BaseCountry;
import com.elena.TravelAgency.v5.Country.domain.ColdCountry;
import com.elena.TravelAgency.v5.Country.domain.CountryDiscriminator;
import com.elena.TravelAgency.v5.Country.domain.HotCountry;
import com.elena.TravelAgency.v5.Country.search.ColdCountrySearchCondition;
import com.elena.TravelAgency.v5.Country.search.CountrySearchCondition;
import com.elena.TravelAgency.v5.Country.search.HotCountrySearchCondition;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.elena.TravelAgency.v5.Storage.GlobalIDGenerator.generateNextValue;
import static com.elena.TravelAgency.v5.Storage.Storage.countriesList;

public class CountryMemoryCollectionRepo implements CountryCollectionRepo {
    @Override
    public BaseCountry insert(BaseCountry country) {
        country.setId(generateNextValue());
        countriesList.add(country);

        return country;
    }

    @Override
    public void delete(BaseCountry country) {
        BaseCountry countryElem = findByEntity(country);

        if (countryElem != null)
            countriesList.remove(country);
    }

    @Override
    public void update(BaseCountry entity) {

    }

    @Override
    public BaseCountry findByID(Long id) {
        return findByIndex(id);
    }

    @Override
    public BaseCountry find(String name) {
        for (BaseCountry country : countriesList)
            if (country.getName().equals(name))
                return country;

        return null;
    }

    @Override
    public void deleteByID(Long id) {
        BaseCountry country = findByID(id);

        if (country != null) {
            countriesList.remove(country);
        }
    }

    @Override
    public void insert(Collection<BaseCountry> countries) {
        countries.forEach(this::insert);
    }

    private BaseCountry findByIndex(long id) {
        for (BaseCountry country : countriesList)
            if (Long.valueOf(id).equals(country.getId()))
                return country;

        return null;
    }

    private BaseCountry findByEntity(BaseCountry countryToFind) {
        for (BaseCountry country : countriesList)
            if (country.equals(countryToFind))
                return country;

        return null;
    }

    @Override
    public List<? extends BaseCountry> search(CountrySearchCondition countrySearchCondition) {
        List<? extends BaseCountry> searchResult = searchProcess(countrySearchCondition);

        return searchResult;
    }

    private List<? extends BaseCountry> searchProcess(CountrySearchCondition countrySearchCondition) {
        if (countrySearchCondition.searchByCountryName())
            return Collections.singletonList(find(countrySearchCondition.getName()));
        else if (countrySearchCondition.searchByCountryDiscriminator()) {
            CountryDiscriminator discriminator = countrySearchCondition.getDiscriminator();
            List<? extends BaseCountry> result = new ArrayList<>();

            switch (discriminator) {
                case COLD: {
                    result = searchColdCountry((ColdCountrySearchCondition) countrySearchCondition);
                    break;
                }

                case HOT: {
                    result = searchHotCountry((HotCountrySearchCondition) countrySearchCondition);
                    break;
                }
            }

            return result;
        }

        return Collections.emptyList();
    }

    private List<ColdCountry> searchColdCountry(ColdCountrySearchCondition coldCountrySearchCondition) {
        List<ColdCountry> result = new ArrayList<>();

        for (BaseCountry country : countriesList)
            if (CountryDiscriminator.COLD.equals(country.getDiscriminator())) {
                ColdCountry currentCountry = (ColdCountry) country;
                boolean found = true;

                if (coldCountrySearchCondition.searchByColdstMonth())
                    found = coldCountrySearchCondition.getColdestMonth().equals(currentCountry.getColdestMonth());

                if (found && coldCountrySearchCondition.searchBySkiResortsExisting())
                    found = coldCountrySearchCondition.getSkiResortsExist().equals(currentCountry.skiResortsExist());

                if (found)
                    result.add(currentCountry);
            }
        return result;
    }

    private List<HotCountry> searchHotCountry(HotCountrySearchCondition hotCountrySearchCondition) {
        List<HotCountry> result = new ArrayList<>();

        for (BaseCountry country : countriesList)
            if (CountryDiscriminator.HOT.equals(country.getDiscriminator())) {
                HotCountry currentCountry = (HotCountry) country;
                boolean found = true;

                if (hotCountrySearchCondition.searchByHottestMonth())
                    found = hotCountrySearchCondition.getHottestMonth().equals(currentCountry.getHottestMonth());

                if (found && hotCountrySearchCondition.searchByAverageTemperature())
                    found = hotCountrySearchCondition.getAverageTemperature().equals(currentCountry.getAverageTemperature());

                if (found)
                    result.add(currentCountry);
            }
        return result;
    }
}
