//Ahnaf Hasan
//APCS2 pd08
//HW25 -- Generically Speaking...
//2018-3-26

/*****************************************************
 * class LList
 * Implements a linked list of DLLNodes, each containing String data
 *****************************************************/

public class LList<T> implements List<T> //your List interface must be in same dir
{ 

    //instance vars
    private DLLNode _head;
	private int _size;
	private DLLNode _tail;

    // constructor -- initializes instance vars
    public LList( )
    {
	_head = null; //at birth, a list has no elements
	_tail = null;
	_size = 0;
    }


    //--------------v  List interface methods  v--------------
    
    public boolean add( T newVal )
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


    public String set( int index, T newVal )
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

	//insert a node containing newVal at position index
	public void add(int index, T newVal) {
		DLLNode jeff = new DLLNode(newVal, null, null);
		DLLNode temp = _head;
		for (int i = 0; i < index; i++) {
			temp = temp.getNext();
		}
		jeff.setNext(temp.getNext());
		jeff.setPrev(temp.getPrev());
		temp.setNext(jeff);
		_size++;
	}

	//remove node at pos index, return its cargo
	public String remove(int index) {
		DLLNode temp = _head;
		for (int i = 0; i < index - 1; i++) { 
			temp = temp.getNext();
		}
		String cargo = temp.getNext().getCargo();
		temp.setNext(temp.getNext().getNext());
		_size--;
		return cargo;
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

	System.out.println("Now remove that beat!");
	james.remove(3);
	System.out.println(james);

	System.out.println("Now add a song!");
	james.add(2, "song");
	System.out.println(james);
    }

}//end class LList


