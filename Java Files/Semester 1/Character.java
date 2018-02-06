//Team K.O.
//Team Roster -- Puneet Johal, Ahnaf Hasan
//APCS1 pd1
//HW30 -- Ye Olde Role Playing Game, Improved
//2017-11-10

public abstract class Character {

    //attributes
    public int HP;
    public int strength;
    public int defense;
    public double atkRating;

    //default constructor
    public Character(){
	HP = 100;
	strength = 100;
	defense = 20;
	atkRating = 1.0;
    }

    //overloaded constructor
    public Character(int _HP, int _strength, int _defense, int _atkRating){
	HP = _HP;
	strength = _strength;
	defense = _defense;
	atkRating = _atkRating;
    }

    //=========================METHODS=========================

    /*=========================================
      isAlive():
      returns true if the character in question
      is still alive, false otherwise.
      ==========================================*/
    public boolean isAlive() {
	if (HP <= 0) {
	    return false;
	}
	return true;
    }

    /*=========================================
      getDefense():
      returns the value of the defense
      attribute of the character calling the
      method.
      ==========================================*/
    public int getDefense() {
	return defense;
    }

    /*=========================================
      lowerHP():
      lowers HP attribute by given amount.
      returns new HP.
      ==========================================*/
    public int lowerHP(int Hdmg) {
	HP -= Hdmg;
	return HP;
    }

    /*=========================================
      attack():
      sets damage to strength * atkRating of
      the character that is calling the method
      minus the defense of the character that
      is going to be attacked, then subtracts
      that value from the HP of the enemy.
      returns damage.
      ==========================================*/
    public int attack(Character enemy) {
	int damage = (int) ((strength * atkRating) - enemy.getDefense());
	enemy.lowerHP(damage);
	return damage;
    }
    public abstract void normalize();
    public abstract void specialize();

    //main
    public static void main(String[] args){
	/*	Character Dragonborn = new Character();
	System.out.println("Character has been spawned.");
	System.out.println();
	
	System.out.println("Are you alive?");
	System.out.println(Dragonborn.isAlive()); //true
	System.out.println();
	
	System.out.println("Cool. What's your defense?");
	System.out.println(Dragonborn.getDefense()); //20
	System.out.println();
	
	Dragonborn.lowerHP(50);
	System.out.println("Dragonborn has been struck by lightning. HP -50");
	System.out.println("You good bro?");
	System.out.println(Dragonborn.isAlive()); //true
	System.out.println();
	
	System.out.println("Hey you should be more - wait that's dangerous! You'll hurt yourself!");
	Dragonborn.attack(Dragonborn);
	System.out.println("Dragonborn has inflicted damage on themselves. HP -80");
	System.out.println();
	
	System.out.println("Yikes are you ok?");
	System.out.println(Dragonborn.isAlive()); //false
	System.out.println();
	
	System.out.println("And thus the Dragonborn's tale comes to an end.");
	*/ }//end main
}//end class
    
