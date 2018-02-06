//Ahnaf Hasan
//APCS1 pd01
//HW16 -- Get it While You Can
//2017-10-12

/***
  driver for class Coin
  ~~~ SUGGESTED WORKFLOW: ~~~
  1. Compile this file and run.
  2. Move the "TOP" line below the first statement. 
  (with cursor at beginning of TOP line, C-k C-k, DOWN, DOWN, C-y)
  3. Compile and run again. 
  4. Resolve errors 1 at a time until it works
  5. Repeat 2-4 until TOP meets BOTTOM
***/

public class Driver
{
  public static void main( String[] args )
  {

    //build Objects from blueprint specified by class Coin

    //test default constructor
      Coin mine = new Coin();

    //test 1st overloaded constructor
    Coin yours = new Coin( "quarter" );
 
    //test 2nd overloaded constructor
    Coin wayne = new Coin( "dollar", "heads" );

    //test toString() methods of each Coin
    System.out.println("mine: " + mine);
    System.out.println("yours: " + yours);
    System.out.println("wayne: " + wayne);

    //test flip() method
    System.out.println("\nAfter flipping...");
    yours.flip();
    wayne.flip();
    System.out.println("yours: " + yours);
    System.out.println("wayne: " + wayne);

    //test equals() method
    if ( yours.equals(wayne) ) {
	    System.out.println( "Matchee matchee!" );

    }else{
	    System.out.println( "No match. Firestarter you can not be." );
}
    //if the heads counter is less than chosen num (15), do the body section
    while (wayne.headsCtr < 16 && yours.headsCtr < 16) {
	wayne.flip();
	yours.flip();
	if (wayne.upFace == "heads") {
	    wayne.headsCtr += 1;
	    System.out.println("wayne: " + wayne.headsCtr);
	}
	if (yours.upFace == "heads") {
	    yours.headsCtr += 1;
	    System.out.println("yours: " + yours.headsCtr);
	}

    }
    //if the match counter is less than the chosen num (15), do the body
    while (wayne.ctrMatch < 16) {
	wayne.flip();
	yours.flip();
	System.out.println(wayne.ctrMatch);
	    if ( yours.equals(wayne) ) {
	    System.out.println( "Matchee matchee!" );
	    wayne.ctrMatch += 1;

    }else{
	    System.out.println( "No match. Firestarter you can not be." );
	    }
    }
    //wayne.ctrMatch won't get to 13000 by the other ways. however,put it on
    //a loop until it gets to 13000 and it will get there.
    while (wayne.ctrMatch < 13001) {
	wayne.flip();
	if (yours.equals(wayne)) {
	    wayne.ctrMatch += 1;
	}
    }
    //realized that a bang would make this all really easy. had to cheat to
    //get the remainder operator (%). sorry! (Or should i say, !sorry ...)
    while (!(wayne.ctrMatch >= 13000 && ((wayne.ctrMatch % 2000) == 0)))
 {
	wayne.flip();
      	System.out.println(wayne.ctrMatch);
	wayne.ctrMatch += 1;
	if ((wayne.ctrMatch % 2000) == 0) {
	    System.out.println("yay");
	}
    }
 /*===================TOP==========================

	    ====================BOTTOM======================*/

  }//end main()

}//end class
