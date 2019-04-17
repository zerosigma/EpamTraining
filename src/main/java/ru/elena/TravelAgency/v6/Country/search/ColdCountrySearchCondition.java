package main.java.ru.elena.TravelAgency.v6.Country.search;

import java.time.Month;

public class ColdCountrySearchCondition extends CountrySearchCondition {
    private Month coldestMonth;
    private Boolean skiResortsExist;

    public Month getColdestMonth() {
        return coldestMonth;
    }

    public void setColdestMonth(Month coldestMonth) {
        this.coldestMonth = coldestMonth;
    }

    public Boolean getSkiResortsExist() {
        return skiResortsExist;
    }

    public void setSkiResortsExist(Boolean skiResortsExist) {
        this.skiResortsExist = skiResortsExist;
    }

    public boolean searchByColdstMonth() {
        return coldestMonth != null;
    }

    public boolean searchBySkiResortsExisting() {
        return skiResortsExist != null;
    }
}
