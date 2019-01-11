package study.effective.ch03.item14;

import lombok.ToString;

import java.util.Objects;

@ToString
public final class PhoneNumber implements Comparable<PhoneNumber>{
    private final int areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    @Override
    public boolean equals(Object o) {
        if( o == this ) return true;
        if( !(o instanceof PhoneNumber) ) return false;
        PhoneNumber pn= (PhoneNumber)o;
        return pn.lineNum==lineNum && pn.prefix == prefix && pn.areaCode==areaCode;
    }


    @Override
    public int hashCode() {
        return Objects.hash(areaCode, prefix, lineNum);
    }


    @Override
    public int compareTo(PhoneNumber phoneNumber) {
        int result = Integer.compare(areaCode, phoneNumber.areaCode);
        if(result == 0) {
            result = Integer.compare(prefix, phoneNumber.prefix);
            if(result == 0) {
                result = Integer.compare(lineNum, phoneNumber.lineNum);
            }
        }
        return result;
    }
}
