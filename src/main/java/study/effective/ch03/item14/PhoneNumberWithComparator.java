package study.effective.ch03.item14;

import lombok.ToString;

import java.util.Comparator;
import java.util.Objects;

@ToString
public final class PhoneNumberWithComparator implements Comparable<PhoneNumberWithComparator>{

    private final int areaCode, prefix, lineNum;

    private static final Comparator<PhoneNumberWithComparator> COMPARATOR =
            Comparator.comparingInt( (PhoneNumberWithComparator pn) -> pn.areaCode)
                    .thenComparingInt(pn->pn.prefix)
                    .thenComparingInt(pn->pn.lineNum);

    public PhoneNumberWithComparator(int areaCode, int prefix, int lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    @Override
    public boolean equals(Object o) {
        if( o == this ) return true;
        if( !(o instanceof PhoneNumberWithComparator) ) return false;
        PhoneNumberWithComparator pn= (PhoneNumberWithComparator)o;
        return pn.lineNum==lineNum && pn.prefix == prefix && pn.areaCode==areaCode;
    }


    @Override
    public int hashCode() {
        return Objects.hash(areaCode, prefix, lineNum);
    }


    @Override
    public int compareTo(PhoneNumberWithComparator phoneNumber) {
        return COMPARATOR.compare(this, phoneNumber);
    }
}
