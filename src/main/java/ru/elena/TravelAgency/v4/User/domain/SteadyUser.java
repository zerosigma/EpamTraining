package main.java.ru.elena.TravelAgency.v4.User.domain;

public class SteadyUser extends User {
    private DiscountRate rate;

    public SteadyUser(Long id, String firstName, String lastName, Passport passport, DiscountRate rate) {
        super(id, firstName, lastName, passport);
        this.rate = rate;
    }

    public enum DiscountRate {
        Zero(0f),
        Initial(3f),
        Middle(5f),
        Silver(7f),
        Gold(10f);

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
