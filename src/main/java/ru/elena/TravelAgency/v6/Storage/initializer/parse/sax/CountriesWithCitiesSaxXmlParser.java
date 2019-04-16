package main.java.ru.elena.TravelAgency.v6.Storage.initializer.parse.sax;

import main.java.ru.elena.TravelAgency.v5.Country.domain.BaseCountry;
import main.java.ru.elena.TravelAgency.v5.Storage.initializer.exception.InitializingDataExceptionMeta;
import main.java.ru.elena.TravelAgency.v5.Storage.initializer.parse.FileParser;
import main.java.ru.elena.TravelAgency.v5.Storage.initializer.exception.uncheked.SourceFileNotExistingException;
import main.java.ru.elena.TravelAgency.v5.Storage.initializer.parse.sax.CountriesWithCitiesSaxHandler;
import main.java.ru.elena.TravelAgency.v5.common.solution.utils.FileUtils;
import main.java.ru.elena.TravelAgency.v5.common.solution.xml.sax.XmlSaxUtils;

import javax.xml.parsers.SAXParser;
import java.util.List;

public class CountriesWithCitiesSaxXmlParser implements FileParser<List<BaseCountry>> {
    @Override
    public List<BaseCountry> parseFile(String fileName) throws Exception {
        if (FileUtils.fileExists(fileName)) {
            SAXParser saxParser = XmlSaxUtils.getParser();
            main.java.ru.elena.TravelAgency.v5.Storage.initializer.parse.sax.CountriesWithCitiesSaxHandler handler = new CountriesWithCitiesSaxHandler();
            saxParser.parse(fileName, handler);

            return handler.getParsedCountries();
        }
        else
            throw new SourceFileNotExistingException(InitializingDataExceptionMeta.SOURCE_FILE_NOT_FOUND_ERROR);
    }
}
