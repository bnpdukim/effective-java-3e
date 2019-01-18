package study.effective.ch04.item17;

public class ComplexWithStaticFactory {
    private final double re;
    private final double im;

    private ComplexWithStaticFactory(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static ComplexWithStaticFactory valueOf(double re, double im) {
        return new ComplexWithStaticFactory(re,im);
    }

    public double realPart() {
        return re;
    }

    public double imaginaryPart() {
        return im;
    }

    public ComplexWithStaticFactory plus(ComplexWithStaticFactory c) {
        return new ComplexWithStaticFactory(re + c.re, im+c.im);
    }

    public ComplexWithStaticFactory minus(ComplexWithStaticFactory c) {
        return new ComplexWithStaticFactory(re - c.re, im - c.im);
    }
    public ComplexWithStaticFactory times(ComplexWithStaticFactory c) {
        return new ComplexWithStaticFactory(re * c.re - im *c.im, re*c.im - im * c.re);
    }

    public ComplexWithStaticFactory dividedBy(ComplexWithStaticFactory c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new ComplexWithStaticFactory((re*c.re + im*c.im) / tmp, (im*c.re - re*c.im)/tmp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComplexWithStaticFactory)) return false;
        ComplexWithStaticFactory complex = (ComplexWithStaticFactory) o;
        return Double.compare(complex.re, re) == 0 &&
                Double.compare(complex.im, im) == 0;
    }

    @Override
    public int hashCode() {
        return 31*Double.hashCode(re) + Double.hashCode(im);
    }

    @Override
    public String toString() {
        return "("+re+", "+im+"i)";
    }
}
