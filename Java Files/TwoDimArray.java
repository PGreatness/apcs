/******************************
 * class TwoDimArray
 * (completed)
 * practice working with 2D arrays
 ******************************/

// Ahnaf Hasan (with help from Clyde "Thluffy" Sinclair)
// APCS1 pd01
// HW34 -- 2D arrays
// 2017-11-16

public class TwoDimArray
{
  //postcond: prints each row of 2D int array a on its own line
  //          uses a FOR loop
  public static void print1( int[][] a )
  {
      for(int x = 0; a.length > x; x++) { //for the amount of rows...
	  for(int y = 0; a[x].length > y; y++){//...and for the length of the
	      //nested array
	      System.out.println(a[x][y]); //print out that specific array point
	  }
      }
  }


  //postcond: prints each row of 2D int array a on its own line
  //          uses a FOREACH loop
  public static void print2( int[][] a )
  {
      for ( int[] i : a) { //for each int in array a
	  for ( int j : i) { //and for each slot of array i
	      System.out.println(j); //print out j
	  }
      }
  }


  //postcond: returns sum of all items in 2D int array a
  public static int sum1( int[][] a )
  {
      int sum = 0; //initialize sum
      for (int[] i : a) { //for each array a, turn into an array called i
	  for (int j : i) { //and then for each value in i...
	      sum += j; //add the value of it to the sum
	  }
      }
      return sum; //return the sum, an int
  }


  //postcond: returns sum of all items in 2D int array a
  //          * uses helper fxn sumRow
  public static int sum2( int [][] m )
  {
      int sum = 0; //initialize sum
      int v = 0; //initialize a row counter
      for (int[] i : m) { //for each array in m, make an array called i
	  sum += sumRow( v, m); //add the sumRow of the row counter and
	  //original array to the stated sum
	  v++; //add 1 to the counter
      }
      return sum; //return sum, an int
  }


  //postcond: returns sum of all items on row r of 2D int array a
  //          uses a FOR loop
  public static int sumRow( int r, int[][] a )
  {
      int sum = 0; //initialize sum
      for (int i = 0; i < a[r].length; i++) { //for the width of an array...
	  sum += a[r][i]; //add the point to the sum
      }
      return sum; //return sum, an int
  }


  //postcond: returns sum of all items on row r of 2D int array a
  //          uses a FOREACH loop
  public static int sumRow2(int r, int[][] m)
  {
      int sum = 0; //initialize sum
      for ( int i : m[r]) { //for each value of a certain row of m...
	  sum += m[r][i]; //set sum as the addition of the previous sum and
	  //the point in question
      }
      return sum; //return the sum
  }


  public static void main( String [] args )
  {
  
      int [][] m1 = new int[4][2];
      int [][] m2 = { {2,4,6}, {3,5,7} };
      int [][] m3 = { {2}, {4,6}, {1,3,5} };
      print1(m1); // 0 0 0 0 0 0 0 0
      print1(m2); // 2 4 6 3 5 7
      print1(m3); // 2 4 6 1 3 5 
      print2(m1); // 0 0 0 0 0 0 0 0
      print2(m2); // 2 4 6 3 5 7 
      print2(m3); // 2 4 6 1 3 5 
      System.out.print("testing sum1...\n");
      System.out.println("sum m1 : " + sum1(m1)); // "sum m1 : 0"
      System.out.println("sum m2 : " + sum1(m2)); // "sum m2 : 27"
      System.out.println("sum m3 : " + sum1(m3)); // "sum m3 : 21"
      System.out.print("testing sum2...\n");
      System.out.println("sum m1 : " + sum2(m1)); // "sum m1 : 0"
      System.out.println("sum m2 : " + sum2(m2)); // "sum m2 : 27"
      System.out.println("sum m3 : " + sum2(m3)); // "sum m3 : 21"
      /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }

}//end class TwoDimArray
