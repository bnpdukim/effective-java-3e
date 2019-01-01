package study.effectivejava3e.ch02.service;

import jdk.nashorn.internal.runtime.Context;

import java.util.HashMap;
import java.util.Map;

public  class ServiceProvider {
    private static ServiceProvider self = new ServiceProvider();
    private Map<String, String> services = new HashMap<>();

    private ServiceProvider() {

    }



    public String findClass(String serviceName) {
        return services.get(serviceName);
    }

    public static ServiceProvider getInstance() {
        return self;
    }
}
