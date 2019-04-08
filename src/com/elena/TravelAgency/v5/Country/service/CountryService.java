package com.elena.TravelAgency.v5.Country.service;

import com.elena.TravelAgency.v5.Country.domain.BaseCountry;
import com.elena.TravelAgency.v5.common.business.service.BaseService;

public interface CountryService extends BaseService<BaseCountry, Long> {
    BaseCountry find(String name);
}
