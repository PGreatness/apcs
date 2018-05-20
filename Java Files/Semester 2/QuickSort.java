//Ahnaf Hasan
//APCS2 pd08
//HW18 -- So So Quick
//2018-03-12
  
/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm: The algorithm checks
 * if the left side of the array collides with the right 
 * side. If not, it sets the pivot point as the previous 
 * pivot point given that the previous pivot point was the 
 * last element of the array. It then sorts through each of
 * the two sides that has been created with the pivot point.
 * QSort(arr): Calls the partition function
 *
 * 2a. Worst pivot choice and associated runtime: 
 *     The array is sorted in descending order and the pivot
 *     is chosen to be the first element in the list since this 
 *     would cause the array to have to be iterated through
 *     n times in order to cover for all the possible pivots.
 *     O(n^2)
 * 2b. Best pivot choice and associated runtime:
 *     The array is sorted in ascending order and the pivot
 *     is chosen as the last element of the list because this
 *     would cause the array to have been touched only once.
 *     O(n*logn)
 * 3. Approach to handling duplicate values in array: There
 * doesn't seem to be a difference in the runtime for duplicates.
 *
 *****************************************************/

public class QuickSort
{
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
  public static void swap( int x, int y, int[] o ) {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  //print input array 
  public static void printArr( int[] a ) {
    for ( int o : a )
	    System.out.print( o + " " );
    System.out.println();
  }

  //shuffle elements of input array
  public static void shuffle( int[] d ) {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
    }
  }

  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal ) {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }
  //--------------^  HELPER METHODS  ^--------------



  /*****************************************************
   * void qsort(int[])
   * @param d -- array of ints to be sorted in place
   *****************************************************/
  public static void qsort( int[] d )
  { 
    qSortH(d, 0, d.length - 1);
  }
  public static void qSortH(int[] arr, int left, int right) {
    if (left < right) {
      int pvt = partition(arr, left, right);
      qSortH(arr, left, pvt - 1);
      qSortH(arr, pvt + 1, right);
    }
  }
  public static int partition(int[] a, int start, int end) {
    return partition(a, start, end, end);
  }
  public static int partition(int[] ar, int startPos, int endPos, int pvtPos) {
    int v = ar[pvtPos];
    swap(pvtPos, endPos, ar);
    int s = startPos;
    for (int i = startPos; i < endPos; i++) {
      if (ar[i] <= v) {
        swap(i, s, ar);
        s++;
      }
    }
    swap(s, endPos, ar);
    return s;
  }
  //you may need a helper method...


  //main method for testing
  public static void main( String[] args )
  {

    //get-it-up-and-running, static test case:
    int [] arr1 = {7,1,5,12,3};
    System.out.println("\narr1 init'd to: " );
    printArr(arr1);

    qsort( arr1 );	
    System.out.println("arr1 after qsort: " );
    printArr(arr1);

    // randomly-generated arrays of n distinct vals
    int[] arrN = new int[10];
    for( int i = 0; i < arrN.length; i++ )
    arrN[i] = i;
       
    System.out.println("\narrN init'd to: " );
    printArr(arrN);

    shuffle(arrN);
    System.out.println("arrN post-shuffle: " );
    printArr(arrN);

    qsort( arrN );
    System.out.println("arrN after sort: " );
    printArr(arrN);
    /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/



    //get-it-up-and-running, static test case w/ dupes:
    int [] arr2 = {7,1,5,12,3,7};
    System.out.println("\narr2 init'd to: " );
    printArr(arr2);

    qsort( arr2 );	
    System.out.println("arr2 after qsort: " );
    printArr(arr2);


    // arrays of randomly generated ints
    int[] arrMatey = new int[20];
    for( int i = 0; i < arrMatey.length; i++ )
    arrMatey[i] = (int)( 48 * Math.random() );
       
    System.out.println("\narrMatey init'd to: " );
    printArr(arrMatey);

    shuffle(arrMatey);
    System.out.println("arrMatey post-shuffle: " );
    printArr(arrMatey);

    qsort( arrMatey );
    System.out.println("arrMatey after sort: " );
    printArr(arrMatey);
    /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class QuickSort
