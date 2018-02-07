//Team Macaroni (Roster: Aidan Griffin, Colin Hosking, and Ahnaf Hasan)

//APCS2 pd08

//HW03 -- I Am Still Searching

//2018-02-01

import cs1.Keyboard;
//uses Keyboard to facilitate with choosing numbers

/******************************************                           
 
 *Our algorithm: Starting from the                                        
 
 *bottom left corner, the finder goes                                       
 
 *through by checking the number and moving                                 
 
 *right or up if the desired number is                                      
 
 *smaller or larger than the array number,                                  
 
 *respectively. Breaks if column or row is                                  
 
 *too big.                                                                 
 
 *************************************/

public class MatrixFinder {
    
    int[][] arr;
    
    /******************************
     
     *Overloaded Constructor
     
     **Makes a new MatrixFinder of
     
     **certain length
     
     *****************************/
    
    public MatrixFinder(int n){
	
	arr = new int[n][n];
    
    }//end constructor(int)
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    //toString to display the array
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    public String toString() {
	
	String retString = "";
	
	for (int i = 0; i < arr.length; i++) {
	    
	    for (int j = 0; j < arr[0].length; j++) {
		
		if (j + 1 == arr[0].length) {
		    
		    System.out.print(arr[i][j] + "\n");
		
		}else{
	    
		    System.out.print(arr[i][j] + "\t");
		
		}
	    
	    }
	
	}
	
	return retString;
    
    }//end toString()
    
    
    //finder(int) method: used to find element in matrix
    
    //if the element is in the matrix, return its coordinates CS style(starting from 0)
    
    //if the element is not in the matrix return (-1,-1)
    
    public String finder(int number) {
	
	int row = arr.length - 1;
	
	int col = 0;
	double Stime = System.currentTimeMillis();
	System.out.println("Start Time: " + Stime);
	
	for (int i = 0; i < (2 * arr.length) - 2; i++) { //counter
	    
	    if (arr[row][col] == number) {
		System.out.println("Time taken: " + (System.currentTimeMillis() - Stime));
		
		return "(" + row + ", " + col + ")";
	    
	    }else{
		
		if (row - 1 < 0) {
		    
		    break;
		
		}else{
		    
		    if (arr[row][col] > number) {
			
			row--;
		    
		    }else{
			
			if (col + 1 != arr[0].length) {
			    
			    col++;
			
			}else{
			    
			    break;
			
			}
		    
		    }
		
		}
	    
	    }
	
	}
	System.out.println(System.currentTimeMillis() - Stime);
	
	return "(-1, -1)";
    
    }//end finder(int)
    
    

    public static void main (String[] args) {
	
	int choice = 1;
	
	MatrixFinder pop = new MatrixFinder(200);
	
	for (int a = 0; a < pop.arr.length; a++) {
	    
	    for (int w = 0; w < pop.arr[0].length; w++) {
		
		if (w == 0) {
		    
		    pop.arr[a][w] = a;
		
		}else{
		    
		    pop.arr[a][w] = (a + 2*w);
		
		}
	    
	    }
	
	}
        
	System.out.println(pop);
	
	try {
	    
	    System.out.println("What number? ");
	    
	    choice = Keyboard.readInt();
	
	}
	
	catch (Exception e) { }
	
	System.out.println(pop.finder(choice));
    
    }//end main()

}//end MatrixFinder
