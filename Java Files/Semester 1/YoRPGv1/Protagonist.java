public class Protagonist {
    public String name; 
    public int HP;
    public int strength;
    public int defense;
    public double atkRating;
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
	boolean retBoo = true;
	if (HP <= 0) {
	    retBoo = false;
	}
	return retBoo;
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
    public void specialize() { //special attack
	System.out.println("Special Attack!"); //to distinguish
	defense -= 10; //lower defense...
	atkRating += 0.5;//and increase attack
    }
    public void normalize() {
	System.out.println("Normal Attack!"); //to distinguish
	//reset values to previous values
	//PLEASE CHANGE IF INITIALIZATION HAS BEEN CHANGED
	defense = 50;
	atkRating = 0.4;
    }
}
