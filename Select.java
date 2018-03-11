public class Select {
    int[] retArr;
    public int[] partition(int a, int b, int c, int[] arr) {
        int v = arr[c];
        swap(c, b, arr);
        int s = a;
        for (int i = 0; i < b - 1; i++) {
            if (arr[i] < v) {
                swap(s, i, arr);
                s += 1;
            }
        }
        swap(b, s, arr);
        retArr = arr;
        return arr;
    }
    public static int[] swap(int firstIndex, int secondIndex, int[] intArr) {
        if (intArr.length <= 1) {
            return intArr;
        }else{
            int firstNum = intArr[firstIndex];
            int secondNum = intArr[secondIndex];
            intArr[firstIndex] = secondNum;
            intArr[secondIndex] = firstNum;
        }
        return intArr;
    }
    public int findMag(int[] array, int magnitude) {
        if (magnitude >= array.length) {
            return -1;
        }else{
            sortByPart(array);
            retArr = array;
            return array[magnitude - 1];
        }
    }
    public int[] concat(int[] arr1, int[] arr2) {
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
    public int[] sortByPart(int[] unsorted) {
        if (unsorted.length <= 1) {
            return unsorted;
        }
        int leftEnd = unsorted.length / 2;
        int[] leftArr = new int[(unsorted.length / 2)];
        int[] rightArr = new int[(unsorted.length / 2)];
        for (int i = 0; i < unsorted.length; i++) {
            try {
                leftArr[i] = unsorted[i];
            }
            catch (Exception e) {
                rightArr[i % leftEnd] = unsorted[i];
            }
        }
        if ((leftArr.length - 1) % 2 == 0) {
        partition(0, leftArr.length - 1, (leftArr.length - 1) / 2, leftArr);
        }else{
            partition(0, leftArr.length - 1, ((leftArr.length - 1) / 2) + 1, leftArr);
        }
        if ((rightArr.length - 1) % 2 == 0) {
        partition(0, rightArr.length - 1, (rightArr.length - 1) / 2, rightArr);
        }else{
            partition(0, rightArr.length - 1, ((rightArr.length - 1) / 2) + 1, rightArr);
        }
        return concat(sortByPart(leftArr), sortByPart(rightArr));
    }
    public String toString() {
        String ans = "[ ";
        for (int j = 0; j < this.retArr.length; j++) {
            ans += this.retArr[j] + " ";
        }
        ans += "]";
        return ans;
    }
    public static void main(String[] args) {
        Select test = new Select();
        Select test2 = new Select();
        int[] testArr = {6,4,7,2,9,3,5};
        int[] tester2 = {3,6,7,0,1,-2};
        //System.out.println(test.partition(0, testArr.length - 1, (testArr.length - 1) / 2, testArr));
        //System.out.println(test);
        test2.partition(0, 6, 4, testArr);
        System.out.println(test2);
        test.findMag(testArr, 3);
        System.out.println(test);
    }
}