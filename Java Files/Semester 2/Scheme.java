//Ahnaf Hasan
//APCS2 pd08
//HW33 -- What a Racket
//2018-4-12

/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 * 
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. Steal underpants.
 *   2. Go backwards through the String given pushing every 
 * number into a stack. 
 *   3. If you hit a operator, perform that operation on
 * the stack.
 *   4. If you hit a closed parens, do a recursive call that
 * would keep going until the next open parens.
 *   5. Add them all up and profit!
 *
 * STACK OF CHOICE: String by String
 * b/c 
 * Strings can be returned and easy enough to parse an
 * Integer out of if necessary. Also, they allow the storage
 * of the operators as well.
 ******************************************************/
import java.util.Stack;
public class Scheme
{
  /****************************************************** 
   * precond:  Assumes expr is a valid Scheme (prefix) expression,
   *           with whitespace separating all operators, parens, and 
   *           integer operands.
   * postcond: Returns the simplified value of the expression, as a String
   * eg,
   *           evaluate( "( + 4 3 )" ) -> 7
   *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
   ******************************************************/
  //This fails on the second test. The idea was to do the evaluations in the stack
  //itself but it didn't work out the way I was thinking. I tried a lot of other ways
  //but they all failed, mainly because I wasn't sure how to do this part recursively.
  public static String evaluate( String expr ) 
  {
    Stack<String> stack = new Stack<String>();
    String[] xArr = expr.split("\\s+");
    for (int i = xArr.length - 1; i > -1; i--) {
      if (isNumber(xArr[i])) {
        stack.push(xArr[i]);
      }
      if (xArr[i].equals("+")) {
        stack.push((Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop())) + "");
      }
    }
    return stack.pop();
  }//end evaluate()


  /****************************************************** 
   * precond:  Assumes top of input stack is a number.
   * postcond: Performs op on nums until closing paren is seen thru peek().
   *           Returns the result of operating on sequence of operands.
   *           Ops: + is 1, - is 2, * is 3
   ******************************************************/
  public static String unload( int op, Stack<String> numbers ) 
  {
    int sum = 0;
    if (op == 1) {
      while (!(numbers.isEmpty())) {
        sum = sum + Integer.parseInt(numbers.pop());
      }
    }
    if (op == 2) {
      while (!(numbers.isEmpty())) {
        sum = sum - Integer.parseInt(numbers.pop());
      }
    }
    if (op == 3) {
      while (!(numbers.isEmpty())) {
        sum = sum * Integer.parseInt(numbers.pop());
      }
    }
    return sum + "";
  }//end unload()


  
  //optional check-to-see-if-its-a-number helper fxn:
  public static boolean isNumber( String s ) {
  try {
  Integer.parseInt(s);
  return true;
	}
  catch( NumberFormatException e ) {
  return false;
	}
  }
  


  //main method for testing
  public static void main( String[] args )
  {

      String zoo1 = "( + 4 3 )";
      System.out.println(zoo1);
      System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
      //...7

      String zoo2 = "( + 4 ( * 2 5 ) 3 )";
      System.out.println(zoo2);
      System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
      //...17
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v

      String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
      System.out.println(zoo3);
      System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
      //...29

      String zoo4 = "( - 1 2 3 )";
      System.out.println(zoo4);
      System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
      //...-4
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }//main

}//end class Scheme
