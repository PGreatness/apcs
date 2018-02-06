//Team K.O.
//Team Roster -- Puneet Johal, Ahnaf Hasan
//APCS1 pd1
//HW31 -- Ye Olde Role Playing Game, Extended
//2017-11-13

public class Jedi extends Protagonist{

    //attributes
    private int force;

    //default constructor
    public Jedi(){
	name = "Anakin Skywalker";
	force = 50;
	strength = 60;
    }

    //overloaded constructor
    public Jedi(String nameVal){
	this();
	name = nameVal;
    }

    //overloaded constructor 2
    public Jedi(String nameVal, int forceVal){
	this(nameVal);
	force = forceVal;
    }

    //methods

    //about
    public static String about(){
	return "A long time ago, in a galaxy far, far away... \nThere existed humans who possessed the ability\nto use the force and cool glowy sword things.\nThey have greater strength that their other\ncounterparts and an added ability.\nQuite a formidable character indeed..";
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
        defense -= 15;
	atkRating += 0.4;
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
	       "\nForce: " + force;
    }

    //main
    public static void main(String args[]){
	Jedi Char = new Jedi();
	System.out.println(about());
	System.out.println();
	System.out.println(Char);
	System.out.println();
	
	Jedi Luke = new Jedi("Luke Skywalker", 1000);
	System.out.println(Luke);
    }
}
