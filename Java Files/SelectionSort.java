//Ahnaf Hasan
//APCS pd1
//HW51 -- Selection
//2017-12-11

/***************************************
 * class SelectionSort -- implements SelectionSort algorithm
 ***************************************/

import java.util.ArrayList;

public class SelectionSort 
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


    // VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void selectionSortV( ArrayList<Integer> data ) 
    {
	int a = 0;
	while (a < data.size()) {
	    for (int i = 0; i < data.size(); i++) {
		int first = data.get(i);
		for (int j = i; j < data.size() - 1; j++) {
		    if (data.get(j).compareTo(data.get(j + 1)) > 0) {
			int w = data.get(j);
			int q = data.get(j+1);
			data.set(j, q);
			data.set(j + 1, w);
			break;
		    }
		}
	    }
	    a++;
	}
    }//end selectionSortV


    // ArrayList-returning selectionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
   public static ArrayList<Integer> selectionSort (ArrayList<Integer> input)
    {
      ArrayList<Integer> in = new ArrayList();
      for (int e = 0; e < input.size(); e++) {
         int b = input.get(e);
         in.add(b);
      }
      int a = 0;
      while (a < in.size()) {
         for (int i = 0; i < in.size(); i++) {
            int first = in.get(i);
            for (int j = i + 1; j < in.size(); j++) {
               if (in.get(i).compareTo(in.get(j)) > 0) {
                  int w = in.get(i);
                  int q = in.get(j);
                  in.set(i, q);
                  in.set(j, w);
                  break;
               }
            }
         }
         a++;
      }
      return in;
   }


    public static void main( String [] args ) 
    {
	/*===============for VOID methods=============	
	ArrayList glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "ArrayList glen before sorting:\n" + glen );
	selectionSortV(glen);
	System.out.println( "ArrayList glen after sorting:\n" + glen );


	  ArrayList coco = populate( 10, 1, 1000 );
	  System.out.println( "ArrayList coco before sorting:\n" + coco );
	  selectionSortV(coco);
	  System.out.println( "ArrayList coco after sorting:\n" + coco );
	
	  ============================================*/


	  ArrayList glen = new ArrayList<Integer>();
	  glen.add(7);
	  glen.add(1);
	  glen.add(5);
	  glen.add(12);
	  glen.add(3);
	  System.out.println( "ArrayList glen before sorting:\n" + glen );
	  ArrayList glenSorted = selectionSort( glen );
	  System.out.println( "sorted version of ArrayList glen:\n" 
	  + glenSorted );
	  System.out.println( "ArrayList glen after sorting:\n" + glen );

	  ArrayList coco = populate( 10, 1, 1000 );
	  System.out.println( "ArrayList coco before sorting:\n" + coco );
	  ArrayList cocoSorted = selectionSort( coco );
	  System.out.println( "sorted version of ArrayList coco:\n" 
	  + cocoSorted );
	  System.out.println( "ArrayList coco after sorting:\n" + coco );
	  System.out.println( coco );
	  /*==========for AL-returning methods==========
	  ============================================*/

    }//end main

}//end class SelectionSort
