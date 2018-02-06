public class Mage extends Protagonist {
    public String name;
    
    public Mage() {
	name = "Mage";
	HP = 80;
	strength = 60;
	defense = 20;
	atkRating = 0.6;
	oldAtkR = 0.6;
    }
    
    public Mage(String pName) {
	this();
	name = pName;
    }
    
    public boolean isAlive() {
	if (HP <= 0) {
	    return false;
	}else{
	    return true;
	}
    }
    
    public int getDefense() {
	return defense;
    }
    
    public String getName() {
	return name;
    }
    
    public int lowerHP(int damage) {
	HP -= damage;
	return HP;
    }
    
    public int attack(Monster enemy) {
	int damage = (int) ((strength * atkRating) - enemy.getDefense());
	enemy.lowerHP(damage);
	return damage;
    }
    
    public void specialize() { //special attack
	System.out.println("Special Attack!"); //to distinguish
	defense -= 10; //lower defense...
	atkRating += 0.5;//and increase attack
    }
    
    public void normalize() {
	System.out.println("Normal Attack!"); //to distinguish
	//reset values to previous values
	defense = 20;
	atkRating = oldAtkR;
    }
}
