package ru.elena.TravelAgency.v5.Storage;

@FunctionalInterface
public interface SequenceGenerator<COUNTER_TYPE> {
    COUNTER_TYPE generateNextValue();
}
