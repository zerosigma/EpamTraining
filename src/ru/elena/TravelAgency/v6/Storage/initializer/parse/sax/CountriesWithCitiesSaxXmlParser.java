package ru.elena.TravelAgency.v6.Storage.initializer.parse.sax;

import ru.elena.TravelAgency.v5.Country.domain.BaseCountry;
import ru.elena.TravelAgency.v5.Storage.initializer.exception.InitializingDataExceptionMeta;
import ru.elena.TravelAgency.v5.Storage.initializer.parse.FileParser;
import ru.elena.TravelAgency.v5.Storage.initializer.exception.uncheked.SourceFileNotExistingException;
import ru.elena.TravelAgency.v5.Storage.initializer.parse.sax.CountriesWithCitiesSaxHandler;

import javax.xml.parsers.SAXParser;
import java.util.List;

import static ru.elena.TravelAgency.v5.common.solution.utils.FileUtils.fileExists;
import static ru.elena.TravelAgency.v5.common.solution.xml.sax.XmlSaxUtils.getParser;

public class CountriesWithCitiesSaxXmlParser implements FileParser<List<BaseCountry>> {
    @Override
    public List<BaseCountry> parseFile(String fileName) throws Exception {
        if (fileExists(fileName)) {
            SAXParser saxParser = getParser();
            ru.elena.TravelAgency.v5.Storage.initializer.parse.sax.CountriesWithCitiesSaxHandler handler = new CountriesWithCitiesSaxHandler();
            saxParser.parse(fileName, handler);

            return handler.getParsedCountries();
        }
        else
            throw new SourceFileNotExistingException(InitializingDataExceptionMeta.SOURCE_FILE_NOT_FOUND_ERROR);
    }
}
