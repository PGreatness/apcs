//Ahnaf Hasan (with help from Team Flying Donkeys)
//APCS pd01
//HW17 -- Do I repeat myself?
//2017-10-16
public class Repeater 
{
    public static void fenceW(int numPosts) //WHILE loop has a statement for
    //when the numPosts isn't 0 to get the inital post
    {
	if (numPosts != 0) { //occurs only once since WHILE doesn't include it
	    System.out.print("|");
	}
	while (numPosts > 1) { //repeats til reaches 1
	    System.out.print("--|");
	    numPosts -= 1;
	}
	System.out.println(""); //final statement
    }
    
    public static void fenceR(int numPosts) //recursive statement for fencing
    { //has technically two base cases: 0 and 1
	if (numPosts == 0) { //case where the post num is 0, disregard
	    //everything else
	    System.out.println("");
	}else{
	    if (numPosts == 1) { //case where post num is 1, disregard the else
		System.out.println("|");
	    }else{//neither 0 or 1. print this out and then repeat fenceR with
		//one less post
		System.out.print("|--");
		fenceR(numPosts - 1);
	    }
	}
    }
    public static void main(String [] args) //test fenceR and fenceW
    {
	fenceR(0);
	fenceR(1);
	fenceR(2);
	fenceR(3);
	fenceW(0);
	fenceW(1);
	fenceW(2);
	fenceW(3);
	
    }//end main();

}//end Repeater.java
