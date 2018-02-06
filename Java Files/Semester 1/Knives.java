public class Knives extends Weapons {
    public Knives() {
	weapName = "Knives of Kratos";
	weapVal = 0.56;
    }
    public String about() {
	String s = "The Knives of Kratos were said to be weilded by" +
	    " none other than the legendary warrior himself. Legend " +
	    "speaks of another, much, much stronger than the " +
	    "Conquerer of Gods.";
	return s;
    }
    public String getNotif() {
	String get = "You've got: Knives of Kratos!";
	return get;
    }
}
