//Team K.O.
//Team Roster -- Puneet Johal, Ahnaf Hasan
//APCS1 pd1
//HW28 -- Ye Olde Role Playing Game
//2017-11-08

public abstract class Protagonist {
    protected String name; 
    protected int HP;
    protected int strength;
    protected int defense;
    protected double atkRating;
    protected double oldAtkR;
    /*=========================================
    Default Constructor:
    Sets a generic name, HP to 100, strength to
    40, defense to 40, and the attack rating to
    0.4 .
    ==========================================*/
    public Protagonist() {
	name = "Warrior";
	HP = 100;
	strength = 40;
	defense = 40;
	atkRating = 0.4;
	oldAtkR = 0.4;
    }
    public Protagonist(String pName) {
	this(); //calls back to default constructor
	        //initalize everything...
	name = pName;//...and set a new name
    }
    /*=========================================
      isAlive():
      returns true if the person in question is
      still alive, false otherwise.
    ==========================================*/
    public boolean isAlive() {
	return (0 <= HP);
    }
    
    public int getDefense() {
	return defense; //returns defense value
    }
    public String getName() {
	return name; //returns the name of the person
    }
    public int lowerHP(int Hdamage) {
	HP -= Hdamage; //subtracts the damage from the
	               //and sets the HP as that
	return HP; //returns HP
    }
    public int attack(Monster evilName) { //Mwahahaha
	int damage = (int) ((strength * atkRating) - evilName.getDefense());
	//as per instructions given
	evilName.lowerHP(damage); //lower the HP of the Monster
	return damage; //return the damage to be printed
    }
    public abstract void specialize();
    public abstract void normalize();
}
