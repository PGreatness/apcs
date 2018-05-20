/*
Joshua Weiner
APCS2 pd08
HW #16: About Face
2018--03--07
*/

public class Select {

  public static int[] retArr;

  public static void main(String[] args) {
        Select test = new Select();
        Select test2 = new Select();
        int[] testArr = {6,4,7,2,9,3,5};
        int[] tester2 = {3,6,7,0,1,-2};
        //System.out.println(test.partition(0, testArr.length - 1, (testArr.length - 1) / 2, testArr));
        //System.out.println(test);
        retArr = test2.partition(testArr, 0, 6, 4);
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

  This function, compareSort, will take a given array. It will then compare the values in the array to a median value, and sort the elements of the array in order as compared to that median value (when the element is less than the median value). It will then return a more sorted array. The runtime of this function is O(n), because each swap function runs in constant time, and it runs down the length of the array which is O(n).
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

     /* This is where the new arrays are created and sorted through, the recursive step
     */
     int newPvt = s;

     int midLower = (first + newPvt) / 2;
     int midHigher = (newPvt + last) / 2;

     int[] arrLower  = partition(arr, first, newPvt, midLower);
     int[] arrHigher = partition(arr, newPvt, last, midHigher);

     arr = concat(arrLower, arrHigher);
     return arr;
    }
  }

  public static int[] concat(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr3.length; i++) {
            if(i  < arr1.length) {
                arr3[i] = arr1[i];
            }
            else {
                arr3[i] = arr2[i-arr1.length];
            }

        }
        return arr3;
    }

  //helper function, given indexes swaps two elements in the array
  public static int[] swap(int[] arr, int uno, int dos) {
    int store = arr[uno];
    arr[uno] = arr[dos];
    arr[dos] = store;
    return arr;
  }
}
