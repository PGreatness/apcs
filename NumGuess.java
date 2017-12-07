import cs1.Keyboard;
public class NumGuess {
    int _startRange;
    int _endRange;
    int _guessCount;
    int _chosenNum;
    public numGuess() {
	_startRange = 1;
	_endRange = 100;
	guessCount = 0;
	_chosenNum = (int)((Math.random() + 1) * 100);
    }
    public void ChangeBound( int input ) {
	if (input >= _endRange) {
	    _endRange = input - 1;
	}else{
	    if (input < _startRange) {
		_startRange = input + 1;
	    }
	}
    }
    public static void main(String[] args) {
	int in = _startRange;
	while (in != _chosenNum) {
	    try {
		System.out.println("Guess: ");
		in = Keyboard.readInt();
		_guessCount++;
	    }
	    catch (Exception e) {
		System.out.println("Do a guess and try again");
	    }
	}
	System.out.println(_guessCount);
    }
}
