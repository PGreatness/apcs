/*****************************************************
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 *****************************************************/

public class LList implements List //your List interface must be in same dir
{ 

    //instance vars
	private DLLNode _head;
	private DLLNode _tail;
    private int _size;

    // constructor -- initializes instance vars
    public LList( )
    {
	_head = null; //at birth, a list has no elements
	_tail = null;
	_size = 0;
    }

 
    //--------------v  List interface methods  v--------------
    
    public boolean add( String newVal )
    {
	DLLNode tmp = new DLLNode( newVal, _head, _tail );
	_tail = _head;
	_head = tmp;
	_size++;
	return true;
    }

    
    public String get( int index )
    {
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	String retVal;
	DLLNode tmp = _head; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//check target node's cargo hold
	retVal = tmp.getCargo();
	return retVal;
    }


    public String set( int index, String newVal )
    {

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	DLLNode tmp = _head; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//store target node's cargo
	String oldVal = tmp.getCargo();

	//modify target node's cargo
	tmp.setCargo( newVal );

	return oldVal;
    }

	public boolean add(int index, String newVal) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		DLLNode tmp = _head;
		for (int i = 1; i < index; i++) {
			tmp = tmp.getNext();
		}
		DLLNode newNode = new DLLNode(newVal, _head, _tail);
		newNode.setNext(tmp.getNext());
		tmp.setNext(newNode);
		newNode.setPrev(tmp);
		newNode.getNext().setPrev(newNode);
		_size++;
		return true;
	}

	public boolean remove(int index) {
		System.out.println(_size);
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		DLLNode tmp = _head;
		for (int i = 1; i < index; i++) {
			tmp = tmp.getNext();
		}
		tmp.getNext().getNext().setPrev(tmp.getPrev().getPrev());
		tmp.setNext(tmp.getNext());
		_size--;
		return true;
	}

    //return number of nodes in list
    public int size() { return _size; }
    
    //--------------^  List interface methods  ^--------------


    // override inherited toString
    public String toString()
    {
	String retStr = "HEAD->";
	DLLNode tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }


    //main method for testing
    public static void main( String[] args )
    {
	LList james = new LList();

	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("beat");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("a");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("need");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("I");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	System.out.println( "2nd item is: " + james.get(1) );

	james.set( 1, "got" );
	System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

	System.out.println( james );
    }

}//end class LList


