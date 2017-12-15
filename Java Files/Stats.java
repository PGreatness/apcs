//Ahnaf Hasan and Tania Cao Su
// APCS1 pd01
// HW19 -- gcd 3 ways
// 2017-10-18

public class Stats{
    
    public static int mean(int a, int b){//returns the floor of the mean of
	//	a and b 
	return (int)(a + b) / 2;//solves for mean by adding both and dividing
    }
    
    public static double mean(double a, double b){
	return (a + b) / 2.0;// no conversion to double needed as
	//resulting data type can only be an error
    }
    
    public static int max(int a, int b){
	if (a > b){//checks if a is greater than b 
	    return a;//return will always be an integer
	}
	else{
	    return b;
	}
    }//no (int) required because a and b will always be ints
    
    public static double max(double a,double b){
        if (a > b){
            return a;
	}
        else{
            return b;
	}
    }
    
    public static int max(int a, int b, int c) {
	if (a > b) { //is a greater than b? if so...
	    if (a > c) { //check if a is also greater than c. if so...
		return a; //a is the mightest of them all
	    }else{
		return c;//c is actually the mightest of them all
	    }
	}else{
	    if (b > c){ //so if a is less than b, is b greater than c ??
		return b; //b is the mightest of all
	    }else{
		return c; //c is after all the mightest of them all
	    }
	}
    }

    //same comments as previous
    public static double max(double a, double b, double c) {
	if (a > b) {
	    if (a > c) {
		return a;
	    }else{
		return c;
	    }
	}else{
	    if (b > c){
		return b;
	    }else{
		return c;
	    }
	}
    }

    public static int gcd (int a, int b) //gcd method starts with 2 ints
    {
	int storeA = a; //store a in case i use it later
	int storeB = b; //store b in case i use it later
	if (max(a, b) == a){ //the min of the two would be the divisor
	    if (a == 0 || b == 0) { //checks if either is 0
		if (a == 0){ // if a is 0, return b
		    return b;
		}else{
		    return a; //if b is 0, return a
		}
	    }else{
		while (!(a % b == 0)&& !(storeB % b == 0)){ //if the remainder
		    //of a and b is NOT 0 AND the original value of b is also
		    //NOT divisible by b, ...
		    b = b - 1; //.. subtract 1 from b and try again
		}
	    }
	}else{
	    if (a == 0 || b == 0){ //check if either is 0
		if (a == 0){
		    return a; //same as related comment
		}else{
		    return b; //same as related comment
		}
	    }else{
		while (!(b % a == 0 && storeA % a == 0)){ //same as related
		    //comment but with b replaced with a and vise versa
		    a = a - 1; //see related comment
		}
	    }
	}
	return a; //needed a return statement in the end so this
    }

    /*
    divide the larger num by the smaller num. the remainder is taken and 
    replaces the the second num. the first num is replaced by b and the
    whole thing is repeated.
     */
    public static int gcdER (int a , int b) { //gcd with recursive calls
	if (a == 0 || b == 0) {
	    System.out.println("Error, divide by 0"); //don't divide by 0!
	}
	if (max(a, b) == b) { //check for max
	    if (b == 0) {
		return a; //if b = 0, return a
	    }else{
		return gcd( a, a % b); //take the value of a and do gcd of
		//a and the remainder
	    }
	}else{
	    if (a == 0) { //check for 0
		return b;
	    }else{
		return gcd(b, a); //see related comment
	    }
	}
    }//doesn't work

    /*
    the remainder of a and b is checked to see if it is equal to 0. if not,
    the value of a is exchanged with b and b takes on the value of the 
    remainder. this continues on and on until the remainder of a and b is
    finally 0. the value of the remainder, stored in b, is returned.
     */
    public static int gcdEW(int a, int b) {
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
    public static int geoMean(int a, int b, int c) {
	return (int)Math.pow(a * b * c, 0.333333); //Math.pow gives a^b as
	//(a, b). since fractions don't seem to work, 0.33333333.
    }

    //same comments as above
    public static double geoMean(double a, double b, double c) {
	return Math.pow(a * b * c, 0.3333333);
    }
    
    public static int geoMean(int a, int b){//returns the geometric
	//mean of a and b and returns the floor of that value
	return (int)Math.sqrt(a * b);
	//Must convert into integer 
    }
    
    public static double geoMean(double a,double b){
	return Math.sqrt(a * b);//uses math.sqrt to find geometric mean
    }
}
