package study.effective.ch02.item01.service;

import study.effective.ch02.item01.driver.Driver;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public  class ServiceProvider {
    private static final Map<String, String> services = new ConcurrentHashMap<>();
    private static final Map<String, Driver> drivers = new ConcurrentHashMap<>();

    private ServiceProvider() {}

    public static void register(String service, String serviceInterface) {
        services.put(service, serviceInterface);
    }


    public static String findClass(String serviceName) {
        return services.get(serviceName);
    }

    public static void registerDriver(String key, Driver driver) {
        drivers.put(key, driver);
    }

    public static ServiceInterface getService(String key) {
        return drivers.get(key).getService();
    }
}
