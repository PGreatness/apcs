//Ahnaf Hasan
//APCS2 pd08
//HW10 -- [Freddie Mercury, Brian May, Roger Taylor, John Deacon] x n
//2018-02-27

/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 */

public class QueenBoard
{
  private int[][] _board;
    
  public QueenBoard( int size ) 
  {
    _board = new int[size][size];
  }

  
  /***
   * precondition: board is filled with 0's only.
   * postcondition: 
   * If a solution is found, board shows position of N queens, 
   * returns true.
   * If no solution, board is filled with 0's, 
   * returns false.
   */
  public boolean solve()
  {
    int i = 0;
    while (i < _board.length) {
      solveH(i);
      i++;
   }
   return false;
  }


  /**
   *Helper method for solve. 
   */
  private boolean solveH( int col ) 
  {
    int j = 0;
    for (int w = 0; w < _board[0].length; w++) {
      if (_board[w][col] == 1) {
        j = w + 1;
        removeQueen(w, col);
      }
    }
    for (; j < _board[0].length; j++) {
      if (_board[j][col] == 0) {
        addQueen(j, col);
        col++;
        break;
      }
      if (j + 1 >= _board[0].length) {
        solveH(col - 1);
      }
    }
    return false;
  }


  public void printSolution()
  {
    String printableBoard = "";
    for (int a = 0; a < _board.length; a++) {
      for (int b = 0; b < _board[0].length; b++) {
        if (_board[a][b] == 0) {
          printableBoard += "_  ";
        }
        if (_board[a][b] < 0) {
          printableBoard += "x  ";
        }
        if (_board[a][b] == 1) {
          printableBoard += "Q  ";
        }
      }
      printableBoard += "\n";
    }
    System.out.println(printableBoard + "\n");
  }



  //================= YE OLDE SEPARATOR =================

  /***
   * Adds a queen to the specified location. Rows and columns follow
   * normal cs procedure, with both starting at 0. 
   * precondition: 
   * postcondition: A queen, represented by a 1, is placed in the location
   * in _board with row and column as specified
   */
  private boolean addQueen(int row, int col){
    if(_board[row][col] != 0){
	    return false;
    }
    _board[row][col] = 1;
    int offset = 1;
    while(col+offset < _board[row].length){
	    _board[row][col+offset]--;
	    if(row - offset >= 0){
        _board[row-offset][col+offset]--;
	    }
	    if(row + offset < _board.length){
        _board[row+offset][col+offset]--;
	    }
	    offset++;
    }
    return true;
  }


  /***
   * Removes a queen to the specified location. Rows and columns follow
   * normal cs procedure, with both starting at 0.
   * precondition: 
   * postcondition: A queen, represented by a 1, is removed from the location
   * in _board with row and column as specified
   */
  private boolean removeQueen(int row, int col){
    if ( _board[row][col] != 1 ) {
	    return false;
    }
    _board[row][col] = 0;
    int offset = 1;

    while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++;
	    if( row - offset >= 0 ) {
        _board[row-offset][col+offset]++;
	    }
	    if( row + offset < _board.length ) {
        _board[row+offset][col+offset]++;
	    }
	    offset++;
    }
    return true;
  }


  /***
   * Shows a string representation of the board. The board is given as a String.
   * precondition: 
   * postcondition: The board is represented as a String.
   */
  public String  toString() 
  {
    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
        ans += _board[r][c]+"\t";
	    }
	    ans += "\n";
    }
    return ans;
  }


  //main method for testing...
  public static void main( String[] args )
  {
    QueenBoard b = new QueenBoard(5);
    System.out.println(b);
    b.addQueen(3,0);
    //b.addQueen(0,1); messes up the solution
    System.out.println(b);
    b.removeQueen(3,0);
    System.out.println(b);
    b.solve();
    System.out.println(b);
    b.printSolution();
    QueenBoard c = new QueenBoard(6);
    c.solve();
    System.out.println(c);
    c.printSolution(); //Seems to get stuck when getting to the 3rd column. Can't fix :(
  }
    
}//end class
