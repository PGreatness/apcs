//Ahnaf Hasan
//HW57 -- How Deep Does the Rabbit Hole Go?
//APCS1 pd1
//2017-12-19

/***
 * class Matrix -- models a square matrix
 *
 * BACKGROUND:
 * A matrix is a rectangular array.
 * Its dimensions are numRows x numColumns.
 * Each element is indexed as (row,column): 
 *  eg,
 *   for 2 x 3 matrix M:
 *        -       -
 *   M =  | a b c |
 *        | d e f |
 *        -       -
 *   ... d is at position (2,1) or M[2,1] 
 *
 * TASK:
 * Implement methods below, categorize runtime of each. 
 * Test in main method.
 ***/


public class Matrix 
{
  //constant for default matrix size
  private final static int DEFAULT_SIZE = 2;

  private Object[][] matrix;

  //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
  public Matrix( ) 
    {
	matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
    }


  //constructor intializes an a*a matrix
  public Matrix( int a ) 
  {
      matrix = new Object[a][a];
  }


  //return size of this matrix, where size is 1 dimension
  private int size() 
  {
      return matrix[0].length;
  }


  //return the item at the specified row & column   
  private Object get( int r, int c ) 
  {
      return matrix[r - 1][c - 1];
  }


  //return true if this matrix is empty, false otherwise
  private boolean isEmpty() 
  {
      boolean retBoo = false;
      for (int i = 0; i < matrix.length; i++) {
	  for (int j = 0; j < matrix[0].length; j++) {
	      if (matrix[i][j] == null) {
		  retBoo = true;
		  break;
	      }
	  }
      }
      return retBoo;
  }


  //overwrite item at specified row and column with newVal
  //return old value
  private Object set( int r, int c, Object newVal ) 
  {
      Object oldVal = matrix[r][c];
      matrix[r][c] = newVal;
      return oldVal;
  }


  //return String representation of this matrix
  // (make it look like a matrix)
  public String toString() 
  {
      String retStr = "";
      for (int i = 0; i < matrix.length; i++) {
	  for (int k = 0; k < matrix[0].length; k++) {
	      if (k == 0) {
		  retStr += "[" + matrix[i][k] + ", ";
	      }else{
		  if (k == matrix[0].length - 1) {
		      retStr += matrix[i][k] + "]" + "\n";
		  }else{
		      if (k != 0 && k != matrix[0].length - 1) {
			  retStr += matrix[i][k] + ", ";
		      }
		  }
	      }
	  }
      }
      return retStr;
  }

    
  //override inherited equals method
  //criteria for equality: matrices have identical dimensions,
  // and identical values in each slot
  public boolean equals( Matrix rightSide )
    {
	boolean retBoo = true;
	if (this.matrix[0].length == rightSide.matrix[0].length && 
	    this.matrix.length == rightSide.matrix.length) {
	    for (int f = 0; f < matrix.length; f++) {
		for (int g = 0; g < matrix[0].length; g++) {
		    if ((this.get(f + 1, g + 1)) != (rightSide.get(f + 1, g + 1))) {
			retBoo = false;
			break;
		    }
		}
	    }
	}
	return retBoo;
    }
    
    
  //swap two columns of this matrix 
  //(1,1) is top left corner of matrix
  //row values increase going down
  //column value increase L-to-R
  public void swapColumns( int c1, int c2  ) 
  {
      Object[] arr1 = new Object[matrix.length];
      Object[] arr2 = new Object[matrix.length];
      for (int i = 0; i < matrix.length; i++) {
	  arr1[i] = matrix[i][c1 - 1];
	  arr2[i] = matrix[i][c2 - 1];
	  matrix[i][c1 - 1] = arr2[i];
	  matrix[i][c2 - 1] = arr1[i];
      }
  }


  //swap two rows of this matrix 
  //(1,1) is top left corner of matrix
  //row values increase going down
  //column value increase L-to-R
  public void swapRows( int r1, int r2  ) 
  {
      Object[] arr1 = new Object[matrix[0].length];
      Object[] arr2 = new Object[matrix[0].length];
      for (int i = 0; i < matrix[0].length; i++) {
	  arr1[i] = matrix[r1 - 1][i];
	  arr2[i] = matrix[r2 - 1][i];
	  matrix[r1 - 1][i] = arr2[i];
	  matrix[r2 - 1][i] = arr1[i];
      }
  }
    

  //main method for testing
  public static void main( String[] args ) 
  {
      Matrix mat = new Matrix(3);
      System.out.println("mat initially : \n" + mat);
      int counter = 0;
      for (int i = 0; i < mat.matrix.length; i++) {
       	  for (int j = 0; j < mat.matrix[0].length; j++) {
       	      mat.set(i, j, counter);
	      counter++;
       	  }
      }
      System.out.println("mat : \n" + mat);
      System.out.print("get (2,1) : " + mat.get(2, 1) + "\t");
      System.out.print("get (1,1) : " + mat.get(1, 1) + "\t");
      System.out.print("get (2,2) : " + mat.get(2, 2) + "\t");
      System.out.println("get (1,2) : " + mat.get(1, 2) + "\t");
      mat.swapColumns(1,2);
      System.out.println("mat after column swap : \n" + mat);
      mat.swapRows(1,2);
      System.out.println("mat after row swap : \n" + mat);
      Matrix josh = new Matrix(3);
      Matrix ua = new Matrix(5);
      for (int w = 0; w < josh.matrix.length; w++) {
	  for (int a = 0; a < josh.matrix[0].length; a++) {
	      josh.set(w, a, mat.get(w + 1, a + 1));
	      josh.set(a, w, 1);
	  }
      }
      System.out.println("josh : \n" + josh);
      System.out.println("Does mat equal josh? " + mat.equals(josh));
      System.out.println("Is mat empty? " + mat.isEmpty());
      System.out.println("Is ua empty? " + ua.isEmpty());
  }

}//end class Matrix
