/***************************
 * interface List
 * Declares methods that will be implemented by any
 *  class wishing to adhere to this specification.
 * This interface specifies behaviors of a list of ints.
 ***************************/

public interface List
{
  // Return number of elements in the list
  int size();

  // Append an int to the end. Return true.
  boolean add( Object obj);

  // Insert an Object at index
  void add( int index, Object obj ); 

  // Retrieve the int at index
  int get( int index );

  // Overwrite the int at index
  int set( int index, Object obj );

  // Remove the int at index,
  // shifting any elements after it to the left.
  // Return removed value.
  int remove( int index );

}//end interface ListInt
