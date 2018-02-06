// Team Large Land Machines
// Ahnaf Hasan (collaborators: Raymond Wu)
// APCS1 pd1
// HW54 -- One File to Bring Them All
// 2017-12-13

/******************************
 * class NMySorts -- implements bubbleSort, selectionSort, insertionSort
 ******************************/

import java.util.ArrayList;

public class MySorts
{
    /**************************************************
     * Classification of add(): O(n)
     ** Goes through the entire array and does an operation from each of the
        values in the list. Therefore, it occurs an n number of times.
     * Classification of addBin(): O(log n)
     ** Although the WHILE loop may seem like a FOR loop, causing everything
        to increase the complexity, the WHILE loop can actually be thought of
	as a really long IF statement, like...
     if ( n - 1 > 0) {
        true;
     }else{
        if ( n - 2 > 0 ) {
        true;
        }else{
          .
          .
          .
        This doesn't take up computation time.
     *************************************************/

  // VOID version of bubbleSort
  // look at current element and its right neighbor,
  //   swap if neighbor is less than current element
  // postcondition: data's elements sorted in ascending order
    /***************************************************
     * Classification: 
     ** Best Case: O(1)
     ** Worst Case: O(n)
     * Iterates through the entire collection comparing values and
       swapping. This, with n values, takes n amount of time to do so. 
       Best case is O(1) because at best, it swaps nothing and only compares.
       At worst, it has to compare and swap all of them, meaning O(n)
     **************************************************/
  public static void bubbleSort( ArrayList<Comparable> data )
  {
    int passes = 0;
    int numSwaps = 0;     // efficiency quantifier
    while ( passes < data.size() - 1 )    // n-1 passes are necessary to sort n elements
    {
      for (int i = 0; i < data.size()-1 ; i++)
      {
        if ( data.get(i).compareTo( data.get(i+1)) > 0 )
        {
          data.set( i, data.set(i+1,data.get(i)) );
          numSwaps++;
        }
      } // end for loop

      passes++;
    } // end while loop

    System.out.println("\n-----------> Total no. of swaps: " + numSwaps);
  } // end VOID bubbleSort method



  // VOID version of SelectionSort
  // find minimum of unsorted region, move to final resting place in sorted region
  // postcondition: data's elements sorted in ascending order
    /*****************************************************
     * Classification: O(n^2)
     ** Best Case: O(1)
     ** Worst Case: O(n^2)
     * At the best, the entire array is already sorted and it just needs to
       go through them, comparing values. However, for the worst case, the 
       values are all jumbled up, causing swaps to be needed at every step. 
       The computer needs to go through it once to check for a minimum value
       and then again for a comparison and swap. 
     ****************************************************/
  public static void selectionSort( ArrayList<Comparable> data )
  {
    int numSwaps = 0;     // efficiency quantifier

    // make n-1 passes through collection
    for( int passCtr = 1; passCtr < data.size(); passCtr++)
    {
      System.out.println( "commencing pass #" + passCtr + "..." );

      //iterate through ArrayList
      int minimumIndex = passCtr-1;                  // updates based on outer for loop
      Comparable minimumObject = data.get(minimumIndex);

      for( int i = passCtr-1; i < data.size(); i++ ) // updates based on outer for loop
      {
        if ( data.get(i).compareTo(minimumObject) < 0 )
        {
          minimumIndex = i;             // update minimumIndex
          minimumObject = data.get(i);  // update minimumObject
        }
      } // end INNER for loop

      data.set( passCtr-1, data.set(minimumIndex,data.get(passCtr-1)) );
      numSwaps++;
      // System.out.println( data );   // print String rep. of AL after every pass
    } // end OUTER for loop

    System.out.println("\n-----------> Total no. of swaps: " + numSwaps);
  } //end selectionSort


  // VOID version of InsertionSort
  // "walks" current element to final resting place in sorted region
  // postcondition: data's elements sorted in ascending order
    /***************************************************
     * Classification: O(n^2)
     ** Best Case: O(1)
     ** Worst Case: O(n^2)
     * The best case is if the list is already sorted, so the method just
       compares and ends. The worst is if the list is reversed because at
       every element, a swap needs to happen. 
     **************************************************/
  public static void insertionSort( ArrayList<Comparable> data )
  {
    int numSwaps = 0;

    for( int partition = 1; partition < data.size(); partition++ )
    {
	    //partition marks first item in unsorted region

	    //diag:
	    System.out.print( "\npartition: " + partition + "\ndataset: ");
	    System.out.println( data );

	    //traverse sorted region from right to left
	    for( int i = partition; i > 0; i-- )
      {

        // "walk" the current item to where it belongs
        // by swapping adjacent items
        if ( data.get(i).compareTo( data.get(i-1) ) < 0 ) {
          //diag:
          System.out.println( "swap indices "+(i-1)+" & "+i+"..." );
          data.set( i, data.set( i-1, data.get(i) ) );
          numSwaps++;
        }
        else
          break;
	    } // end INNER for loop
    } // end OUTER for loop

    System.out.println("\n-----------> Total no. of swaps: " + numSwaps);
  }//end insertionSort

} // end class MySorts
