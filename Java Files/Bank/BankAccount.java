// Ahnaf Hasan [Adaption of
//team#07 greatness (James Huang, Raymond Wu, Qian Zhou)]
// APCS1 pd01
// HW10 -- building a more meaningful class
// 2017-10-04 

public class BankAccount
{
    //instance variables
    private  String name;
    private  String passwd;
    private  int pin;
    private  int acctNum;
    private  double balance;

    

/* default constructor: initializes instance vars to default vals
precondition:  none
postcondition: instance vars have appropriate default vals
````````````````````````````````````````````````````*/
    public BankAccount() {
	String name = "John";
	String passwd = "pass123";
	int pin = 1000;
	int acctNum = 100000000;
	double balance = 1000;
    }


/* overloaded constructor: allows caller to specify account
number and passwd. Assigns defaults
to other instance vars.
precondition:  params are passed in specified order
postcondition: instance vars have values specified by params
````````````````````````````````````````````````````*/
public BankAccount( int newAcctNum, String newPass ) {
    int acctNum = newAcctNum;
    String passwd = newPass;
    int pin = 1000;
    double balance = 1000;
}
/* overloaded constructor: allows caller to specify instance vars
precondition: params are passed in specified order
postcondition: instance vars have values specified by params
````````````````````````````````````````````````````*/
public BankAccount( int newAcctNum, String newPass,
			double newBal, String newName, int newPin ) {
    int acctNum = newAcctNum;
    String passwd = newPass;
    double balance = newBal;
    String name = newName;
    int pin = newPin;
}

    //mutators
    //set the name as the name variable. returns the previous name
    public  String setName( String newName )
    {
	String oldName = name;
	name = newName;
	return oldName;
    }

    //set the password as the passwd variable. old password is returned
    public  String setPasswd( String newPasswd )
    {
	String oldPasswd = passwd;
	passwd = newPasswd;
	return oldPasswd;
    }

    //the new pin number is set as the pin variable. the number has to be at
    //least 1000 or higher and 9998 or lower. if it is higher, the pin is set
    //as 9999 and it says the pin is invalid. either way, it returns the old
    //pin number
    public  int setPin( int newPin )
    {
	int oldPin = pin;
	if (1000<=newPin && newPin<=9998) {
	    pin = newPin; }
	else {
	    pin = 9999 ;
	    System.out.println("you must make your account number 1000-9998, your new pin was invalid");
	}
	return oldPin;
    }

    //sets the account number. the new account number has to be between
    //100000000 and 999999998, inclusive. if not, the number is set as
    //999999999 and it says the numberis invalid. the old number is returned.
    public  int setAcctNum( int newAcctNum )
    {
	int oldAcctNum = acctNum;
	if (100000000<=newAcctNum && newAcctNum<=999999998) {
	    acctNum = newAcctNum; 
	}
	else {
	    acctNum = 999999999;
	    System.out.println("you must make your account number between 100000000-999999998, your new number was invalid.");
	}
    
	return oldAcctNum;
    }

    //sets the new balance as the balance variable. the old blance is then
    //returned.
    public  double setBalance( double newBalance )
    {
	double oldBalance = balance;
	balance = newBalance;
	return oldBalance;
    }

    //defines the deposit method. the new balance is equal to the value of the
    //previous balance added to the deposit amount. this isn't returned.
    public  void deposit( double depositAmount ) {
	balance = balance + depositAmount;
    }

    //defines the withdraw method. if the amount to be withdrawn, output, is
    //lower than or equal to the balance, the output is subtracted from the
    //balance and stored as the value of balance and then returns true. else,
    //it amusingly says that the person is too broke for that action and returns
    //false.
    public  boolean withdraw(double output){
	if (output <= balance){
	    balance -= output;
	    return true;
	}
	else{
	    System.out.println( "You're too broke for that.");
	    return false;
        }
    }

    //overwritten toString()

    //displays the necessary info such as name, password, pin, account number,
    //and balance all in one easy to read section.
    public  String toString() {
	String retStr = "\nAccount info:\n=======================";
	retStr = retStr + "\nName: " + name;
	retStr = retStr + "\nPassword: " + passwd;
	retStr = retStr + "\nPIN: " + pin;
	retStr = retStr + "\nAccount Number: " + acctNum;
	retStr = retStr + "\nBalance: " + balance;
	retStr = retStr + "\n=======================";
	//System.out.println(toString());
	return retStr;
    }

    //returns true is both accound number and the stored account number are
    //equal and the name and the stored name is the same. if either is false,
    //returns false.
    public  boolean authenticate (int isAcctNum, String isName){
	return isAcctNum == acctNum && isName== name;
    }
		
    //main method for testing
    public static void main( String[] args )
    {
	BankAccount f=new BankAccount();
	f.setAcctNum(123456789);
	f.setName("name");
	System.out.println(f.authenticate(123456789, "name"));
	f.setPin(1234);
	f.setPasswd("helloworld");
	f.setBalance(100);
	f.withdraw(45.12);
	System.out.println(f.balance);
	f.deposit(72.89);
	System.out.println(f.balance);
     

	System.out.println(f.toString());
    }//end main()

}//end class BankAccount
