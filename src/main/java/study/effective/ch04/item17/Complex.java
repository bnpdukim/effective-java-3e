package study.effective.ch04.item17;

public class Complex {
    private final double re;
    private final double im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double realPart() {
        return re;
    }

    public double imaginaryPart() {
        return im;
    }

    public Complex plus(Complex c) {
        return new Complex(re + c.re, im+c.im);
    }

    public Complex minus(Complex c) {
        return new Complex(re - c.re, im - c.im);
    }
    public Complex times(Complex c) {
        return new Complex(re * c.re - im *c.im, re*c.im - im * c.re);
    }

    public Complex dividedBy(Complex c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new Complex((re*c.re + im*c.im) / tmp, (im*c.re - re*c.im)/tmp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Complex)) return false;
        Complex complex = (Complex) o;
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
