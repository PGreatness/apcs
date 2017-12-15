//Ahnaf Hasan
//APCS1
//September 26, 2017
//On the Origins of a BigSib

public class BigSib {
    // instance vars
   public String helloMsg;
    public BigSib(String given) 
    {
	String helloMsg = given;
	String NewMsg = helloMsg;
    }
    public BigSib(){
    }
    
    
    // methods
    public void setHelloMsg( String newMsg){
	helloMsg = newMsg;
    }
    
    public String greet( String name){
	helloMsg += " " + name;
	return helloMsg;
    }
}
//Base code taken from Raymond Wu.
/* Keeps returning as
null freshmen
etc.
etc.
Unsure of next step
May return later to think it out, preferably after dinner
Edit: Still couldn't get the code
*/
