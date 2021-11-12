package exception;

public class ValidationFormtPlayer extends Exception{

	public ValidationFormtPlayer(String players) {
		super("the space for player name is not valid");
		
	}

}
