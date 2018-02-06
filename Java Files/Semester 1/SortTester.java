// Team Large Land Machines
// Ahnaf Hasan (collaborators: Raymond Wu)
// APCS1 pd1
// HW53 -- Solid Comparative Analysis
// 2017-12-13

/******************************
 * class SortTester -- calls bubbleSort, selectionSort, insertionSort
 *                     in MySorts.java
 ******************************/

import java.util.ArrayList;

public class SortTester
{
  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond: lo < hi && size > 0
  //postcond: returns an ArrayList of random integers
  //          from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi ) {
    ArrayList<Integer> retAL = new ArrayList<Integer>();
    while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
    }
    return retAL;
  }

  //randomly rearrange elements of an ArrayList
  public static void shuffle( ArrayList al ) {
    int randomIndex;
    for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  public static void main(String[] args)
  {
    System.out.println("================== bubbleSort =================");
    ArrayList glen = new ArrayList<Integer>();
    glen.add(7);
    glen.add(1);
    glen.add(5);
    glen.add(12);
    glen.add(3);

    System.out.println( "ArrayList glen before sorting:\n" + glen );
    MySorts.bubbleSort(glen);
    System.out.println( "ArrayList glen after sorting:\n" + glen );

    System.out.println("================ selectionSort ================");
    ArrayList coco = new ArrayList<Integer>();
    coco.add(7);
    coco.add(1);
    coco.add(5);
    coco.add(12);
    coco.add(3);

    System.out.println( "ArrayList coco before sorting:\n" + coco );
    MySorts.selectionSort(coco);
    System.out.println( "ArrayList coco after sorting:\n" + coco );

    System.out.println("================ insertionSort ================");
    ArrayList sam = new ArrayList<Integer>();
    sam.add(7);
    sam.add(1);
    sam.add(5);
    sam.add(12);
    sam.add(3);

    System.out.println( "ArrayList sam before sorting:\n" + sam );
    MySorts.insertionSort(sam);
    System.out.println( "ArrayList sam after sorting:\n" + sam );

    System.out.println("\n===============================================");
    System.out.println("              SORTING ALGO ANALYSIS");
    System.out.println("===============================================");

    System.out.println("\n\tBEST case, Bubble Sort:");
    System.out.println("ArrayList initially sorted in ascending order.\n");
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    *  When the list is initially in ascending order, no swaps are made
    *  as any element is always less than the element to its left.
    * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    ArrayList bestBubble = new ArrayList<Integer>();
    bestBubble.add(3);
    bestBubble.add(4);
    bestBubble.add(7);
    bestBubble.add(9);
    bestBubble.add(1000);
    System.out.println( "ArrayList coco before sorting:\n" + bestBubble );
    MySorts.bubbleSort(bestBubble);
    System.out.println( "ArrayList coco after sorting:\n" + bestBubble );

    System.out.println("\n\tWORST case, Bubble Sort:");
    System.out.println("ArrayList initially sorted in descending order.\n");
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    *  When the list is initially in descending order,
    *  a total of (n-1) + (n-2) + (n-3) + ... + 1 swaps must be made
    *  so that the current element (maximum in unsorted region) can reach its
    *  final resting place.
    * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    ArrayList worstBubble = new ArrayList<Integer>();
    worstBubble.add(1000);
    worstBubble.add(9);
    worstBubble.add(7);
    worstBubble.add(4);
    worstBubble.add(3);
    System.out.println( "ArrayList coco before sorting:\n" + worstBubble );
    MySorts.bubbleSort(worstBubble);
    System.out.println( "ArrayList coco after sorting:\n" + worstBubble );

    System.out.println("\n\tTrial 0, Selection Sort:");
    System.out.println("ArrayList initially sorted in ascending order.\n");
    ArrayList bestSelection = new ArrayList<Integer>();
    bestSelection.add(3);
    bestSelection.add(4);
    bestSelection.add(7);
    bestSelection.add(9);
    bestSelection.add(1000);
    System.out.println( "ArrayList coco before sorting:\n" + bestSelection );
    MySorts.selectionSort(bestSelection);
    System.out.println( "ArrayList coco after sorting:\n" + bestSelection );

    System.out.println("\n\tTrial 1, Selection Sort:");
    System.out.println("ArrayList initially sorted in descending order.\n");
    ArrayList worstSelection = new ArrayList<Integer>();
worstSelection = new ArrayList<Integer>();
    worstSelection.add(1000);
    worstSelection.add(9);
    worstSelection.add(7);
    worstSelection.add(4);
    worstSelection.add(3);
    System.out.println( "ArrayList coco before sorting:\n" + worstSelection );
    MySorts.selectionSort(worstSelection);
    System.out.println( "ArrayList coco after sorting:\n" + worstSelection );
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    *  In selection sort, a swap must be made in each pass (including self-swap).
    *  Thus, a total of n-1 swaps must be made for any ArrayList.
    * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    System.out.println("\n\tBEST case, Insertion Sort:");
    System.out.println("ArrayList initially sorted in ascending order.\n");
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    *  When the list is initially in ascending order, no swaps are made as each
    *  element is greater than its left neighbor, and less than its right neighbor.
    * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    ArrayList bestInsertion = new ArrayList<Integer>();
    bestInsertion.add(3);
    bestInsertion.add(4);
    bestInsertion.add(7);
    bestInsertion.add(9);
    bestInsertion.add(1000);
    System.out.println( "ArrayList coco before sorting:\n" + bestInsertion );
    MySorts.insertionSort(bestInsertion);
    System.out.println( "ArrayList coco after sorting:\n" + bestInsertion );

    System.out.println("\n\tWORST case, Selection Sort:");
    System.out.println("ArrayList initially sorted in descending order.\n");
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    *  When the list is initially in descending order,
    *  element i must swap i times to reach its final relative position.
    *  Thus, for a total of 1 + 2 + 3 + ... + (n-1) swaps must be made.
    * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    ArrayList worstInsertion = new ArrayList<Integer>();
    worstInsertion.add(1000);
    worstInsertion.add(9);
    worstInsertion.add(7);
    worstInsertion.add(4);
    worstInsertion.add(3);
    System.out.println( "ArrayList coco before sorting:\n" + worstInsertion );
    MySorts.insertionSort(worstInsertion);
    System.out.println( "ArrayList coco after sorting:\n" + worstInsertion );

  } // end main method
} // end SortTester class
