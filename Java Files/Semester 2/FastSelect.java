/*
Ahnaf Hasan & Joshua Weiner - Ahnaf of This
APCS2
 pd08
HW #17: So So Fast

2018--03--11

*/


public class FastSelect {


  public static int[] retArr;


  public static void main(String[] args) {

        FastSelect test = new FastSelect();

        FastSelect test2 = new FastSelect();

        int[] testArr = {6,4,7,2,9,3,5};

        int[] tester2 = {3,6,7,0,1,-2};

        //System.out.println(test.partition(0, testArr.length - 1, (testArr.length - 1) / 2, testArr));

        //System.out.println(test);

        System.out.println(test2.findMag(testArr, 3));
        System.out.println(test2);

        retArr = test2.partition(tester2, 0, 5, 4);

        System.out.println(test2);


        //System.out.println(test);

    }

    public String toString() {

         String ans = "[ ";

         for (int j = 0; j < this.retArr.length; j++) {

             ans += this.retArr[j] + " ";

         }

         ans += "]";

         return ans;

     }

  /*
  arr represents the array given to be sorted

  first is the first index of the array

  last is the last index of the array

  middle is the middle index of the array found by integer division


  This function, compareSort, will take a given array. It will then
 compare the values in the array to a median value, and sort the 
 elements of the array in order as compared to that median value
 (when the element is less than the median value). It will then
 return a more sorted array. The runtime of this function is O(n),
 because each swap function runs in constant time,
 and it runs down the length of the array which is O(n).

  */

  
  /**

   * Partition has 1 FOR loop and a collection of 2 recursive calls. Being

   * that a FOR loop that iterates through the array automatically has a

   * runtime of O(n), it stands to reason that this is log(n) of a O(n)

   * method. This is because the array is split into 2 parts at each time

   * and the FOR loop is performed log(n) times.

   * At worst, this would be a O(nlogn).

   * @param arr array to search through

   * @param first starting index for sort

   * @param last ending index for sort

   * @param pvtPos central value to compare against

   * 
   * @see Best Case: array is sorted and of length 1

   * @see Worst Case: array is in descending order and of length n (n > 1)

   */

  public int[] partition(int[] arr, int first, int last, int pvtPos) {

    /* Base Case: array of one elements*/

    if (pvtPos == first && (pvtPos == last || last == pvtPos + 1))

      return arr;

    /* Recursive case: partition arrays of > 1 element

    */

    else {

      int v = arr[pvtPos];

      arr = swap(arr, pvtPos, last);

      int s = first;

      for (int i = first; i < last; i++) {

        if (arr[i] < v) {

          arr = swap(arr, s, i);

          s += 1;

        }

      }

     arr = swap(arr, last, s);


     /* This is where the unsorted parts of the array are sorted, 
        the recursive step

     */

     int newPvt = s;


     int midLower = (first + newPvt) / 2;

     int midHigher = (newPvt + last) / 2;


     partition(arr, first, newPvt, midLower);

     partition(arr, newPvt, last, midHigher);


     return arr;

    }

  }

  //helper function, given indexes swaps two elements in the array

  public static int[] swap(int[] arr, int uno, int dos) {

    int store = arr[uno];

    arr[uno] = arr[dos];

    arr[dos] = store;

    return arr;

  }

  public int findMag(int[] array, int magnitude) {

    retArr = partition(array, 0, array.length - 1, (array.length - 1) / 2 );

    return array[magnitude - 1];

  }

}
