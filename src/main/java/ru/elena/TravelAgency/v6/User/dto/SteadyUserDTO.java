package main.java.ru.elena.TravelAgency.v6.User.dto;

import main.java.ru.elena.TravelAgency.v5.User.domain.SteadyUser;
import main.java.ru.elena.TravelAgency.v5.User.dto.UserDTO;

import java.util.HashMap;
import java.util.Map;

public class SteadyUserDTO extends UserDTO {
    private SteadyUser.DiscountRate rate;

    public enum DiscountRate {
        Zero(0f),
        Initial(3f),
        Middle(5f),
        Silver(7f),
        Gold(10f);

        private static Map<String, SteadyUser.DiscountRate> strItemNameMatchEnum;

        static {
            strItemNameMatchEnum = new HashMap<>();
            for (SteadyUser.DiscountRate item : SteadyUser.DiscountRate.values())
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

    public SteadyUser.DiscountRate getRate() {
        return rate;
    }

    public void setRate(SteadyUser.DiscountRate rate) {
        this.rate = rate;
    }
}
