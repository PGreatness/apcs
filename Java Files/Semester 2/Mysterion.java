//Ahnaf Hasan
//APCS2 pd08
//HW16 -- About Face
//2018-03-07

public class Mysterion {
    int[] array;
    int startPos = 0;
    int length;
    int mid;
    public Mysterion() {
        array = new int[5];
        int[] helper = {7, 1, 5, 12, 3};
        array = helper;
        startPos = 0;
        length = 4;
        mid = 2;
    }
    public Mysterion(int[] newArr) {
        array = new int[newArr.length];
        array = newArr;
        length = array.length - 1;
        mid = (int) (length / 2);
    }
    /**
     * Swap the two numbers at the given indices within the array
     * @param firstIndex    the index of the first chosen number
     * @param secondIndex   the index of the second chosen number
     * @param intArr        the array of numbers. Must be ints
     */
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
    /**
    * To be honest, I really can't figure out what it is 
    *supposed to do. This is really weird.
    * I did figure out that a is the starting position, b is the length,
    *and c is the middle of the array.
    *@param a       is the starting position of the algo
    *@param b       is the length of the array
    @param c        is the middle index of the array
    *@param arr     is the array to be converted to something
    */
    public int[] MysterionF(int a, int b, int c, int[] arr) {
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
    public String toString() {
        String ans = "[ ";
        for (int j = 0; j < this.array.length; j++) {
            ans += this.array[j] + " ";
        }
        ans += "]";
        return ans;
    }
    public static void main(String[] args) {
        Mysterion myst = new Mysterion();
        int[] test = {1,2,3,4,5,6,7,8,9,10};
        int[] test1 = {1,6,9,2,7,0,-2,1,6,9,3,2};
        int[] test2 = {4,7,0,11,12,5,9,1,3};
        int[] test3 = {1,1,2,3,5,8,13,21};
        Mysterion terry = new Mysterion(test);
        Mysterion tester1 = new Mysterion(test1);
        Mysterion tester2 = new Mysterion(test2);
        Mysterion tester3 = new Mysterion(test3);
        System.out.println("This is myst's original array:\n");
        System.out.println(myst);
        System.out.println("\n============================\n");
        System.out.println("This is changed");
        myst.MysterionF(0, 4, 2, myst.array);
        System.out.println(myst);
        System.out.println("\nThis is terry's original array: \n");
        System.out.println(terry);
        System.out.println("\n=============================\n");
        System.out.println("This is the changed version:");
        terry.MysterionF(1, 9, 5, terry.array);
        System.out.println(terry);
        System.out.println("\nThis is tester1's original array:\n");
        System.out.println(tester1);
        System.out.println("\n=============================\n");
        System.out.println("This is the changed version:");
        tester1.MysterionF(4, 9, 5, tester1.array);
        System.out.println(tester1);
        System.out.println("\nThis is tester2's original array:\n");
        System.out.println(tester2);
        System.out.println("\n=============================\n");
        System.out.println("This is the changed version:");
        tester2.MysterionF(1, 8, 1, tester2.array);
        System.out.println(tester2);
        System.out.println("\nThis is tester3's original array:\n");
        System.out.println(tester3);
        System.out.println("\n=============================\n");
        System.out.println("This is the changed version:");
        tester3.MysterionF(5, 2, 3, tester3.array);
        System.out.println(tester3);
    }
}