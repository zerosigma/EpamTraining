package main.java.ru.elena.TravelAgency.v5.Storage.initializer.parse.dom;

import main.java.ru.elena.TravelAgency.v5.City.domain.City;
import main.java.ru.elena.TravelAgency.v5.City.domain.ClimateType;
import com.elena.TravelAgency.v5.Country.domain.*;
import main.java.ru.elena.TravelAgency.v5.Country.domain.BaseCountry;
import main.java.ru.elena.TravelAgency.v5.Country.domain.ColdCountry;
import main.java.ru.elena.TravelAgency.v5.Country.domain.CountryDiscriminator;
import main.java.ru.elena.TravelAgency.v5.Country.domain.HotCountry;
import main.java.ru.elena.TravelAgency.v5.Storage.initializer.exception.InitializingDataExceptionMeta;
import main.java.ru.elena.TravelAgency.v5.Storage.initializer.exception.checked.InvalidCountryDiscriminatorException;
import main.java.ru.elena.TravelAgency.v5.Storage.initializer.parse.FileParser;
import main.java.ru.elena.TravelAgency.v5.Storage.initializer.exception.uncheked.SourceFileNotExistingException;
import main.java.ru.elena.TravelAgency.v5.common.solution.utils.FileUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

import java.time.Month;

import static main.java.ru.elena.TravelAgency.v5.common.solution.xml.dom.XmlDomUtils.*;

public class CountriesWithCitiesDomXmlParser implements FileParser<List<BaseCountry>> {
    @Override
    public List<BaseCountry> parseFile(String file) throws Exception {
        if (FileUtils.fileExists(file)) {
            Document document = getDocument(file);
            Element countryRoot = getSingleElementByTagName(document, "countries");

            NodeList xmlCountries = document.getElementsByTagName("person");
            List<BaseCountry> loadedCountries = new ArrayList<>();

            if (xmlCountries.getLength() > 0)
                for (int i = 0; i < xmlCountries.getLength(); i++)
                    loadedCountries.add(getCountryFromXml((Element) xmlCountries.item(i)));

            return loadedCountries;
        }
        else
            throw new SourceFileNotExistingException(InitializingDataExceptionMeta.SOURCE_FILE_NOT_FOUND_ERROR);
    }

    private BaseCountry getCountryFromXml(Element country) throws Exception {
        String countryType = country.getAttribute("type");

        if (CountryDiscriminator.isDiscriminatorExisting(countryType)) {
            BaseCountry countryObject = null;
            switch (CountryDiscriminator.valueOf(countryType)) {
                case COLD: {
                    countryObject = createColdCountry(country);

                    break;
                }
                case HOT: {
                    countryObject = createHotCountry(country);
                }
            }


            countryObject.setName(getSingleElementTextContent(country, "name"));
            countryObject.setLanguage(getSingleElementTextContent(country, "language"));
            countryObject.setDialingCode(getSingleElementTextContent(country, "dialingCode"));

            NodeList xmlCities = country.getElementsByTagName("city");
            List<City> cities = new ArrayList<>();
            if (xmlCities.getLength() > 0)
                for (int i = 0; i < xmlCities.getLength(); i++)
                    cities.add(getCityFromXml((Element) xmlCities.item(i)));
             countryObject.setCities(cities);

            return countryObject;
        }
        else
            throw new InvalidCountryDiscriminatorException(InitializingDataExceptionMeta.PARSE_COUNTRY_DISCRIMINATOR_ERROR);
    }

    private City getCityFromXml(Element city) throws Exception {
        City cityObject = new City();
        cityObject.setName(getSingleElementTextContent(city, "name"));

        String isCapital = getSingleElementTextContent(city, "isCapital");
        cityObject.setCapital("yes".equals(isCapital.toLowerCase()));

        String climateType = getSingleElementTextContent(city, "climateType");
        if (ClimateType.isStrClimateNameExisting(climateType))
            cityObject.setClimateType(ClimateType.valueOf(climateType));
        else
            throw new Exception();

        return cityObject;
    }

    private ColdCountry createColdCountry(Element country) throws Exception {
        ColdCountry coldCountry = new ColdCountry();

        String coldestMonth = getSingleElementTextContent(country, "coldestMonth");
        coldCountry.setColdestMonth(Month.valueOf(coldestMonth));

        String skiResortsExist = getSingleElementTextContent(country, "skiResortsExist");
        coldCountry.setSkiResortsExist("yes".equals(skiResortsExist.toLowerCase()));

        return  coldCountry;
    }

    private HotCountry createHotCountry(Element country) throws Exception {
        HotCountry hotCountry = new HotCountry();

        String hottestMonth = getSingleElementTextContent(country, "hottestMonth");
        hotCountry.setHottestMonth(Month.valueOf(hottestMonth));

        hotCountry.setAverageTemperature(Integer.parseInt(getSingleElementTextContent(country,
                                                                             "averageTemperature")));
        return hotCountry;
    }
}
