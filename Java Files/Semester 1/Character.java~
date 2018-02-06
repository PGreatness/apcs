public class Character {
    public int HP;
    public int strength;
    public int defense;
    public double atkRating;
    public Character() {
	HP = 100;
	strength = 100;
	defense = 20;
	atkRating = 1;
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
    public int lowerHP(int HPdmg) {
	HP -= HPdmg;
    }
    public int attack(Character enemy) {
	int damage = (int) ((strength * atkRating) - enemy.getDefense());
	enemy.lowerHP(damage);
	return damage;
    }
}
