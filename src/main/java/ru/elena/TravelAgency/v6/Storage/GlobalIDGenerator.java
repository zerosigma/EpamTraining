package main.java.ru.elena.TravelAgency.v6.Storage;

public final class GlobalIDGenerator {
    private static long currentCounterValue = 0;

    private GlobalIDGenerator() {}

    public static long generateNextValue() {
        return ++currentCounterValue;
    }
}
