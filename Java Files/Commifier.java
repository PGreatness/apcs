//Ahnaf Hasan
//APCS pd01
//HW21 -- Karmacomma
//2017-10-23

public class Commifier {
    public static String commafyF(int num) {
	String numHolder = "" + num; //turns the int into a string
	String another = "";//will be the new int as a string and with commas(,)
	String orig ="" + num; //the original num as a string for quick
	//comparisons
	for (int x = numHolder.length(); x > 0; x -= 1) {//FOR loop
	    if ((numHolder.length() != 0) && (numHolder.length() % 3 == 0)
		&& (numHolder.length() != orig.length())) {//if numHolder isn't
		//the original num(a 6 digit num), isn't an empty string, and
		//is divisible by 3,...
		
		another += "," + numHolder.substring(0, 1);//add a comma and
		//the next num
		numHolder = numHolder.substring(1, numHolder.length());//cut off
		//that num and set numHolder as the num with one less num at the
		//beginning
		
	    }else{ //ELSE
		another += numHolder.substring(0, 1);//concatenate the next num
		numHolder = numHolder.substring(1, numHolder.length());//cut off
		//the first num and set numHolder as the rest of the num
	    }
	}
	return another;//return the final String of nums with commas
    }
    //DOES NOT WORK
    /*    public static String commafyR(int num) {
	String orig ="" + num;
	String numStr = "" + num; //turns to string;
	if (numStr.length() <= 3) { //base case
	    String holder = "" + num;
	    return holder;
	}
	if ((numStr.length() != orig.length()) && (numStr.length() % 3 == 0)) {
	    String holder;
	    holder += "," + numStr.substring(0, 1);
	    int counter;
	    counter += 1;
	    commafyR(Integer.parseInt(numStr.substring(1, numStr.length())));
	}else{
	    String holder;
	    holder += numStr.substring(0, 1);
	    int counter;
	    counter += 1;
	    commafyR(Integer.parseInt(numStr.substring(1, numStr.length())));
	}
	return holder;
    }
    */
    //DOES NOT WORK
    //recursion was harder than expected. the strings do not concatenate
    //the recursive call always seems to return the very first num instead of
    //the list of the num. 
    public static void main(String[] args) {
	for(String s: args) {//FOREACH loop
	    String nums = "";//will be the num with commas
	    String orig = s;//the original num for comparative use 
	    for(int x = s.length(); x > 0; x -= 1) {//a FOR loop inside a FOR
		//loop, WOAH! it's like a donut inside your donut!
		if ((s.length() != 0) && (s.length() % 3 == 0) && 
		    (s.length() != orig.length())) {//same as the comment above
		    //with FOR loop
		    
		    nums += "," + s.substring(0, 1);//set nums as a comma and
		    //the next num
		    s = s.substring(1, s.length());//s becomes shorter
		    
		}else{//ELSE
		    nums += s.substring(0, 1);//nums gains a num
		    s = s.substring(1, s.length());//s becomes shorter
		}
	    }
	    System.out.println(nums); //expected: whatever is inputted but with
	    //commas
	} 
	//    System.out.println(commafyF(123123)); //expected: 123,123

	//    System.out.println(commafyR(123123)); //expected: 123,123
	//               recieved: 1
    }
}
