import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue<String> {
    ArrayList<String> queue;

    public ArrayPriorityQueue() {
        queue = new ArrayList<String>();
    }

    /**
     * Adds to the correct index the given value
     * @param x the String to be added
     */
    public void add(String x) { // O(n) at worst, O(1) at best
        if (queue.size() == 0) {
            queue.add(x);
        }else{
            for (int i = 0; i < queue.size(); i++) {
                if (x.compareTo(queue.get(i)) > 0) {
                    queue.add(i, x);
                    return;
                }
            }
            queue.add(queue.size(), x);
        }
    }
    /**
     * Returns true if the queue is empty, false otherwise
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() { //O(1)
        return queue.size() == 0;
    }
    /**
     * Return without removing the last element of the queue
     * @return {@code null} if empty, else {@code String} at the end of the queue
     */
    public String peekMin() { // O(1)
        if (isEmpty()) {
            return null;
        }
        return queue.get(queue.size() - 1);
    }
    /**
     * Removes the last element of the queue
     * @return the value removed
     */
    public String removeMin() { // O(1)
        String remVal = peekMin();
        queue.remove(queue.size() - 1);
        return remVal;
    }

    public String toString() {
        String retStr = "";
        for (int i = 0; i < queue.size(); i++) {
            retStr += queue.get(i) + "   ";
        }
        return retStr;
    }
    public static void main(String[] args) {
        ArrayPriorityQueue test = new ArrayPriorityQueue();
        test.add("123");
        test.add("122");
        test.add("x");
        test.add("c");
        test.add("z");
        test.add("A");
        test.add("a");
        test.add("zz");
        System.out.println(test + "\nHere's the min: " + test.peekMin());
        System.out.println(test.removeMin() + "\n" + test);
        System.out.println("New min val: " + test.peekMin());
    }
}