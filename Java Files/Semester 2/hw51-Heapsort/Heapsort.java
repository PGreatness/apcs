import java.util.ArrayList;
import java.util.Scanner;

public class Heapsort {
    private ALHeapMax heap;

    public Heapsort() {
        heap = new ALHeapMax();
    }

    public ArrayList<Integer> sort(ArrayList<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            heap.add(numbers.get(i));
        }
        System.out.println(heap);
        ArrayList<Integer> retArr = new ArrayList<Integer>();
        while (heap.peekMax() != null) {
           // System.out.println("The current max is: " + heap.peekMax());
            retArr.add(heap.removeMax());
            //System.out.println("The next max is: " + heap.peekMax());
        }
        return retArr;
    }
    public String toString() {
        return heap.toString();
    }

    public static void main(String[] args) {
        Heapsort hs = new Heapsort();
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(7);
        al.add(1);
        al.add(5);
        al.add(12);
        al.add(3);
        /*while (sc.hasNext()) {
            try {
                al.add(sc.nextInt());
            }catch(Exception e) {
                System.err.println("Error is: " + e);
            }
        }*/
        System.out.println(hs.sort(al));
    }
}