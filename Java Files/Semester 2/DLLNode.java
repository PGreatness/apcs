/*****************************************************
 * class DLLNode
 * Implements a doubly-linked node,
 * for use in lists and other collection classes.
 * Stores data of type String
 *****************************************************/

public class DLLNode<T>
{
  private T _cargo;    //cargo may only be of type String
  private DLLNode _nextNode, _prevNode; //pointers to next, prev DLLNodes

  public DLLNode(T value, DLLNode next, DLLNode prev) {
    _cargo = value;
    _nextNode = next;
    _prevNode = prev;
  }

  public String getCargo() {
    return _cargo.toString();
  }
  public DLLNode getNext() {
    return _nextNode;
  }
  public DLLNode getPrev() {
    return _prevNode;
  }

  public String setCargo(T newCargo) {
    String foo = getCargo();
    _cargo = newCargo;
    return foo;
  }
  public DLLNode setNext(DLLNode newNext) {
    DLLNode boo = getNext();
    _nextNode = newNext;
    return boo;
  }
  public DLLNode setPrev(DLLNode newPrev) {
    DLLNode soo = getPrev();
    _prevNode = newPrev;
    return soo;
  }

  public String toString() {
    return _cargo.toString();
  }
  public static void main(String arg[]) {
    
  }


}//end class DLLNode
