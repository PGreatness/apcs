public class Werewolf extends Monster {
    public Werewolf() {
	super();
	HP = 130;
	defense = 20;
	atkRating = 1.35;
    }
    public String about() {
	String s = "This is the Werewolf. Elusive, dangerous, and an opponent worthy to die to. With a health rating of 130, defense of 20, and an attack rating of 1.35, many adventurers have perished to its claws. Will you be the next victim?";
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
