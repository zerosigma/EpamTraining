package com.elena.TravelAgency.v5.City.domain;

import java.util.HashMap;
import java.util.Map;

public enum ClimateType {
    ARCTIC,
    SUBARCTIC,
    SUBANTARCTIC,
    MILD,
    TROPIC,
    SUBTROPIC;

    private static Map<String, ClimateType> strClimateTypeNameMap;

    static {
        strClimateTypeNameMap = new HashMap<>();
        for (ClimateType item : ClimateType.values())
            strClimateTypeNameMap.put(item.name(), item);
    }

    public static boolean isStrClimateNameExisting(String itemName) {
        return strClimateTypeNameMap.containsKey(itemName);
    }

    public static boolean isStrClimateNameNotExisting(String itemName) {
        return !strClimateTypeNameMap.containsKey(itemName);
    }
}
