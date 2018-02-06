public class Hammer extends Weapons {
    public Hammer() {
	weapName = "Hammer of Time";
	weapVal = 0.68;
    }
    public String about() {
	String s = "The Hammer of Time! Break through even the most" +
	    "strongest of barriers to strike your enemy from the future!";
	return s;
    }
    public String getNotif() {
	String get = "You've got: The Hammer of Time!";
	return get;
    }
}
