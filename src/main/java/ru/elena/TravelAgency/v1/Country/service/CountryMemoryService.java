package main.java.ru.elena.TravelAgency.v1.Country.service;

import main.java.ru.elena.TravelAgency.v1.Country.Country;
import main.java.ru.elena.TravelAgency.v1.Country.repo.CountryMemoryRepo;

public class CountryMemoryService {
    private CountryMemoryRepo countryMemoryRepo = new CountryMemoryRepo();

    public void addCountry(Country country) {
        countryMemoryRepo.addCountry(country);
    }

    public void deleteCountry(Long id) {
        countryMemoryRepo.deleteCountry(id);
    }

    public void deleteCountry(Country country) {
        countryMemoryRepo.deleteCountry(country);
    }

    public void findCountry(Long id) {
        countryMemoryRepo.findCountry(id);
    }

    public void findCountry(String name) {
        countryMemoryRepo.findCountry(name);
    }
}
