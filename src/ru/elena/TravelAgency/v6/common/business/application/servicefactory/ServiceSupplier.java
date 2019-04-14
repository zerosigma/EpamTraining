package ru.elena.TravelAgency.v6.common.business.application.servicefactory;

import ru.elena.TravelAgency.v5.City.service.CityService;
import ru.elena.TravelAgency.v5.Country.service.CountryService;
import ru.elena.TravelAgency.v5.Order.service.OrderService;
import ru.elena.TravelAgency.v5.User.service.UserService;
import ru.elena.TravelAgency.v5.common.business.application.StorageType;
import ru.elena.TravelAgency.v5.common.business.application.servicefactory.MemoryArrayServiceFactory;
import ru.elena.TravelAgency.v5.common.business.application.servicefactory.MemoryCollectionServiceFactory;
import ru.elena.TravelAgency.v5.common.business.application.servicefactory.ServiceFactory;

public final class ServiceSupplier {
    private static volatile ServiceSupplier INSTANCE;
    private ServiceFactory serviceFactory;

    public static ServiceSupplier getInstance() {
        return INSTANCE;
    }

    public static ServiceSupplier newInstance(StorageType storageType) {

        if (INSTANCE == null) {
            synchronized (ServiceSupplier.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ServiceSupplier(storageType);
                }
            }
        }
        return INSTANCE;
    }

    private ServiceSupplier(StorageType storageType) {
        initServiceFactory(storageType);
    }

    private void initServiceFactory(StorageType storageType) {
        switch (storageType) {
            case MEMORY_ARRAY: {
                serviceFactory = new MemoryArrayServiceFactory();
            }
            default: {
                serviceFactory = new MemoryCollectionServiceFactory();
            }
        }
    }

    public CityService getCityService() {
        return serviceFactory.getCityService();
    }

    public CountryService getCountryService() {
        return serviceFactory.getCountryService();
    }

    public OrderService getOrderService() {
        return serviceFactory.getOrderService();
    }

    public UserService getUserService() {
        return serviceFactory.getUserService();
    }
}
