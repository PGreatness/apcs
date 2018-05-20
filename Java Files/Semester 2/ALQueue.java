//Team ...WW? -- Ying Xin Jiang, Ahnaf Hasan
//APCS2 pd8
//HW35 -- ...Nor Do Aussies
//2018-04-17

import java.util.ArrayList;

public class ALQueue<T> implements Queue<T>{

    private int size;
    private int index;
    private ArrayList<T> line;
    
    //Default constructor
    public ALQueue() {
        size = 0;
        index = 0;
        line = new ArrayList<T>();
    }

    /**
     * Dequeue decrements size and returns the value
     * of the current index. The index is then incremented
     * thanks to postfix notation.
     * @return T, where T is a generic typed variable
     */
    public T dequeue() {
	    size--;
	    return line.get(index++);
    }
    /**
     * Size is incremented and the given value is added to
     * the end of the list. Concerns of expansion can be 
     * avoided since ArrayList's add(E e) already takes care
     * of that.
     * @param x a generic typed variable
     */
    public void enqueue( T x ) {
        size++;
        line.add(x);
    }
    /**
     * Returns a boolean to indicate whether or not the 
     * list is empty
     * @return true if list empty, else false
     */
    public boolean isEmpty() {
	    return size == 0;
    }
    /**
     * Returns the front of the list without altering the
     * list in any way.
     * @return a generically typed variable
     */
    public T peekFront() {
	    return line.get(index);
    }


    public String toString() {
        String ans = "FRONT-->";
        for (int i = index; i < index + size; i++) {
            ans += line.get(i) + "-->";
        }
        return ans + "END";
    }

    public static void main (String [] args) {
        ALQueue<String> test = new ALQueue<String>();
        System.out.println(test.isEmpty()); //TRUE
        test.enqueue("person");
        test.enqueue("eats");
        test.enqueue("fish");
        System.out.println(test.isEmpty()); //FALSE
        System.out.println(test);
        System.out.println(test.dequeue()); //FISH
        System.out.println(test.dequeue()); //EATS
        System.out.println(test.dequeue()); //PERSON
        test.enqueue("no");
        test.enqueue("line");
        System.out.println(test.peekFront());
        System.out.println(test);

    }
    
}//end class
