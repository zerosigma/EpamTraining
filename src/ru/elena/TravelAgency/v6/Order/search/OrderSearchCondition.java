package ru.elena.TravelAgency.v6.Order.search;

import ru.elena.TravelAgency.v5.common.business.search.BaseSearchCondition;

public class OrderSearchCondition extends BaseSearchCondition<Long> {
    private Long userID;
    private Long cityID;
    private Long countryID;
    private Integer price;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getCityID() {
        return cityID;
    }

    public void setCityID(Long cityID) {
        this.cityID = cityID;
    }

    public Long getCountryID() {
        return countryID;
    }

    public void setCountryID(Long countryID) {
        this.countryID = countryID;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public boolean searchByPrice() {
        return price != null;
    }

    public boolean searchByUser() {
        return userID != null;
    }

    public boolean searchByCity() {
        return cityID != null;
    }

    public boolean searchByCountry() {
        return countryID != null;
    }
}
