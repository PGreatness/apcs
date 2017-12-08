//Ahnaf Hasan
//APCS pd01
//HW37 -- Be More Rational
//2017-11-20

public class Rational {
    private int numerator;
    private static int numHold; //may not be used
    private static int denomHold; //may not be used
    private int denominator;
    //***********Default Constructor**************
    public Rational() {
	numerator = 0;
	denominator = 1;
	numHold = 0;
	denomHold = 1;
    }
    //************Overloaded Constructor************
    public Rational( int num, int denom) {
	this();
	if (denom == 0) {
	    System.out.println("Not valid denominator");
	}else{
	    numerator = num;
	    numHold = num;
	    denominator = denom;
	    denomHold = denom;
	}
    }
    //********Overwritten toString()***************
    public String toString() {
	return numerator + "/" + denominator;
    }
    public double floatValue() { //reutrns the value of the rational as a
	//double
	return (double)numerator / denominator;
    }
    public void multiply ( Rational r ) { //multiplies Rational with another
	//Rational
	numerator *= r.numerator;
	denominator *= r.denominator;
    }
    public void divide ( Rational r ) { //same as multiply() but divide instead
	numerator /= r.numerator;
	denominator /= r.denominator;
    }
    public void add (Rational r) { //adds 2 Rationals
	if (denominator == r.denominator) { //if the bases are the same
	    numerator = numerator + r.numerator;
	}else{ //else change the bases by hold amount
	    int hold = denominator;
	    numerator *= r.denominator;
	    denominator *= r.denominator;
	    r.denominator *= hold;
	    r.numerator *= hold;
	    numerator += r.numerator;
	    System.out.println(numerator +"/" + denominator);
	}
    }
    public void subtract (Rational r) { //same as add() but subtracts
	if (denominator == r.denominator) {
	    numerator = numerator -  r.numerator;
	    System.out.println(numerator + "/" + denominator);
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
    public static int gcd(int a, int b) {
	int remainder; // Remainder Storage Unit(RSU)
	if (a == 0 || b == 0) { //don't divide by 0!
	    System.out.println("Error, divide by 0");
	}
	while (a % b != 0) { //if the remainder of a and b isn't 0...
	    remainder = a % b;//...set the remainder var as the remainder
	    //of a and b...
	    a = b; //...set a equal to b...
	    b = remainder; //..and then make b the remainder!
	}
	return b; //or just return b
    }
    public String reduce () { //reduces the Rational to simplest terms using
	//gcd() method
	int hold = gcd(numerator, denominator); //holds the gcd
	numerator /= hold;
	denominator /= hold;
	return numerator + "/" + denominator;
    }
    public int compareTo ( Rational r ) { //compares using the float values
	if ((this.floatValue()) == (r.floatValue())) { //same same
	    return 0;
	}else{
	    if ((this.floatValue()) > (r.floatValue())) { //this greater
		return 1;
	    }else{
		return -1; //!(this greater)
	    }
	}
    }
    public static void main(String[] args) {
	Rational r = new Rational (2, 6);
	Rational s = new Rational (1, 2);
	r.subtract(s);
	System.out.println(r.reduce());
    }
}
