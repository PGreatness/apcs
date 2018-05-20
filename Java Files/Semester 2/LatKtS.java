//Ahnaf Hasan
//APCS2 pd08
//HW31 --Stack: What Is It Good For?
//2018-4-10

/*****************************************************
 * skeleton for class LatKtS
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 *****************************************************/


public class LatKtS
{

  /**********************************************************
   * precondition:  input string has length > 0
   * postcondition: returns reversed string s
   *                flip("desserts") -> "stressed"
   **********************************************************/
  public static String flip( String s )
  {
    Latkes js = new Latkes(s.length());
    for (int i = 1; i <= s.length(); i++) {
      js.push(s.substring(i - 1, i));
    }
    String retStr = "";
    for (int j = s.length(); j > 0; j--) {
      retStr += js.pop();
    }
    return retStr;
  }//end flip()


  /**********************************************************
   * precondition:  s contains only the characters {,},(,),[,]
   * postcondition: allMatched( "({}[()])" )    -> true
   *                allMatched( "([)]" )        -> false
   *                allMatched( "" )            -> true
   **********************************************************/

   //Couldn't get this to work
  public static boolean allMatched( String s )
  {
    Latkes qs = new Latkes(s.length());
    for (int i = 0; i < s.length(); i++) {
      String first = s.substring(i, i + 1);
      if (first.equals("(") || first.equals("{") || first.equals("[")) {
        qs.push(first);
      }else{
        if (qs.isEmpty()) {
          return false;
        }else{
          String popped = qs.pop();
          if (!(first.equals("(") && popped.equals(")"))) {
            return false;
          }
          if (!(first.equals("{") && popped.equals("}"))) {
            return false;
          }
          if (!(first.equals("[") && popped.equals("]"))) {
            return false;
          }
        }
      }
    }
    return qs.isEmpty();
  }//end allMatched()


  //main method to test
  public static void main( String[] args )
  {
    System.out.println(flip("stressed"));
    System.out.println(allMatched( "({}[()])" )); //true
    System.out.println(allMatched( "([)]" ) ); //false
    System.out.println(allMatched( "(){([])}" ) ); //true
    System.out.println(allMatched( "](){([])}" ) ); //false
    System.out.println(allMatched( "(){([])}(" ) ); //false
    System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v    
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }

}//end class LatKtS
