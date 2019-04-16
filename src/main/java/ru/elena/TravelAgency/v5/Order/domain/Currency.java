package main.java.ru.elena.TravelAgency.v5.Order.domain;

import java.util.HashMap;

public enum Currency {
    RUB("Price in roubles (by default)"),
    USD("Price in dollar"),
    EUR("Price in euro");

    private String description;

    Currency(String description) {
        this.description = description;
    }

    private HashMap<String, Currency> strCurrencyHashMap;

    {
        strCurrencyHashMap = new HashMap<>();
        for (Currency currency : Currency.values())
            strCurrencyHashMap.put(currency.name(), currency);
    }

    public boolean currencyTypeExists(String currencyType) {
        return strCurrencyHashMap.containsKey(currencyType);
    }

    public boolean currencyTypeDoesNotExist(String currencyType) {
        return !currencyTypeExists(currencyType);
    }
}
