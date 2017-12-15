public class Troll extends Monster {
    public Troll() {
	super();
    }
    public String about() {
	String s = "There stands before you a Troll. Often delegated to the grunt work of the all monsters, Trolls are impressive in their own sense. Most Trolls have superhumane strength by birth, only strengthened by their arduous work in the mines. With a stature of 6'7\", they can easily \"mistake\" your skull for a precious metal. Be wary of what you look like...";
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
