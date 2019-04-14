package ru.elena.TravelAgency.v5.Storage;

public final class GlobalIDGenerator {
    private static long currentCounterValue = 0;

    private GlobalIDGenerator() {}

    public static long generateNextValue() {
        return ++currentCounterValue;
    }
}
