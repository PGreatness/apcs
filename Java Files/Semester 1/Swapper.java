//Ahnaf Hasan
//APCS pd01
//HW38 -- Put It Together
//2017-11-21
/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   Firstly, the 2D array, known as arr in the
   code, is made. Then, ints d1,d2,d3, and d4
   are all initialized as 0. Display() method
   prints out the array with tabs and newlines.
   Then, the user is prompted to enter the 
   coordinates of the words they would like 
   moved around( not starting with 0). It then
   displays an array made by copying the array
   into a new array, called arr2, and switches
   the Strings around. If any of the coordinates
   are larger than the array itself, an error is
   printed.
   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import cs1.Keyboard; //import to use Keyboard.java
public class Swapper {
    public static final String LETTERS = "abcdefghijklmnopqrstivwxyz";
    public static String[][] arr = new String[2 + (int)(Math.random()*(9))][2 + (int)(Math.random()*(9))];
    public static void display(String[][] arr) {
	int x = 0; //x counter
	int y = 0; //y counter
	for ( String s[] : arr) {
	    for ( String str : s) { //how to access every element in
		//an array
		if (arr[0].length - 1 != y) { //if the y counter is not the same
		    //as the last slot number
		    System.out.print(arr[x][y] + "\t"); //same line print
		}else{
		    System.out.println(arr[x++][y]); //new line print
		}
		if (y == arr[0].length - 1) { //reseting y counter
		    y = 0;
		}else{
		    y++;
		}
	    }
	}
    }
    public static String populate() {
	String retStr = "";
	int w = 3 + (int)(Math.random()*(2));
	for (int f = w; f > 0; f--) {
	    int h = 1 + (int)(Math.random()*(26));
	    retStr += LETTERS.substring(h - 1, h);
	}
	return retStr;
    }
    public static void change(int x1, int y1, int x2, int y2) {
	if (x1 > arr.length || x2 > arr.length || 
	    y1 > arr[0].length || y2 > arr[0].length) {//if any of the user's
	    //inputs are out of bounds
	    System.out.println("\nError. Out of Bounds Input(s)");
	}else{
	    String first = arr[y1][x1];
	    String second = arr[y2][x2];
	    arr[y1][x1] = second;
	    arr[y2][x2] = first;
	    display(arr);
	}
    }
    public static void main(String[] args) {
	String w1 = "";
	String w2 = "";
	int x1 = 0;
	int x2 = 0;
	int y1 = 0;
	int y2 = 0;
	arr[0][0] = "";
	for (int i = 1; arr.length > i; i++) {
	    arr[i][0] = "" + i;
	}
	for (int f = 0; arr[0].length > f + 1; f++) {
	    arr[0][f + 1] = "" + (f + 1);
	}
	for (int a = 1; arr.length > a; a++) {
	    for ( int q = 1; arr[a].length > q; q++) {
		arr[a][q] = populate();
	    }
	}
	display(arr);
	try {
	    System.out.print("\nInput XCOR of first word: ");
	    x1 = Keyboard.readInt();
	    System.out.print("\nInput YCOR of first word: ");
	    y1 = Keyboard.readInt();
	    System.out.print("\nInput the XCOR of the second word: ");
	    x2 = Keyboard.readInt();
	    System.out.print("\nInput the YCOR of the second word: ");
	    y2 = Keyboard.readInt();
	}
	catch (Exception e) { } 
	change(x1, y1, x2, y2);
	System.out.println("\nUnfortunately, I couldn't the colors" +
			   " to work correctly. Just have a good eye" +
			   ", I guess. Sadness");
    }
}
