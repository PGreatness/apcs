public class Rational {
    private int numerator;
    private int denominator;
    public Rational() {
	numerator = 0;
	denominator = 1;
    }
    public Rational( int num, int denom) {
	this();
	if (denom == 0) {
	    System.out.println("Not valid denominator");
	    num = 0;
	    denom = 1;
	}else{
	    numerator = num;
	    denominator = denom;
	}
    }
    public String toString() {
	return numerator + "/" + denominator;
    }
    public double floatValue() {
	return (double)numerator / denominator;
    }
    public void multiply ( Rational r ) {
	numerator *= r.numerator;
	denominator *= r.denominator;
    }
    public void divide ( Rational r ) {
	numerator /= r.numerator;
	denominator /= r.denominator;
    }
    public void add (Rational r) {
	if (denominator == r.denominator) {
	    numerator = numerator + r.numerator;
	}else{
	    int hold = denominator;
	    numerator *= r.denominator;
	    denominator *= r.denominator;
	    r.denominator *= hold;
	    r.numerator *= hold;
	    numerator += r.numerator;
	    System.out.println(numerator +"/" + denominator);
	}
    }
        public void subtract (Rational r) {
	if (denominator == r.denominator) {
	    numerator = numerator -  r.numerator;
	}else{
	    int hold = denominator;
	    numerator *= r.denominator;
	    denominator *= r.denominator;
	    r.denominator *= hold;
	    r.numerator *= hold;
	    numerator -= r.numerator;
	    System.out.println(numerator +"/" + denominator);
	}
    }
    public static void main(String[] args) {
	Rational r = new Rational (2, 3);
	Rational s = new Rational (1, 2);
	r.subtract(s);
    }
}
