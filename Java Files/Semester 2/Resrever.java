//Ahnaf Hasan
//APCS2 pd08
//HW07 -- A Man, A Plan, A Canal: Panama!
//2018-2-13

public class Resrever {

    public static String reverseN (String str) {
	String retStr = "";
	for (int i = str.length(); i > 1; i--) {
	    retStr += str.substring(i - 1, i);
	}
	retStr += str.substring(0, 1);
	return retStr;
    }
    public static String merge (String strA, String strB) {
	String retStr = strB + strA;
	return retStr;
    }
    public static String reverseLog(String str) {
	if (str.length() <= 1) {
	    return str;
	}
	int leftLen = str.length() / 2;
	String Left = str.substring(0, leftLen);
	String Right = str.substring(leftLen, str.length());
	return merge(reverseLog(Left), reverseLog(Right));
    }
	
    public static void main(String[] args) {
	String test1 = "stressed\n"; //newline character test
	String test2 = "stressed\n";
	String test3 = "racecars\t"; //tab test
	String test4 = "math";
	String test5 = "Johnny was a good boy"; //capitalization
	String test6 = "you can't see JOHN CENNAAAAAAAAAA!!!!!";//puncuations
	String test7 = "words";
	String test8 = "tested";
	System.out.println(test1);
	System.out.println(test2);
	System.out.println(test3);
	System.out.println(test4);
	System.out.println(test5);
	System.out.println(test6);
	System.out.println(test7);
	System.out.println(test8);
	System.out.println("==========Reversed=========\n");
	System.out.println("Linear: " + reverseN(test1) + "\n");
	System.out.println("Log: " +reverseLog(test2) + "\n");
	System.out.println("Linear: " + reverseN(test2) + "\n");
	System.out.println("Log: " +reverseLog(test3) + "\n");
	System.out.println("Linear: " + reverseN(test3) + "\n");
	System.out.println("Log: " +reverseLog(test4) + "\n");
	System.out.println("Linear: " + reverseN(test4) + "\n");
	System.out.println("Log: " +reverseLog(test5) + "\n");
	System.out.println("Linear: " + reverseN(test5) + "\n");
	System.out.println("Log: " +reverseLog(test6) + "\n");
	System.out.println("Linear: " + reverseN(test6) + "\n");
	System.out.println("Log: " +reverseLog(test7) + "\n");
	System.out.println("Linear: " + reverseN(test7) + "\n");
	System.out.println("Log: " +reverseLog(test8) + "\n");
	System.out.println("Linear: " + reverseN(test8) + "\n");
    }
}
