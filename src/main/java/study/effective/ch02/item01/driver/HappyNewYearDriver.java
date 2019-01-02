package study.effective.ch02.item01.driver;

import study.effective.ch02.item01.service.ServiceInterface;
import study.effective.ch02.item01.service.ServiceProvider;

public class HappyNewYearDriver implements Driver{
    private HappyNewYearDriver() {

    }

    private static Driver driver;
    private static ServiceInterface service = new ServiceInterface.HappyNewYear();
    static {
        driver = new HappyNewYearDriver();
        ServiceProvider.registerDriver("happyNewYear", driver);
    }


    @Override
    public ServiceInterface getService() {
        return service;
    }
}
