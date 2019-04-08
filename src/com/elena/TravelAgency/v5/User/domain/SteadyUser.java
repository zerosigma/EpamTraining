package com.elena.TravelAgency.v5.User.domain;

import java.util.HashMap;
import java.util.Map;

public class SteadyUser extends User {
    private DiscountRate rate;

    public SteadyUser(String firstName, String lastName, Passport passport, DiscountRate rate) {
        super(firstName, lastName, passport);
        this.rate = rate;
    }

    public enum DiscountRate {
        Zero(0f),
        Initial(3f),
        Middle(5f),
        Silver(7f),
        Gold(10f);

        private static Map<String, DiscountRate> strItemNameMatchEnum;

        static {
            strItemNameMatchEnum = new HashMap<>();
            for (DiscountRate item : DiscountRate.values())
                strItemNameMatchEnum.put(item.name(), item);
        }

        public static boolean isStrItemNameBelongsToEnum(String itemName) {
            return strItemNameMatchEnum.containsKey(itemName);
        }

        private float discount;

        DiscountRate(float discount) {
            this.discount = discount;
        }

        public float getDiscount() {
            return discount;
        }
    }

    public DiscountRate getRate() {
        return rate;
    }

    public void setRate(DiscountRate rate) {
        this.rate = rate;
    }
}
