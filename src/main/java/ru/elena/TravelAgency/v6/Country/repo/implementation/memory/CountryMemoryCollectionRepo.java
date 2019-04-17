package main.java.ru.elena.TravelAgency.v6.Country.repo.implementation.memory;

import main.java.ru.elena.TravelAgency.v6.Country.domain.BaseCountry;
import main.java.ru.elena.TravelAgency.v6.Country.domain.ColdCountry;
import main.java.ru.elena.TravelAgency.v6.Country.domain.CountryDiscriminator;
import main.java.ru.elena.TravelAgency.v6.Country.domain.HotCountry;
import main.java.ru.elena.TravelAgency.v6.Country.repo.CountryCollectionRepo;
import main.java.ru.elena.TravelAgency.v6.Country.search.ColdCountrySearchCondition;
import main.java.ru.elena.TravelAgency.v6.Country.search.CountrySearchCondition;
import main.java.ru.elena.TravelAgency.v6.Country.search.HotCountrySearchCondition;

import java.util.*;

import static main.java.ru.elena.TravelAgency.v6.Storage.GlobalIDGenerator.generateNextValue;
import static main.java.ru.elena.TravelAgency.v6.Storage.Storage.countriesList;

public class CountryMemoryCollectionRepo implements CountryCollectionRepo {
    @Override
    public BaseCountry insert(BaseCountry country) {
        country.setId(generateNextValue());
        countriesList.add(country);

        return country;
    }

    @Override
    public void update(BaseCountry entity) {

    }

    @Override
    public Optional<BaseCountry> findByID(Long id) {
        return findByIndex(id);
    }

    @Override
    public Optional<BaseCountry> find(String name) {
        return countriesList.stream().filter(country -> country.getName().equals(name)).findAny();
    }

    @Override
    public void deleteByID(Long id) {
        Optional<BaseCountry> foundCountry = findByID(id);
        foundCountry.map(country -> countriesList.remove(country));
    }

    @Override
    public void insert(Collection<BaseCountry> countries) {
        countries.forEach(this::insert);
    }

    private Optional<BaseCountry> findByIndex(long id) {
        return countriesList.stream().filter(country -> Long.valueOf(id).equals(country.getId())).findAny();
    }

    @Override
    public List<? extends BaseCountry> search(CountrySearchCondition countrySearchCondition) {
        List<? extends BaseCountry> searchResult = searchProcess(countrySearchCondition);

        return searchResult;
    }

    private List<? extends BaseCountry> searchProcess(CountrySearchCondition countrySearchCondition) {
        if (countrySearchCondition.searchById()) {
            Optional<BaseCountry> foundCountry = findByIndex(countrySearchCondition.getId());
            return foundCountry.map(Collections::singletonList).orElse(Collections.emptyList());
        }
        else if (countrySearchCondition.searchByCountryName()) {
            Optional<BaseCountry> foundCountry = find(countrySearchCondition.getName());
            return foundCountry.map(Collections::singletonList).orElse(Collections.emptyList());
        }
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
