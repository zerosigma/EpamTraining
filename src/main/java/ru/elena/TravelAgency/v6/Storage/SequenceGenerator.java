package main.java.ru.elena.TravelAgency.v6.Storage;

@FunctionalInterface
public interface SequenceGenerator<COUNTER_TYPE> {
    COUNTER_TYPE generateNextValue();
}
