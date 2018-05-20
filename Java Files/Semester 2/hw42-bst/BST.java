//Ahnaf Hasan
//APCS2 pd08
//HW#42 -- Algorithms as Data Structure
//2018-04-30
/*****************************************************
 * class BST - v1:partial
 * SKELETON
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT)
 *
 * A BST maintains the invariant that, for any node N with value V,
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value,
 *  and any value in its right subtree must be greater.)
 * This BST only holds ints (its nodes have int cargo)
 *****************************************************/

public class BST
{

  //instance variables / attributes of a BST:
  TreeNode _root;

  /*****************************************************
   * default constructor
   *****************************************************/
  public BST( )
  {
    _root = null;
  }


  /*****************************************************
   * void insert( int )
   * Adds a new data element to tree.
   *****************************************************/
  public void insert( int newVal )
  {
    TreeNode newNode = new TreeNode( newVal );
    if (_root == null) {
      _root = newNode;
    }else{
      insert(_root, newNode);
    }
  }
  //recursive helper for insert(int)
  public void insert( TreeNode stRoot, TreeNode newNode )
  {
    TreeNode tmp = stRoot;
    if (tmp.getLeft() != null && tmp.getRight() != null) {
      if (tmp.getValue() < newNode.getValue()) {
        insert(tmp.getRight(), newNode);
      }else{
        insert(tmp.getLeft(), newNode);
      }
    }else{
      if (tmp.getLeft() == null) {
        tmp.setLeft(newNode);
      }else{
        tmp.setRight(newNode);
      }
    }
  }//end insert()


  

  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

  // each traversal should simply print to standard out
  // the nodes visited, in order

  //process root, recurse left, recurse right
  public void preOrderTrav()
  {
    preOrderTrav( _root );
  }
  public void preOrderTrav( TreeNode currNode )
  {
    if (currNode == null) {
      return;
    }
    TreeNode leftTmp = currNode;
    TreeNode rightTmp = currNode;
    System.out.print(currNode.getValue());
    preOrderTrav(leftTmp.getLeft());
    preOrderTrav(rightTmp.getRight());
  }

  //recurse left, process root, recurse right
  public void inOrderTrav()
  {
    inOrderTrav(_root);
  }
  //For some reason, the last two elements are swapped
  //Tracing it seems to work correctly but on the computer
  //it doesn't. Will hopefully solve this with my partner
  public void inOrderTrav( TreeNode currNode )
  {
    if (currNode == null) {
      return;
    }
    TreeNode leftTmp = currNode;
    TreeNode rightTmp = currNode;
    inOrderTrav(leftTmp.getLeft());
    System.out.print(currNode.getValue());
    inOrderTrav(rightTmp.getRight());
  }

  //recurse left, recurse right, process root
  public void postOrderTrav()
  {
    postOrderTrav(_root);
  }
  public void postOrderTrav( TreeNode currNode )
  {
    if (currNode == null) {
      return;
    }
    TreeNode leftTmp = currNode;
    TreeNode rightTmp = currNode;
    postOrderTrav(leftTmp.getLeft());
    postOrderTrav(rightTmp.getRight());
    System.out.print(currNode.getValue());
  }

  //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  //main method for testing
  public static void main( String[] args )
  {

      BST arbol = new BST();

      //PROTIP: sketch state of tree after each insertion
      //        ...BEFORE executing these.
      arbol.insert( 4 );
      arbol.insert( 2 );
      arbol.insert( 5 );
      arbol.insert( 6 );
      arbol.insert( 1 );
      arbol.insert( 3 );
      arbol.insert( 0 );

      System.out.println( "\n-----------------------------");
      System.out.println( "pre-order traversal:" );
      arbol.preOrderTrav();

      System.out.println("\n-----------------------------");
      System.out.println( "in-order traversal:" );
      arbol.inOrderTrav();

      System.out.println( "\n-----------------------------");
      System.out.println( "post-order traversal:" );
      arbol.postOrderTrav();

      System.out.println( "\n-----------------------------");
    /*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~      
      
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }

}//end class