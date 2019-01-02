package study.effective.ch02;

import lombok.extern.slf4j.Slf4j;
import study.effective.ch02.driver.DefaultDriver;
import study.effective.ch02.driver.Driver;
import study.effective.ch02.service.ServiceInterface;
import study.effective.ch02.service.ServiceProvider;

import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.sql.DriverManager;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;


@Slf4j
public class Item01 {
    public static Boolean valueOf(boolean b) {
        return b?Boolean.TRUE:Boolean.FALSE;
    }

    public enum WeekOfDay {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
        SATURDAY, SUNDAY

    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Item01.valueOf(true);

        BigInteger primeConstructor = new BigInteger(10, 100, new Random());
        BigInteger primeStatic = BigInteger.probablePrime(10, new Random());

        // 인스턴스화 불가 동반 클래스로 활용
        // new Collections();
        List list = Collections.emptyList();
        // java 8부터는 인터페이스내 정적 메소드 가능
        // List list = List.emptyList();

        // 쓰는 입장에서 EnumSet.of가 RegularEnumSet인지 JumboEnumSet인지 알 필요 없음.
        Set<WeekOfDay> weekOfDays =  EnumSet.of(WeekOfDay.MONDAY, WeekOfDay.TUESDAY, WeekOfDay.WEDNESDAY, WeekOfDay.THURSDAY, WeekOfDay.FRIDAY, WeekOfDay.SATURDAY, WeekOfDay.SUNDAY);


        log.info("-- service interface, provider registration api, service access api --");
        // 서비스 등록
        ServiceProvider.register("default", "study.effective.ch02.service.ServiceInterface$Default");
        ServiceProvider.register("newYear", "study.effective.ch02.service.ServiceInterface$HappyNewYear");
        // 서비스 조회
        String className = ServiceProvider.findClass("default");
        // 서비스 생성
        execute(className);
        className = ServiceProvider.findClass("newYear");
        execute(className);


        // ------------
        log.info("-- service provider interface --");
        Class.forName("study.effective.ch02.driver.DefaultDriver");
        Class.forName("study.effective.ch02.driver.HappyNewYearDriver");

        ServiceInterface service = ServiceProvider.getService("default");
        service.print();
        ServiceProvider.getService("happyNewYear").print();

    }

    private static void execute(String className) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException {
        // 리플렉션을 이용한 객체 생성
        ServiceInterface serviceInterface = (ServiceInterface) Class.forName(className).getConstructor().newInstance();
        serviceInterface.print();
    }

}
