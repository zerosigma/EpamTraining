package com.elena.TravelAgency.v5.Country.dto;

import com.elena.TravelAgency.v5.City.dto.CityDTO;
import com.elena.TravelAgency.v5.Country.domain.CountryDiscriminator;
import com.elena.TravelAgency.v5.common.business.dto.BaseDTO;

import java.util.List;

public abstract class BaseCountryDTO extends BaseDTO<Long> {
    protected String name;
    protected String language;
    protected String dialingCode;

    protected CountryDiscriminator discriminator;

    private List<CityDTO> cities;

    public BaseCountryDTO() {
        initDiscriminator();
    }

    protected abstract void initDiscriminator();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDialingCode() {
        return dialingCode;
    }

    public void setDialingCode(String dialingCode) {
        this.dialingCode = dialingCode;
    }

    public List<CityDTO> getCities() {
        return cities;
    }

    public void setCities(List<CityDTO> cities) {
        this.cities = cities;
    }
}
