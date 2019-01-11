package study.effective.ch03.item14;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class Item14 {
    public static void main(String[] args) {
        PhoneNumber pn1 = new PhoneNumber(2, 3, 5309);
        PhoneNumber pn2 = new PhoneNumber(1, 4, 5309);
        PhoneNumber pn3 = new PhoneNumber(3, 5, 5309);
        PhoneNumber pn4 = new PhoneNumber(4, 6, 5309);

        List<PhoneNumber> phoneNumbers = Arrays.asList(pn1, pn2, pn3, pn4);
        phoneNumbers.stream().sorted().forEach(pn->log.info(pn.toString()));

        log.info("---------------------------------------------------------------");

        PhoneNumberWithComparator pnc1 = new PhoneNumberWithComparator(2, 3, 5309);
        PhoneNumberWithComparator pnc2 = new PhoneNumberWithComparator(1, 4, 5309);
        PhoneNumberWithComparator pnc3 = new PhoneNumberWithComparator(3, 5, 5309);
        PhoneNumberWithComparator pnc4 = new PhoneNumberWithComparator(4, 6, 5309);

        List<PhoneNumberWithComparator> phoneNumberWithComparators = Arrays.asList(pnc1, pnc2, pnc3, pnc4);
        phoneNumberWithComparators.stream().sorted().forEach(pn->log.info(pn.toString()));
    }
}
