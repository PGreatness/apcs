//Ahnaf Hasan
//APCS2 pd08
//HW32 -- Leon Leonwood Stack
//2018-4-11

import java.util.ArrayList;
public class ALStack<T> implements Stack<T>
{
    private ArrayList<T> stack;
    private int stackSize;
    public ALStack() {
        stack = new ArrayList<T>();
        stackSize = 0;
    }
    public void push(T thing) {
        stack.add(thing);
        stackSize++;
    }
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T retr = stack.remove(stackSize - 1);
        stackSize--;
        return retr;
    }
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return stack.get(stackSize - 1);
    }
    public boolean isEmpty() {
        return stackSize == 0;
    }
    public String toString() {
        String elements = "[";
        for (int i = stackSize - 1; i >= 0; i--) {
            elements += stack.get(i) + " ";
        }
        return elements + "]";
    }
}