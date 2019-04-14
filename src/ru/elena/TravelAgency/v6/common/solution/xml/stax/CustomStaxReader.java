package ru.elena.TravelAgency.v6.common.solution.xml.stax;

import ru.elena.TravelAgency.v5.common.solution.xml.stax.XmlStaxUtils;

import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;

public class CustomStaxReader implements AutoCloseable {
    private XMLStreamReader reader;

    private CustomStaxReader(){
    }

    public static CustomStaxReader newInstance(InputStream inputStream) throws Exception {
        CustomStaxReader customStaxReader = new CustomStaxReader();
        customStaxReader.reader = XmlStaxUtils.getReader(inputStream);
        return customStaxReader;
    }

    @Override
    public void close() throws Exception {
        if (reader != null)
            reader.close();
        }


    public XMLStreamReader getReader() {
        return reader;
    }
}
