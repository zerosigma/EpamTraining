package main.java.ru.elena.TravelAgency.v6.User.domain;

public final class Passport {
    private String series;
    private String number;

    public Passport() {}

    public Passport(String series, String number) {
        this.series = series;
        this.number = number;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return series + " " + number;
    }
}
