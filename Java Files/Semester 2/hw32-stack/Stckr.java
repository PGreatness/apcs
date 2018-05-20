//Ahnaf Hasan
//APCS2 pd08
//HW32 -- Leon Leonwood Stack
//2018-4-11

/*****************************************************
 * class Stckr
 * driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
 *****************************************************/

public class Stckr
{
    public static void main( String[] args )
    {
    /**
     * If you plan on changing the type for cakes, please
     * change the randomizers for push and pop. Otherwise, you
     * might get a ClassCastException or it won't turn out to
     * be what you wanted. :/
     */
	//Stack<Integer> cakes = new ALStack<Integer>();
	Stack<Integer> cakes = new LLStack<Integer>();

    System.out.println("Initialization of cakes: " + cakes);
    System.out.println("Adding random elements, please wait...");
    int a = 0;
    while (a < 20) {
        cakes.push((int)(Math.random() * 100));
        if (a % 10 == 0) {
            System.out.println("LOADING...");
        }
        a++;
    }
    System.out.println("Cakes after random inserts: " + cakes);
    System.out.println("The size of the cake is:" + a + "(it's a lie!)"); //Portal
    System.out.println("Removing some elements, please wait...");
    int b = 0;
    while (b < ((int)(Math.random() * 19 + 1))) { //random amount of elements removed
                                                  //to keep up replayablity
        cakes.pop();
        if (b % 10 == 0) {
            System.out.println("LOADING...");//Loading screen
        }
        b++;
    }
    System.out.println("Goodbye random elements! Here is you anew: " + cakes);
    System.out.println("In essence, a total of " + b + " elements were removed");
    System.out.println("I hope you remembered the first element, because I will guess it right now!");
    System.out.println("*drumroll**drumroll**drumroll*");
    //Delay to make peek( ) look cool
    try {
        Thread.sleep(5000);
    }
    catch (InterruptedException e) { }
    System.out.println("Is this your number?!: " + cakes.peek() + "\nMagic! :3");
    //Unresponsive users, this is for you
    try {
        Thread.sleep(1000);
    }
    catch (InterruptedException e) { }
    System.out.println(".");
    try {
        Thread.sleep(1000);
    }
    catch (InterruptedException e) { }
    System.out.println(".");
    try {
        Thread.sleep(1000);
    }
    catch (InterruptedException e) { }
    System.out.println(".");
    try {
        Thread.sleep(500);
    }
    catch (InterruptedException e) { }
    System.out.println("I'm probably right, moving on!");
    System.out.println("\nQUICK QUIZ\nIs this empty then?\nA: " + cakes.isEmpty());
	
    }//end main

}//end class

