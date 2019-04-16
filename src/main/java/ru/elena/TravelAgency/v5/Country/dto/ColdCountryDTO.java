package main.java.ru.elena.TravelAgency.v5.Country.dto;

import main.java.ru.elena.TravelAgency.v5.Country.domain.CountryDiscriminator;

import java.time.Month;

public class ColdCountryDTO extends BaseCountryDTO {
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
}
