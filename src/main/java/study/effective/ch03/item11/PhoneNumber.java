package study.effective.ch03.item11;

import lombok.ToString;

@ToString
public final class PhoneNumber {
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
}
