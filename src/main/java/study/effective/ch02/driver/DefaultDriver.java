package study.effective.ch02.driver;

import lombok.extern.slf4j.Slf4j;
import study.effective.ch02.service.ServiceInterface;
import study.effective.ch02.service.ServiceProvider;

@Slf4j
public class DefaultDriver implements Driver{
    private DefaultDriver() {

    }

    private static DefaultDriver driver;
    private static ServiceInterface service = new ServiceInterface.Default();
    static {
        driver = new DefaultDriver();
        ServiceProvider.registerDriver("default", driver);
    }


    @Override
    public ServiceInterface getService() {
        return service;
    }
}
