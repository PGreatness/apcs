public class FastSelect {
    int[] arries;
    public FastSelect(int[] anArr) {
        arries = anArr;
    }
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
    public int findNum(int[] array, int magnitude) {
        for (int i = 0; i < array.length - 1; i ++) {
            findNumH(array);
        }
        return array[magnitude];
    }
    public int[] findNumL(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int leftArr = ((int)array.length / 2);
        int leftPiv = ((int) array.length / 4);
        int[] tempArr = new int[leftArr];
        partition(0, leftArr, leftPiv, array);
        for (int i = 0; i < tempArr.length; i++) {
            tempArr[i] = array[i];
        }
        return findNumL(tempArr);
    }
    public int[] findNumR(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int leftArr = (array.length - ((int)array.length / 2) - 1);
        int rightPiv = ((int) (leftArr + (array.length - 1) / 2));
        int[] tempArr = new int[leftArr];
        partition(leftArr + 1, array.length - 1, rightPiv, array);
        for (int i = leftArr; i < tempArr.length; i++) {
            tempArr[i] = array[i];
        }
        return findNumR(tempArr);
    }
    public int[] findNumH(int[] array) {
        if (array.length <= 2) {
            return array;
        }
        int divider = array.length / 2;
        partition(0, divider, array.length / 4, array);
        int pivotR = (divider + (array.length - 1)) / 2;
        partition(divider, array.length - 1, pivotR, array);
        return array;
    }
    public String toString() {
        String ans = "[ ";
        for (int j = 0; j < this.arries.length; j++) {
            ans += this.arries[j] + " ";
        }
        ans += "]";
        return ans;
    }
    public static void main(String[] args) {
        int[] someArray = {1,5,7,2,4,8,9,0};
        FastSelect fs = new FastSelect(someArray);
        fs.findNum(someArray, 3);
        System.out.println(fs);
    }
}