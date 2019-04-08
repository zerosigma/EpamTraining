package com.elena.TravelAgency.v5.Storage.initializer;

import com.elena.TravelAgency.v5.City.repo.CityMemoryCollectionRepo;
import com.elena.TravelAgency.v5.Country.domain.BaseCountry;
import com.elena.TravelAgency.v5.Country.repo.CountryMemoryCollectionRepo;
import com.elena.TravelAgency.v5.Country.search.CountrySearchCondition;
import com.elena.TravelAgency.v5.Country.service.CountryCollectionService;
import com.elena.TravelAgency.v5.Country.service.CountryMemoryCollectionService;

import java.util.List;

public class StorageInitializer {
    public void initialize() throws Exception {
        initializeCountriesAndCities("initCountries.xml", CountriesAndCitiesInitializer.DataSourceType.XML_FILE);
    }

    private void initializeCountriesAndCities(String fileName, CountriesAndCitiesInitializer.DataSourceType dataSourceType) throws Exception {
        new CountriesAndCitiesInitializer(
                new CountryMemoryCollectionService(new CountryMemoryCollectionRepo(),
                                                   new CityMemoryCollectionRepo()))
                .loadToStorageCountriesWithCities(fileName, dataSourceType);
    }
}
