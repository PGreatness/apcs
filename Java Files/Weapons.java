public abstract class Weapons {
    protected String weapName;
    protected double weapVal;
    public Weapons() {
	weapName = "Sword of Azaroth";
	weapVal = 0.5;
    }
    public abstract String about();
    public abstract String getNotif();
}
