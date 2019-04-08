package com.elena.TravelAgency.v5.Storage.initializer.parse.sax;

import com.elena.TravelAgency.v5.Country.domain.BaseCountry;
import com.elena.TravelAgency.v5.Storage.initializer.exception.InitializingDataExceptionMeta;
import com.elena.TravelAgency.v5.Storage.initializer.parse.FileParser;
import com.elena.TravelAgency.v5.Storage.initializer.exception.checked.SourceFileNotExistingException;

import javax.xml.parsers.SAXParser;
import java.util.List;

import static com.elena.TravelAgency.v5.common.solution.utils.FileUtils.fileExists;
import static com.elena.TravelAgency.v5.common.solution.xml.sax.XmlSaxUtils.getParser;

public class CountriesWithCitiesSaxXmlParser implements FileParser<List<BaseCountry>> {
    @Override
    public List<BaseCountry> parseFile(String fileName) throws Exception {
        if (fileExists(fileName)) {
            SAXParser saxParser = getParser();
            CountriesWithCitiesSaxHandler handler = new CountriesWithCitiesSaxHandler();
            saxParser.parse(fileName, handler);

            return handler.getParsedCountries();
        }
        else
            throw new SourceFileNotExistingException(InitializingDataExceptionMeta.SOURCE_FILE_NOT_FOUND_ERROR.getCode(),
                                                     InitializingDataExceptionMeta.SOURCE_FILE_NOT_FOUND_ERROR.getDescription());
    }
}
