//Team Name (Roster: Soojin Choi, Ahnaf Hasan)
//APCS2 pd08
//HW36 --  Now Let’s Consider You Lot at Fake Terry’s
//2018-4-17

/*****************************************************
 * class RQueue
 * A linked-list-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite direction for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 ******************************************************/


public class RQueue<T> implements Queue<T>
{
  //instance variables
  private LLNode<T> _front, _end;
  private int _size;


  // default constructor creates an empty queue
  public RQueue()
	{
    _front = null;  //In the beginning, there was nothing...
    _end = null;
    _size = 0;
	}//end default constructor

  /**
   * Adds the given parameter to the end of the Queue.
   * Increments size.
   * @param enQVal a value of type T
   */
  public void enqueue( T enQVal )
  {
    LLNode<T> tmp = new LLNode<T>(enQVal, _front);
    if (isEmpty()) { //check if this is the first elem of queue
      _front = tmp;
      _end = tmp;
      tmp.setNext(tmp); //self loop to set precedent for looping, probably bad
    }else{ //if there are elems already in a queue
      _end.setNext(tmp); //the last elem is made second-to-last
      _end = _end.getNext(); //end shifts over 1 node
    }
    _size++; //increment size
  }//end enqueue()


  // remove and return thing at front of queue
  // assume _queue ! empty
  /**
   * Remove the first elem from the queue. If queue is empty,
   * return null, else the value of the removed elem. Decrements
   * size.
   * @return null if queue is empty or the value of the removed element
   */
  public T dequeue()
  {
    if (isEmpty()) {
      return null;
    }

    sample();//finds a random new front value.

    LLNode<T> tmp = _front; //tmp to remove reference
    if (_front == _end){ // case when there is only one element left.
      _front = null; //both front and end become null.
      _end = _front;
    }
    else{
      _end.setNext(_front.getNext()); //skip over the element to be removed
      //_end = _front.getNext(); //the end must stay immediately behind the front
      //_front = _front.getNext().getNext(); //move front ahead of end
      _front = _end.getNext();
      tmp.setNext(null); //remove reference to the rest of the queue
    }
    _size--; //decrement size
    return tmp.getValue();
  }//end dequeue()

  /**
  *Returns the value of reference pointer _front
  * @return value of _front
  */
  public T peekFront()
  {
    return _front.getValue();
  }

  /******************************************
   * void sample() -- a means of "shuffling" the queue
   * Algo:
   * <ol><li> Randomly generate a number (range of size + 1)
   * <li> Move front by using getNext(). Do the same for
   * end
   * <li> front is now in another location than previous
   * without the order being harmed at all
   *
   ******************************************/
  public void sample ()
  {
    int random = (int)(Math.random() * _size + 1);
    for (int i = 0; i < random; i++) {
      _front = _front.getNext();
      _end = _end.getNext();
    }
  }//end sample()

  /**
   * Returns true if the queue is empty of meaningful
   * items.
   * @return true if empty, false otherwise
   */
  public boolean isEmpty()
  {
    return _size == 0;
  } //O(?)


  // print each node, separated by spaces
  /*
  public String toString()
  {
    String ans = "FRONT -->";
    LLNode tmp = _end;
    ans += tmp.getValue() + "-->";
    tmp = tmp.getNext();
    while (tmp != _end && tmp != null) {
      ans += tmp.getValue() + "-->";
      tmp = tmp.getNext();
    }
    return ans + "END";
  }*///end toString()
  public String toString()
  {
    String ans = "FRONT -->";
    LLNode tmp = _front;
    if (tmp == null){
      ans += "Null -->";
    }
    else{
      ans += tmp.getValue() + "-->";
      tmp = tmp.getNext();
      while (tmp != _end.getNext() && tmp != null) {
        ans += tmp.getValue() + "-->";
        tmp = tmp.getNext();
      }
    }
    return ans + "END";
  }


  //main method for testing
  public static void main( String[] args )
  {

      Queue<String> PirateQueue = new RQueue<String>();

      System.out.println("\nnow enqueuing...");
      PirateQueue.enqueue("Dread");
      PirateQueue.enqueue("Pirate");
      PirateQueue.enqueue("Robert");
      PirateQueue.enqueue("Blackbeard");
      PirateQueue.enqueue("Peter");
      PirateQueue.enqueue("Stuyvesant");

      System.out.println("\nnow testing toString()...");
      System.out.println( PirateQueue ); //for testing toString()...
      System.out.println(PirateQueue.peekFront());

      System.out.println("\nnow dequeuing...");
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue ); //Still prints Blackbeard, idk how to fix
      //EDIT: Soojin fixed it, bless her soul

      System.out.println("\nnow dequeuing fr empty queue...");
      System.out.println( PirateQueue.dequeue() );
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main

}//end class RQueue
