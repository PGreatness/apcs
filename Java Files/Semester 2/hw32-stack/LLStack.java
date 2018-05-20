//Ahnaf Hasan
//APCS2 pd08
//HW32 -- Leon Leonwood Stack
//2018-4-11

import java.util.LinkedList;
public class LLStack<T> implements Stack<T>
{
    private LinkedList<T> stack;
    private int stackSize;

    public LLStack() {
        stack = new LinkedList<T>();
        stackSize = 0;
    }
    public boolean isEmpty() {
        return stack.size() == 0;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return stack.get(stackSize - 1);
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
       T retr = stack.remove(stackSize - 1);
       stackSize--;
       return retr;
    }

    public void	push( T thing ) {
        stack.add(thing);
        stackSize++;
    }
    public String toString() {
        String elements = "[";
        for (int i = stackSize - 1; i>= 0; i--) {
            elements += stack.get(i) + " ";
        }
        return elements + "]";
    }
}