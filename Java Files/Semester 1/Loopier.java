public class Loopier {
   public static int counterL = 0;
   public static int counterF = 0;
   public static int count = 0;
   public static int[] ranNums(int num) {
      int[] a = new int[num];
      while (num > 0) {
         a[num - 1] = (int) (100 * Math.random());
         num -= 1;
      }
      return a;
   }
   public static String ranStr(int f) {
      String str = "";
      int [] a = new int[f];
      while (f > 0) {
         a[f - 1] = (int) (100 * Math.random());
         str += a[f - 1] + "\t";        
         f-= 1;

      }
      return str;
   }
   public static int linSearch (int [] a, int target) {
      for (int i = 0; i < a.length; i++) {
         if (a[i] == target) {
            return i;
         }
      }
      return -1;
   }
   public static int linSearchR (int [] a, int target) {
      if (a.length > counterL) {
         if (a[a.length - 1] == target) {
            return counterL;
         }else{
            counterL += 1;
            int[] array = new int[a.length - 1];
            for (int x = 0; x < a.length - 1; x++) {
               array[x] = a[x];
            }
            linSearchR(array, target);
         }
      }
      if (count == 0) {
         return -1;
      }else{
         return count;
      }
   }
   public static int freq (int [] a, int target) {
      int counter = 0;
      for (int i = 0; i < a.length; i++) {
         if (a[i] == target) {
            counter += 1;
         }
      }
      return counter;
   }
   public static int freqRec (int [] a, int target) {
      if (a.length > 0) {
         if (a[a.length - 1] == target) {
            count += 1;
         }else{
            counterF += 1;
            int[] array = new int[a.length - 1];
            for (int x = 0; x < a.length - 1; x++) {
               array[x] = a[x];
            }
            freqRec(array, target);
         }
      }
      return count;
   }
   public static String printArray(int[] a) {
      for (int i = 0; i<a.length; i++) { 
         System.out.println(a[i]);
      } 
      return "";
   }
   public static void main(String [] args) {
      //System.out.println(printArray(ranNums(5)));
      //System.out.println(ranStr(8));
      //System.out.println(linSearch(ranNums(6), 100));
      int[] array = {1, 2, 3, 4, 5};
      System.out.println(freqRec(array, 1));
    //  System.out.println(linSearchR(array, 3));
  //    System.out.println(linSearchR(array, 2)); //doesn't work because static

   }
}
