package study.effective.ch03.item11;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Item11 {
    public static void main(String[] args) {
        PhoneNumber pn1 = new PhoneNumber(707, 867, 5309);
        PhoneNumber pn2 = new PhoneNumber(707, 867, 5309);

        Map<PhoneNumber, String> m = new HashMap<>();
        m.put(pn1,"제니");
        log.info("pn : {}",m.get(pn1));
        log.info("pn : {}",m.get(pn2));


        PhoneNumberWithHash pn3 = new PhoneNumberWithHash(708, 867, 5309);
        PhoneNumberWithHash pn4 = new PhoneNumberWithHash(708, 867, 5309);

        Map<PhoneNumberWithHash, String> m2 = new HashMap<>();
        m2.put(pn3,"제니");
        log.info("pn3 hashcode : {}, pn4 hashcode : {}", pn3.hashCode(), pn4.hashCode());
        log.info("pn : {}",m2.get(pn3));
        log.info("pn : {}",m2.get(pn4));

        m2.keySet().stream().forEach(k->log.info("{}",k));
    }
}
