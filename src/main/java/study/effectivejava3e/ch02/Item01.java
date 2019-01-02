package study.effectivejava3e.ch02;

import lombok.extern.slf4j.Slf4j;
import study.effectivejava3e.ch02.service.ServiceInterface;
import study.effectivejava3e.ch02.service.ServiceProvider;

import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.*;


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


        // 서비스 등록
        ServiceProvider.getInstance().regist("default", "study.effectivejava3e.ch02.service.ServiceInterface$Default");
        ServiceProvider.getInstance().regist("newYear", "study.effectivejava3e.ch02.service.ServiceInterface$HappyNewYear");
        // 서비스 조회
        String className = ServiceProvider.getInstance().findClass("default");
        // 서비스 생성
        execute(className);
        className = ServiceProvider.getInstance().findClass("newYear");
        execute(className);
    }

    private static void execute(String className) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException {
        ServiceInterface serviceInterface = (ServiceInterface) Class.forName(className).getConstructor().newInstance();
        serviceInterface.print();
    }
}
