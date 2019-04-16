package main.java.ru.elena.TravelAgency.v6.Country.domain;

import main.java.ru.elena.TravelAgency.v5.Country.domain.BaseCountry;
import main.java.ru.elena.TravelAgency.v5.Country.domain.CountryDiscriminator;

import java.time.Month;

public class ColdCountry extends BaseCountry {
    private Month coldestMonth;
    private boolean skiResortsExist;

    public Month getColdestMonth() {
        return coldestMonth;
    }

    public void setColdestMonth(Month coldestMonth) {
        this.coldestMonth = coldestMonth;
    }

    public boolean skiResortsExist() {
        return skiResortsExist;
    }

    public void setSkiResortsExist(boolean skiResortsExist) {
        this.skiResortsExist = skiResortsExist;
    }

    @Override
    protected void initDiscriminator() {
        discriminator = CountryDiscriminator.COLD;
    }

    @Override
    public String toString() {
        return "ColdCountry{" +
                "coldestMonth=" + coldestMonth +
                ", isSkiResortsExists=" + skiResortsExist +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", dialingCode='" + dialingCode + '\'' +
                '}';
    }
}
