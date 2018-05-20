//Team QueuedUp (Roster: Ahnaf Hasan, Kevin Wang, Ying Xin Jiang)
//APCS2 pd08
//HW49 -- Sink || Swim
//2018-05-15

/*****************************************************
 * class ALHeap
 * Implements a min heap using an ArrayList as underlying container
 *****************************************************/

import java.util.ArrayList;

public class ALHeap
{

  //instance vars
  private ArrayList<Integer> _heap;

  /*****************************************************
   * default constructor  ---  inits empty heap
   *****************************************************/
  public ALHeap()
  {
    _heap = new ArrayList<Integer>();
  }//end contructor



  /*****************************************************
   * toString()  ---  overrides inherited method
   * Returns either
   * a) a level-order traversal of the tree (simple version)
   * b) ASCII representation of the tree (more complicated, more fun)
   *****************************************************/
  public String toString()
  {
    String retStr = "";
    for (int i = 0; i < _heap.size(); i++) {
      retStr += _heap.get(i) + " "; //heap has been conditioned to be level order
    }
    return retStr;
  }//O(n)

  /*****************************************************
   * boolean isEmpty()
   * Returns true if no meaningful elements in heap, false otherwise
   *****************************************************/
  public boolean isEmpty()
  {
    return _heap.size() == 0;
  }//O(1)


  /*****************************************************
   * Integer peekMin()
   * Returns min value in heap
   * Postcondition: Heap remains unchanged.
   *****************************************************/
  public Integer peekMin()
  {
    if (isEmpty()) { //heap doesn't exist
      return null;
    }
    int min = Integer.MAX_VALUE; //anything would be smaller than this (almost)
    for (int i = 0; i < _heap.size(); i++) {
      min = minOf(min, _heap.get(i)); //update min with the minimum of heap
    }
    return min;
  }//O(n)


  /*****************************************************
   * add(Integer)
   * Inserts an element in the heap
   * Postcondition: Tree exhibits heap property.
   *****************************************************/
  public void add( Integer addVal )
  {
   _heap.add(addVal); //conditioning allows normal adding
  }//O(1)


  /*****************************************************
   * removeMin()  ---  means of removing an element from heap
   * Removes and returns least element in heap.
   * Postcondition: Tree maintains heap property.
   *****************************************************/
  public Integer removeMin()
  {
    if (isEmpty()) { //heap doesn't exist
      return null;
    }
    int min = peekMin(); //return val
    int minPos = 0;
    for (int i = 0; i < _heap.size(); i++) { //find position of min
      if (_heap.get(i).equals(min)) {
        minPos = i;
        break;
      }
    }
    int minChild = minChildPos(minPos); //position of the min child of posiiton
    if (minChild + 1 == 0) { //child doesn't exist
      _heap.remove(minPos); //normal remove
    }else{
      swap(minPos, minChild); //swap the two to keep tree property
      _heap.remove(minChild); //remove the small
    }
    return min; //return val
  }//O(n)


  /*****************************************************
   * minChildPos(int)  ---  helper fxn for removeMin()
   * Returns index of least child, or
   * -1 if no children, or if input pos is not in ArrayList
   * Postcondition: Tree unchanged
   *****************************************************/
  private int minChildPos( int pos )
  {
    if (pos < 0 || pos >= _heap.size()) { //invalid pos
      return -1;
    }
    int leftChild = (2 * pos) + 1; //2p + 1
    int rightChild = leftChild + 1; //2p + 2
    if (leftChild > _heap.size() - 1 && rightChild > _heap.size() - 1) { //child doesn't exist
      return -1;
    }
    if (rightChild > _heap.size() - 1) { //right child doesn't exist
      return leftChild;
    }
    if (minOf(_heap.get(leftChild), _heap.get(rightChild)).equals(_heap.get(leftChild))) { //left child is smaller
      return leftChild;
    }else{ //right child is smaller
      return rightChild;
    }
  }//O(1)


  //************ aux helper fxns ***************
  private Integer minOf( Integer a, Integer b )
  {
    if ( a.compareTo(b) < 0 )
	    return a;
    else
	    return b;
  }

  //swap for an ArrayList
  private void swap( int pos1, int pos2 )
  {
    _heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );
  }
  //********************************************



  //main method for testing
  public static void main( String[] args )
  {
      ALHeap pile = new ALHeap();
      pile.add(2);
      System.out.println(pile);
      pile.add(4);
      System.out.println(pile);
      pile.add(6);
      System.out.println(pile);
      pile.add(8);
      System.out.println(pile);
      pile.add(10);
      System.out.println(pile);      
      pile.add(1);
      System.out.println(pile);
      pile.add(3);
      System.out.println(pile);
      pile.add(5);
      System.out.println(pile);
      pile.add(7);
      System.out.println(pile);
      pile.add(9);
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class ALHeap
