//Ahnaf Hasan
//APCS2 pd08
//HW43 -- BSTs is the Perfect Place for Shade
//2018-05-01

/*****************************************************
 * class BST - v1:partial
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
  BST( )
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

    if ( _root == null ) {
      _root = newNode;
      return;
    }
    insert( _root, newNode );
  }
  //recursive helper for insert(int)
  public void insert( TreeNode stRoot, TreeNode newNode )
  {
    if ( newNode.getValue() < stRoot.getValue() ) {
      //if no left child, make newNode the left child
      if ( stRoot.getLeft() == null )
        stRoot.setLeft( newNode );
      else //recurse down left subtree
        insert( stRoot.getLeft(), newNode );
      return;
    }
    else { // new val >= curr, so look down right subtree
      //if no right child, make newNode the right child
      if ( stRoot.getRight() == null )
        stRoot.setRight( newNode );
      else //recurse down right subtree
        insert( stRoot.getRight(), newNode );
      return;
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
    if ( currNode == null ) //stepped beyond leaf
      return;
    System.out.print( currNode.getValue() + " " );
    preOrderTrav( currNode.getLeft() );
    preOrderTrav( currNode.getRight());
  }

  //recurse left, process root, recurse right
  public void inOrderTrav()
  {
    inOrderTrav( _root );
  }
  public void inOrderTrav( TreeNode currNode )
  {
    if ( currNode == null ) //stepped beyond leaf
      return;
    inOrderTrav( currNode.getLeft() );
    System.out.print( currNode.getValue() + " " );
    inOrderTrav( currNode.getRight() );
  }

  //recurse left, recurse right, process root
  public void postOrderTrav()
  {
    postOrderTrav( _root );
  }
  public void postOrderTrav( TreeNode currNode )
  {
    if ( currNode == null ) //stepped beyond leaf
      return;
    postOrderTrav( currNode.getLeft() );
    postOrderTrav( currNode.getRight() );
    System.out.print( currNode.getValue() + " "  );
  }

  //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*****************************************************
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     *****************************************************/
    public TreeNode search( int target )
    {
      return search(target, _root);
    }
    //helper method to recurse
    private TreeNode search(int target, TreeNode node) {
      if (node == null) { //out-of-bounds
        return null;
      }
      if (node.getValue() == target) { //Found the target
        return node;
      }
      if (node.getValue() < target) { //Target is too big for this node
        return search(target, node.getRight());
      }else{
        return search(target, node.getLeft()); //but maybe not for this
      }
    }

    /*****************************************************
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 0
     *****************************************************/
    public int height()
    {
      return height(_root);
    }
    //helper method to recurse
    private int height(TreeNode node) {
      if (node == null) { //tree doesn't exist or reached end
        return -1;
      }
      int left = height(node.getLeft()); //left side is recursed
      int right = height(node.getRight()); //right side is recursed
      if (left > right) { //bigger side has more height so take bigger side
        return left + 1;
      }else{
        return right + 1;
      }
    }

    /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
    public int numLeaves()
    {
      return numLeaves(_root);
    }
    //helper method to recurse
    private int numLeaves(TreeNode node) {
      if (node == null) { //reached end
        return 0;
      }
      //node is a leaf
      if (node.getLeft() == null && node.getRight() == null) {
        return 1; //count tyself
      }
      int left = numLeaves(node.getLeft()); //recurse through left side
      int right = numLeaves(node.getRight()); //recurse through right side
      return left + right; //return the sum of both side's leaves
    }

    //Remove element from tree. Probably inefficient but works
    public int remove(int number) {
      TreeNode node = search(number); //actual node of number
      TreeNode parent = parent(node, _root); //parent node of number
      int oldVal; //to be returned
      //no child. node to be removed is a leaf
      if (node.getRight() == null && node.getLeft() == null) {
        if (parent.getLeft() == node) { //node is on parent's left
          oldVal = node.getValue(); //set val as node's val
          parent.setLeft(null); //parent sets left as null
          return oldVal; //val returned, node is removed
        }else{ //node is on right side
          oldVal = node.getValue(); //set val
          parent.setRight(null); //node stepped over
          return oldVal; //node removed
        }
      }
      //1 child, left side. node has child on left
      if (node.getRight() == null) {
        oldVal = node.getValue();
        if (parent.getLeft() == node) { //node is on parent's left
          parent.setLeft(node.getLeft()); //parent sets next as node's next
          return oldVal; //node removed
        }else{ //node is on parent's right
          parent.setRight(node.getLeft()); //parent sets next as node's next
          return oldVal; //node removed
        }
      }
      //1 child, right side. node has child on right
      if (node.getLeft() == null) {
        oldVal = node.getValue();
        if (parent.getLeft() == node) {
          parent.setLeft(node.getRight());
          return oldVal;
        }else{
          parent.setRight(node.getRight());
          return oldVal;
        }
      }
      //2 children
      TreeNode tmp = node.getRight(); //tmp is a new subtree on the right of node
      while (tmp.getLeft() != null) { //traverse to find lowest tmp
        tmp = tmp.getLeft();
      }
      oldVal = node.getValue(); //set val
      node.setValue(tmp.getValue()); //node gets val of lowest on the high side
      parent(tmp, node).setLeft(null); //parent node sets the left as null
      return oldVal; //node is removed
    }
    //helper to find the parent of a node
    private TreeNode parent(TreeNode node, TreeNode start) {
      if (start == null) { //stepped out of bounds
        return null;
      }
      if (start.getLeft() == node || start.getRight() == node) { //node is connected to start
        return start; //start must be a parent
      }
      if (start.getValue() < node.getValue()) { //node is bigger so traverse bigger side
        return parent(node, start.getRight());
      }else{ //node is smaller so traverse smaller side
        return parent(node, start.getLeft());
      }
    }
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

    System.out.println( "\n-----------------------------");
    System.out.println( "pre-order traversal:" );
    arbol.preOrderTrav();

    System.out.println( "\n-----------------------------");
    System.out.println( "in-order traversal:" );
    arbol.inOrderTrav();

    System.out.println( "\n-----------------------------");
    System.out.println( "post-order traversal:" );
    arbol.postOrderTrav();

    System.out.println( "\n-----------------------------");
     System.out.println(arbol.height()); //return 2
     System.out.println(arbol.search(6).getValue()); //return 6
     System.out.println(arbol.numLeaves()); //return 3
     System.out.println("\n" + arbol.remove(3)); //returns 3
     arbol.inOrderTrav(); //returns 1 2 4 5 6
    /*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~     
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }

}//end class