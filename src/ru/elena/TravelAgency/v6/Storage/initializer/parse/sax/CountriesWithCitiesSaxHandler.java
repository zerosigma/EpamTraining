package ru.elena.TravelAgency.v6.Storage.initializer.parse.sax;

import ru.elena.TravelAgency.v5.City.domain.City;
import ru.elena.TravelAgency.v5.City.domain.ClimateType;
import com.elena.TravelAgency.v5.Country.domain.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ru.elena.TravelAgency.v5.Country.domain.BaseCountry;
import ru.elena.TravelAgency.v5.Country.domain.ColdCountry;
import ru.elena.TravelAgency.v5.Country.domain.CountryDiscriminator;
import ru.elena.TravelAgency.v5.Country.domain.HotCountry;

import java.time.Month;
import java.util.*;

public class CountriesWithCitiesSaxHandler extends DefaultHandler {
    private List<BaseCountry> parsedCountries;
    private BaseCountry country;
    private List<City> cities;
    private City city;
    private StringBuilder content = new StringBuilder();
    private Deque<String> currentPath = new ArrayDeque<>();

    private static final String COUNTRIES_PATH = "countries";
    private static final String SINGLE_COUNTRY_PATH = COUNTRIES_PATH + "/country";
    private static final String COUNTRY_NAME_PATH = SINGLE_COUNTRY_PATH + "/name";
    private static final String COUNTRY_LANGUAGE_PATH = SINGLE_COUNTRY_PATH + "/language";
    private static final String COUNTRY_DIALING_CODE_PATH = SINGLE_COUNTRY_PATH + "/dialingCode";
    private static final String COLD_COUNTRY_COLDEST_MONTH_PATH = SINGLE_COUNTRY_PATH + "/coldestMonth";
    private static final String COLD_COUNTRY_SKI_RESORTS_EXIST_PATH = SINGLE_COUNTRY_PATH + "/skiResortsExist";
    private static final String HOT_COUNTRY_HOTTEST_MONTH_PATH= SINGLE_COUNTRY_PATH + "/hottestMonth";
    private static final String HOT_COUNTRY_AVERAGE_TEMPERATURE_PATH = SINGLE_COUNTRY_PATH + "/averageTemperature";

    private static final String CITITES_PATH = SINGLE_COUNTRY_PATH + "/cities";
    private static final String SINGLE_CITY_PATH = CITITES_PATH + "/city";
    private static final String CITY_NAME_PATH = SINGLE_CITY_PATH + "/name";
    private static final String CITY_IS_CAPITAL_PATH = SINGLE_CITY_PATH + "/isCapital";
    private static final String CITY_CLIMATE_TYPE_PATH = SINGLE_CITY_PATH + "/climateType";


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        content.setLength(0);
        currentPath.addLast(qName);

        switch(currentPathAsString()) {
            case COUNTRIES_PATH: {
                parsedCountries = new ArrayList<>();
                break;
            }

            case SINGLE_COUNTRY_PATH: {
                if (checkColdCountry(attributes.getValue("type")))
                    country = new ColdCountry();
                else
                    country = new HotCountry();
                break;
            }

            case CITITES_PATH: {
                cities = new ArrayList<>();
                break;
            }

            case SINGLE_CITY_PATH: {
                city = new City();
                break;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String stringData = content.toString();

        switch(currentPathAsString()) {
            case COUNTRY_NAME_PATH: {
                country.setName(stringData);
                break;
            }

            case COUNTRY_LANGUAGE_PATH: {
                country.setLanguage(stringData);
                break;
            }

            case COUNTRY_DIALING_CODE_PATH: {
                country.setDialingCode(stringData);
                break;
            }

            case COLD_COUNTRY_COLDEST_MONTH_PATH: {
                getColdCountry().setColdestMonth(Month.valueOf(stringData));
                break;
            }

            case COLD_COUNTRY_SKI_RESORTS_EXIST_PATH: {
                getColdCountry().setSkiResortsExist("yes".equals(stringData.toLowerCase()));
                break;
            }

            case HOT_COUNTRY_HOTTEST_MONTH_PATH: {
                getHotCountry().setHottestMonth(Month.valueOf(stringData));
                break;
            }

            case HOT_COUNTRY_AVERAGE_TEMPERATURE_PATH: {
                getHotCountry().setAverageTemperature(Integer.parseInt(stringData));
                break;
            }

            case CITY_NAME_PATH: {
                city.setName(stringData);
                break;
            }

            case CITY_IS_CAPITAL_PATH: {
                city.setCapital("yes".equals(stringData.toLowerCase()));
                break;
            }

            case CITY_CLIMATE_TYPE_PATH: {
                if (ClimateType.isStrClimateNameExisting(stringData))
                    city.setClimateType(ClimateType.valueOf(stringData));
                break;
            }

            case SINGLE_CITY_PATH: {
                cities.add(city);
            }

            case CITITES_PATH: {
                country.setCities(cities);
            }
        }

        currentPath.removeLast();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        content.append(value);
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        super.ignorableWhitespace(ch, start, length);
    }

    private ColdCountry getColdCountry() {
        return (ColdCountry) country;
    }

    private HotCountry getHotCountry() {
        return (HotCountry) country;
    }


    private boolean checkColdCountry(String countryType) {
        return CountryDiscriminator.COLD.equals(CountryDiscriminator.valueOf(countryType));
    }

    private String currentPathAsString() {
        StringBuilder strCurrentPath = new StringBuilder();

        Iterator<String> tagIter = currentPath.iterator();
        while (tagIter.hasNext()) {
            String tag = tagIter.next();
            strCurrentPath.append(tag);
            if (tagIter.hasNext())
                strCurrentPath.append("/");
        }
        return strCurrentPath.toString();
    }

    public List<BaseCountry> getParsedCountries() {
        return parsedCountries;
    }
}
