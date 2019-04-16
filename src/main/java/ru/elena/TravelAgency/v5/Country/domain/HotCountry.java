package main.java.ru.elena.TravelAgency.v5.Country.domain;

import java.time.Month;

public class HotCountry extends BaseCountry {
    private Month hottestMonth;
    private int averageTemperature;

    public Month getHottestMonth() {
        return hottestMonth;
    }

    public void setHottestMonth(Month hottestMonth) {
        this.hottestMonth = hottestMonth;
    }

    public int getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(int averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    @Override
    protected void initDiscriminator() {
        discriminator = CountryDiscriminator.HOT;
    }

    @Override
    public String toString() {
        return "HotCountry{" +
                "hottestMonth=" + hottestMonth +
                ", averageTemperature=" + averageTemperature +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", dialingCode='" + dialingCode + '\'' +
                '}';
    }
}
