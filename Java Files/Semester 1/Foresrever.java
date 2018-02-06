//Ahanf Hasan
//APSC1 pd01
//HW20 -- For the Lulz(STRIKEN) Love of Strings
//2017-10-19

public class Foresrever{ //For + reverse(reverse)... sneaky
    static String thing = "";//final reversed product for a lack of a
    //better name
    static String temp = "";//temporary storage of String
    public static void fenceF(int fenceNum) { //FOR loop for fencing
	int origNum = fenceNum; //original num to put the last stake in
	for(fenceNum = fenceNum - 1; fenceNum > 0;fenceNum -= 1) {
	    //FOR loop with initialization, test, and updates
	    System.out.print("|--"); //the fence with the parts not repeating
	}
	if (origNum != 0) { //the very last post...
	    System.out.print("|"); //...driven in!
	}
	System.out.println("\n"); //spacing
    }
    public static void reverseF(String s) { //FOR loop for reversing
	//String oldS = s; //not used, kept in case i needed it
	int length = s.length(); //measure length
	for(length = s.length() - 1; length >= 0; length -= 1) {
	    //set up FOR loop
	    System.out.print(s.substring((s.length() - 1), s.length()));
	    //substrings break a string into specified parts with the first
	    //num being the starting point and the second part being the end
	    //point
	    s = s.substring(0, s.length() - 1); //sets s as a string with the
	    //very last part cut off
	}
    }
    //thank the CS gods for Java Visualizer
    public static void reverseR(String s) { //Using recursion for reversing
	if (s.length() == 0) { //when it reaches the end...
	    System.out.println(thing); //...print it out
	}else{
	    thing += s.substring(s.length() - 1, s.length()); //make thing into
	    //the last character of the string...
	    temp = s.substring(0, s.length() - 1);//...make temp everything else
	    reverseR(s.substring(0, s.length() - 1)); //length is decreased by
	    //1
	}
    }
    public static void main(String [] args) {
	System.out.println("Fence with 0 posts (FOR): \n");
	fenceF(0); // expected:
	System.out.println("Fence with 1 post (FOR): \n");
	fenceF(1); //expected: |
	System.out.println("Fence with 2 posts (FOR): \n");
	fenceF(2); //expected: |--|
       	System.out.println("Fence with 3 posts (FOR): \n");
	fenceF(3); //expected: |--|--|
	System.out.println("==================================\n");
	System.out.println("What did the backwards man say?\n");
	reverseF("Hello there old chap"); //expected: pahc dlo ereht olleH
	System.out.println("\n==================================\n");
	System.out.print(" 'This is not a palindrome' turns to : \n");
	reverseR("This is not a palindrome"); //expected: emordnilap a ton is
	                                      //sihT
    }
}
