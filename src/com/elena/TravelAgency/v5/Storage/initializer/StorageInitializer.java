package com.elena.TravelAgency.v5.Storage.initializer;

import com.elena.TravelAgency.v5.City.repo.CityCollectionRepo;
import com.elena.TravelAgency.v5.City.repo.implementation.memory.CityMemoryCollectionRepo;
import com.elena.TravelAgency.v5.City.service.implementation.memory.CityMemoryCollectionService;
import com.elena.TravelAgency.v5.Country.repo.CountryMemoryCollectionRepo;
import com.elena.TravelAgency.v5.Country.service.CountryMemoryCollectionService;
import com.elena.TravelAgency.v5.Order.repo.OrderMemoryCollectionRepo;
import com.elena.TravelAgency.v5.common.application.ApplicationSettings;

public class StorageInitializer {
    public void initialize() throws Exception {
        initializeCountriesAndCities(ApplicationSettings.INIT_COUNTRY_XML_FILE, CountriesAndCitiesInitializer.DataSourceType.XML_FILE);
    }

    private void initializeCountriesAndCities(String fileName, CountriesAndCitiesInitializer.DataSourceType dataSourceType) throws Exception {
        new CountriesAndCitiesInitializer(
                new CountryMemoryCollectionService(new CountryMemoryCollectionRepo(),
                                                   new CityMemoryCollectionService(new CityMemoryCollectionRepo(),
                                                                                   new OrderMemoryCollectionRepo()),
                                                   new OrderMemoryCollectionRepo()))
                .loadToStorageCountriesWithCities(fileName, dataSourceType);
    }
}
