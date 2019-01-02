package study.effective.ch02.driver;

import study.effective.ch02.service.ServiceInterface;
import study.effective.ch02.service.ServiceProvider;

public class HappyNewYearDriver implements Driver{
    private HappyNewYearDriver() {

    }

    private static Driver driver;
    static {
        driver = new HappyNewYearDriver();
        ServiceProvider.registerDriver("happyNewYear", driver);
    }


    @Override
    public ServiceInterface getService() {
        return new ServiceInterface.HappyNewYear();
    }
}
