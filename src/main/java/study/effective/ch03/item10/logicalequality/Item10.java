package study.effective.ch03.item10.logicalequality;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Item10 {
    public static void main(String[] args ) {
        // Physical Equality
        SameNameOtherPerson sameNameOtherPerson1 = new SameNameOtherPerson("sajacaros");
        SameNameOtherPerson sameNameOtherPerson2 = new SameNameOtherPerson("sajacaros");
        log.info("same name other person : {}", sameNameOtherPerson1.equals(sameNameOtherPerson2));

        // Logical Equality
        SameNameSamePerson sameNameSamePerson1 = new SameNameSamePerson("sajacaros");
        SameNameSamePerson sameNameSamePerson2 = new SameNameSamePerson("sajacaros");
        log.info("same name same person : {}", sameNameSamePerson1.equals(sameNameSamePerson2));
    }
}
