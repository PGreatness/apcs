//Ahnaf Hasan
//APCS2 pd08
//HW05 -- Step1: Split, Step 2: ?, Step 3: Sorted!
//2018-2-6

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm:
  The algorithm splits each section in half
  and then continuously does so until the
  fundamental list of 1 element is made. 
  Then, it merges all of them together and
  sorts them as individual arrays. The fully
  merged array is then returned.
  ======================================*/

public class MergeSort
{
    /******************************************************
     * int[] merge(int[],int[])
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b )
    {
	int[] retInt = new int[a.length + b.length];
	int currA = 0;
	int currB = 0;
	for (int i = 0; i < retInt.length; i++) {
	    if (currA != a.length && currB != b.length) {
		if (a[currA] > b[currB]) {
		    retInt[i] = b[currB];
		    currB++;
		}else{
		    retInt[i] = a[currA];
		    currA++;
		}
	    }else{
		break;
	    }
	}
	for (int j = currA + currB; j < retInt.length; j++) {
	    if (currA == a.length) {
		retInt[j] = b[currB];
		currB++;
	    }else{
		if (currB == b.length) {
		    retInt[j] = a[currA];
		    currA++;
		}
	    }
	}
	return retInt;
		  
    }//end merge()


    /******************************************************
     * int[] sort(int[])
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr )
    {
        int arrLength = arr.length;
        if (arrLength <= 1){
	    return arr;
	}
        int[] a = new int[arrLength / 2];
        int[] b = new int[arrLength - (arrLength/2)];
        for (int i = 0; i < a.length; i++){
            a[i] = arr[i];
	}
        for (int i = 0; i < b.length; i++){
            b[i] = arr[i + (arrLength/2)];
	}
        return merge(sort(a), sort(b));
    }//end sort()



//-------------------HELPERS-------------------------
//tester function for exploring how arrays are passed
//usage: print array, mess(array), print array. Whaddayasee?
public static void mess( int[] a ) {
    for( int i = 0 ; i<a.length; i++ )
	a[i] = 0;
}

//helper method for displaying an array
public static void printArray( int[] a ) {
    System.out.print("[");
    for( int i : a )
	System.out.print( i + ",");
    System.out.println("]");
}
//---------------------------------------------------


//main method for testing
public static void main( String [] args ) {


    int[] arr0 = {0};
    int[] arr1 = {1};
    int[] arr2 = {1,2};
    int[] arr3 = {3,4};
    int[] arr4 = {1,2,3,4};
    int[] arr5 = {4,3,2,1};
    int[] arr6 = {9,42,17,63,0,512,23};
    int[] arr7 = {9,42,17,63,0,9,512,23,9};
 
    System.out.println("\nTesting mess-with-array method...");
    printArray( arr3 );
    mess(arr3);
    printArray( arr3 );

    System.out.println("\nMerging arr1 and arr0: ");
    printArray( merge(arr1,arr0) );

      System.out.println("\nMerging arr4 and arr6: ");
      printArray( merge(arr4,arr6) );

      System.out.println("\nSorting arr4-7...");
      printArray( sort( arr4 ) );
      printArray( sort( arr5 ) );
      printArray( sort( arr6 ) );
      printArray( sort( arr7 ) );
          /*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
}//end main()

}//end class MergeSort
