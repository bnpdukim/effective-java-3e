package study.effective.ch03.item11;

import lombok.ToString;

import java.util.Objects;

@ToString
public final class PhoneNumberWithHash {
    private final int areaCode, prefix, lineNum;

    public PhoneNumberWithHash(int areaCode, int prefix, int lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    @Override
    public boolean equals(Object o) {
        if( o == this ) return true;
        if( !(o instanceof PhoneNumberWithHash) ) return false;
        PhoneNumberWithHash pn= (PhoneNumberWithHash)o;
        return pn.lineNum==lineNum && pn.prefix == prefix && pn.areaCode==areaCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaCode, prefix, lineNum);
    }
}
