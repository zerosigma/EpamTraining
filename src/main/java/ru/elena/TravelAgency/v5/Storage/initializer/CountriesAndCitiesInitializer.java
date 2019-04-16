package main.java.ru.elena.TravelAgency.v5.Storage.initializer;

import main.java.ru.elena.TravelAgency.v5.Country.domain.BaseCountry;
import main.java.ru.elena.TravelAgency.v5.Country.service.CountryService;
import main.java.ru.elena.TravelAgency.v5.Storage.initializer.parse.FileParser;
import main.java.ru.elena.TravelAgency.v5.Storage.initializer.parse.dom.CountriesWithCitiesDomXmlParser;

import java.util.List;

public class CountriesAndCitiesInitializer {
    private CountryService countryService;

    public CountriesAndCitiesInitializer(CountryService countryService) {
        this.countryService = countryService;
    }

    public enum DataSourceType {
        TXT_FILE,
        XML_FILE
    }

    public void loadToStorageCountriesWithCities(String fileName, DataSourceType dataSourceType) throws Exception {
        List<BaseCountry> countries = getCountriesFromSource(fileName, dataSourceType);

        if (countries.size() > 0)
            for (int i = 0; i < countries.size(); i++)
                countryService.add(countries.get(i));
    }

    private List<BaseCountry> getCountriesFromSource(String fileName, DataSourceType dataSourceType) throws Exception {
        FileParser<List<BaseCountry>> fileParser = null;

        switch(dataSourceType) {
            case TXT_FILE: {
                break;
            }

            case XML_FILE: {
                fileParser = new CountriesWithCitiesDomXmlParser();
                //fileParser = new CountriesWithCitiesSaxXmlParser();
                //fileParser = new CountriesWithCitiesStaxXmlParser();
                break;
            }
        }

        return  fileParser.parseFile(fileName);
    }
}
