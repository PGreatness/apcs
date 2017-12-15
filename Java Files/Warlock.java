public class Warlock extends Monster {
    public Warlock() {
	super();
	HP = 125;
	defense = 50;
	atkRating = 1.35;
    }
    public String about() {
	String s = "This is a Warlock. Evil runs through its veins more than blood, with a sly crooked mind that plans 2 steps ahead. The Warlock rules with an iron fist, aided by his 125 HP, 50 defense rating, and 1.35 attack Rating. None have survived his onslaught, time for you to make change.";
	return s;
    }
    public boolean isAlive() {
	return super.isAlive();
    }
    public int getDefense() {
	return super.getDefense();
    }
    public int lowerHP(int damage) {
	return super.lowerHP(damage);
    }
    public int attack(Protagonist opposed) {
	return super.attack(opposed);
    }
}
