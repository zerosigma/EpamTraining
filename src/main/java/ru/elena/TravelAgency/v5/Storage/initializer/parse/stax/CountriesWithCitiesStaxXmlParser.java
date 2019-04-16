package main.java.ru.elena.TravelAgency.v5.Storage.initializer.parse.stax;

import main.java.ru.elena.TravelAgency.v5.City.domain.City;
import main.java.ru.elena.TravelAgency.v5.City.domain.ClimateType;
import main.java.ru.elena.TravelAgency.v5.Country.domain.BaseCountry;
import main.java.ru.elena.TravelAgency.v5.Country.domain.ColdCountry;
import main.java.ru.elena.TravelAgency.v5.Country.domain.CountryDiscriminator;
import main.java.ru.elena.TravelAgency.v5.Country.domain.HotCountry;
import main.java.ru.elena.TravelAgency.v5.Storage.initializer.exception.InitializingDataExceptionMeta;
import main.java.ru.elena.TravelAgency.v5.Storage.initializer.exception.checked.InvalidCountryDiscriminatorException;
import main.java.ru.elena.TravelAgency.v5.Storage.initializer.exception.uncheked.InvalidXmlDocumentStructureException;
import main.java.ru.elena.TravelAgency.v5.Storage.initializer.parse.FileParser;
import main.java.ru.elena.TravelAgency.v5.Storage.initializer.exception.uncheked.SourceFileNotExistingException;
import main.java.ru.elena.TravelAgency.v5.common.solution.xml.stax.CustomStaxReader;
import main.java.ru.elena.TravelAgency.v5.common.solution.utils.FileUtils;
import main.java.ru.elena.TravelAgency.v5.common.solution.xml.stax.XmlStaxUtils;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountriesWithCitiesStaxXmlParser implements FileParser<List<BaseCountry>> {

    @Override
    public List<BaseCountry> parseFile(String fileName) throws Exception {
        if (FileUtils.fileExists(fileName))
            try (CustomStaxReader customStaxReader = CustomStaxReader.newInstance(new FileInputStream(fileName))) {
                return readDocument(customStaxReader.getReader());
            }
        else
            throw new SourceFileNotExistingException(InitializingDataExceptionMeta.SOURCE_FILE_NOT_FOUND_ERROR);
    }

    private List<BaseCountry> readDocument(XMLStreamReader reader) throws XMLStreamException, InvalidCountryDiscriminatorException {
        List<BaseCountry> parsedCountries = Collections.emptyList();

        while (reader.hasNext()) {
            int eventType = reader.next();

            switch (eventType) {
                case XMLStreamReader.START_ELEMENT: {
                    String elementName = reader.getLocalName();

                    if ("countries".equals(elementName))
                        parsedCountries = new ArrayList<>(readCountries(reader));

                    break;
                }

                case XMLStreamReader.END_ELEMENT: {
                    return parsedCountries;
                }
            }
        }
        throw new InvalidXmlDocumentStructureException(InitializingDataExceptionMeta.XML_END_TAG_NOT_FOUND_ERROR);
    }

    private List<BaseCountry> readCountries(XMLStreamReader reader) throws XMLStreamException, InvalidCountryDiscriminatorException {
        List <BaseCountry> countries = new ArrayList<>();

        while (reader.hasNext()) {
            int eventType = reader.next();

            switch (eventType) {
                case XMLStreamReader.START_ELEMENT: {
                    String elementName = reader.getLocalName();

                    if ("country".equals(elementName))
                        countries.add(readCountry(reader));

                    break;
                }

                case XMLStreamReader.END_ELEMENT: {
                    return countries;
                }
            }
        }
        throw new InvalidXmlDocumentStructureException(InitializingDataExceptionMeta.XML_END_TAG_NOT_FOUND_ERROR);
    }

    private BaseCountry readCountry(XMLStreamReader reader) throws XMLStreamException, InvalidCountryDiscriminatorException {
        String countryType = reader.getAttributeValue(null, "type");
        BaseCountry country = createCountry(countryType);

        while (reader.hasNext()) {
            int eventType = reader.next();

            switch (eventType) {
                case XMLStreamReader.START_ELEMENT: {
                    String tagName = reader.getLocalName();

                    if (country instanceof ColdCountry)
                        readColdCountryAttributes((ColdCountry) country, tagName, reader);
                    else
                        readHotCountryAttributes((HotCountry) country, tagName, reader);

                    readBasicCountryAttributes(country, tagName, reader);

                    break;
                }

                case XMLStreamReader.END_ELEMENT: {
                    return country;
                }
            }
        }
        throw new InvalidXmlDocumentStructureException(InitializingDataExceptionMeta.XML_END_TAG_NOT_FOUND_ERROR);
    }

    private List<City> readCities(XMLStreamReader reader) throws XMLStreamException, InvalidCountryDiscriminatorException {
        List <City> cities = new ArrayList<>();

        while (reader.hasNext()) {
            int eventType = reader.next();

            switch (eventType) {
                case XMLStreamReader.START_ELEMENT: {
                    String elementName = reader.getLocalName();

                    if ("city".equals(elementName))
                        cities.add(readCity(reader));

                    break;
                }

                case XMLStreamReader.END_ELEMENT: {
                    return cities;
                }
            }
        }
        throw new InvalidXmlDocumentStructureException(InitializingDataExceptionMeta.XML_END_TAG_NOT_FOUND_ERROR);
    }

    private City readCity(XMLStreamReader reader) throws XMLStreamException, InvalidCountryDiscriminatorException {
        City city = new City();

        while (reader.hasNext()) {
            int eventType = reader.next();

            switch (eventType) {
                case XMLStreamReader.START_ELEMENT: {
                    String tagName = reader.getLocalName();

                    if ("name".equals(tagName))
                        city.setName(XmlStaxUtils.readContent(reader));
                    else if ("isCapital".equals(tagName))
                        city.setCapital("yes".equals(XmlStaxUtils.readContent(reader).toLowerCase()));
                    else if ("climateType".equals(tagName)) {
                        String climateType = XmlStaxUtils.readContent(reader);
                        if (ClimateType.isStrClimateNameExisting(climateType))
                            city.setClimateType(ClimateType.valueOf(climateType));
                    }

                    break;
                }

                case XMLStreamReader.END_ELEMENT: {
                    return city;
                }
            }
        }
        throw new InvalidXmlDocumentStructureException(InitializingDataExceptionMeta.XML_END_TAG_NOT_FOUND_ERROR);
    }

    private BaseCountry createCountry(String countryType) throws InvalidCountryDiscriminatorException {
        if (CountryDiscriminator.isDiscriminatorExisting(countryType)) {
            if (CountryDiscriminator.COLD.equals(CountryDiscriminator.valueOf(countryType)))
                return new ColdCountry();
            else
                return new HotCountry();
        }
        else
            throw new InvalidCountryDiscriminatorException(InitializingDataExceptionMeta.PARSE_COUNTRY_DISCRIMINATOR_ERROR);
    }

    private void readBasicCountryAttributes(BaseCountry country, String tagName, XMLStreamReader reader) throws XMLStreamException, InvalidCountryDiscriminatorException {
        switch (tagName) {
            case "name": {
                country.setName(XmlStaxUtils.readContent(reader));
                break;
            }

            case "language": {
                country.setLanguage(XmlStaxUtils.readContent(reader));
                break;
            }

            case "dialingCode": {
                country.setDialingCode(XmlStaxUtils.readContent(reader));
                break;
            }

            case "cities": {
                country.setCities(readCities(reader));
                break;
            }
        }
    }

    private void readColdCountryAttributes(ColdCountry country, String tagName, XMLStreamReader reader) throws XMLStreamException {
        switch (tagName) {
            case "coldestMonth": {
                country.setColdestMonth(Month.valueOf(XmlStaxUtils.readContent(reader)));
                break;
            }

            case "skiResortsExist": {
                country.setSkiResortsExist("yes".equals(XmlStaxUtils.readContent(reader).toLowerCase()));
                break;
            }
        }

    }

    private void readHotCountryAttributes(HotCountry country, String tagName, XMLStreamReader reader) throws XMLStreamException {
        switch (tagName) {
            case "hottestMonth": {
                country.setHottestMonth(Month.valueOf(XmlStaxUtils.readContent(reader)));
                break;
            }

            case "averageTemperature": {
                country.setAverageTemperature(Integer.parseInt(XmlStaxUtils.readContent(reader)));
                break;
            }
        }
    }
}
