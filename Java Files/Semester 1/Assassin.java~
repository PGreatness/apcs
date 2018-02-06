//Team K.O.
//Team Roster -- Puneet Johal, Ahnaf Hasan
//APCS1 pd1
//HW31 -- Ye Olde Role Playing Game, Extended
//2017-11-13

public class Assassin extends Protagonist{

    //attributes
    private int sneak;

    //default constructor
    public Assassin(){
	name = "Altair";
	sneak = 15;
	atkRating = 0.75;
    }

    //overloaded constructor
    public Assassin(String nameVal){
	this();
	name = nameVal;
    }

    //overloaded constructor 2
    public Assassin(String nameVal, int sneakVal){
	this(nameVal);
	sneak = sneakVal;
    }
    
    //methods

    //about
    public static String about(){
	return "This being lurks in the shadows and takes \nmany steps to cover its tracks. Some assasins \nare said to have never been spotted in years.\nThat being said, there is very little known \nabout these people, except that their attacks \nare precise and do the trick, quickly and\nquietly.";
    }

    //isAlive
    public boolean isAlive(){
	return super.isAlive();
    }

    //getDefense
    public int getDefense(){
	return super.getDefense();
    }

    //getName
    public String getName(){
	return super.getName();
    }

    //lowerHP
    public int lowerHP(int Hdamage){
	return super.lowerHP(Hdamage);
    }

    //attack
    public int attack(Monster evilName){
	return super.attack(evilName);
    }

    //specialize
    public void specialize(){
	defense -= 10;
	atkRating += 0.6;
    }

    //normalize
    public void normalize(){
        defense = 40;
	atkRating = .4;
    }
    
    //toString
    public String toString(){
	return "Name: " + name +
               "\nHP: " + HP +
	       "\nStrength: " + strength +
	       "\nDefense: " + defense +
	       "\nAttack rating: " + atkRating +
	       "\nSneak: " + sneak;
    }

    //main
    public static void main(String args[]){
	Assassin Char = new Assassin();
	System.out.println(about());
	System.out.println();
	System.out.println(Char);
	System.out.println();
	
	Assassin Ezio = new Assassin("Ezio", 20);
	System.out.println(Ezio);
    }
}

