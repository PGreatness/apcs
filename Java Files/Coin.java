//Ahnaf Hasan
//APCS1 pd01
//HW15 -- Wayne's World
//2017-10-12

public class Coin 
{
    String value;
    String upFace;
    String name;
    int flipCtr;
    int headsCtr;
    int tailsCtr;
    double bias;
    int ctrMatch;

    public Coin()
    {
	upFace = flip();
	bias = 0.5;
	ctrMatch = 0;
	headsCtr = 0;
	tailsCtr = 0;
	flipCtr = 0;
    }
    public Coin(String denom) 
    {
	this();
	value = denom;
    }
    public Coin(String denom, String face)
    {
	this();
	value = denom;
	upFace = face;
    }
    public double bias(double biasNum)
    {
	bias = biasNum;
	return bias;
    }
    public String flip()
    {
	if (Math.random() < bias){
	    upFace = "heads";
	    headsCtr += 1;
	    flipCtr += 1;
	    return "heads";
	}else{
	    upFace = "tails";
	    tailsCtr += 1;
	    flipCtr += 1;
	    return "tails";
	}
    }
    public String toString()
    {
	String retString = value;
	retString += " -- ";
	retString += upFace;
	return retString;
    }
    public String mine()
    {
	String retString = value;
	retString += " -- ";
	retString += upFace;
	return retString;
    }
    public String yours()
    {
	String retString = value;
	retString += " -- ";
	retString += upFace;
	return retString;
    }
    public String wayne()
    {
	String retString = value;
	retString += " -- ";
	retString += upFace;
	return retString;
    }
    public boolean equals(Coin person)
    {
	if (upFace == upFace){
	    ctrMatch += 1;
	    return true;
	}else{
	    return false;
	}
    }
    
    
}
