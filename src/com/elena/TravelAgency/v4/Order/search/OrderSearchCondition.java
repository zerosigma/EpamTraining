package com.elena.TravelAgency.v4.Order.search;

import com.elena.TravelAgency.v4.common.search.BaseSearchCondition;

public class OrderSearchCondition extends BaseSearchCondition {
    private Integer price;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public boolean searchByPrice() {
        return price != null;
    }
}
