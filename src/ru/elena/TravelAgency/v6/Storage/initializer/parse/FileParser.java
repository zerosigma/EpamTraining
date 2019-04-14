package ru.elena.TravelAgency.v6.Storage.initializer.parse;

@FunctionalInterface
public interface FileParser<DATA_TYPE> {
    DATA_TYPE parseFile(String fileName) throws Exception;
}
