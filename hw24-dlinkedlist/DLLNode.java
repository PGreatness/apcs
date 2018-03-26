/*****************************************************
 * class DLLNode
 * Implements a doubly-linked node,
 * for use in lists and other collection classes.
 * Stores data of type String
 *****************************************************/

public class DLLNode 
{
  private String _cargo;    //cargo may only be of type String
  private DLLNode _nextNode, _prevNode; //pointers to next, prev DLLNodes

  public DLLNode( String stuff, DLLNode next, DLLNode prev) {
    _cargo = stuff;
    _nextNode = next;
    _prevNode = prev;
  }

  //~~~~~~~~~~~~~~~~~~~~~~~~VV ACCESSORS VV~~~~~~~~~~~~~~~~~~~~~~~~~~
  public String getCargo() {
    return _cargo;
  }
  public DLLNode getNext() {
    return _nextNode;
  }
  public DLLNode getPrev() {
    return _prevNode;
  }
  //~~~~~~~~~~~~~~~~~~~~~~VV MUTATORS VV~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public String setCargo(String cargo) {
    String foo = this.getCargo();
    this._cargo = cargo;
    return foo;
  }
  public DLLNode setNext(DLLNode nextNode) {
    DLLNode boo = this.getNext();
    this._nextNode = nextNode;
    return boo;
  }
  public DLLNode setPrev(DLLNode prevNode) {
    DLLNode soo = this.getPrev();
    this._prevNode = prevNode;
    return soo;
  }

  //Overwritten ToString()
  public String ToString() {
    return _cargo.toString();
  }

}//end class DLLNode
