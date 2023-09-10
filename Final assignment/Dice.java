import java.util.Random;

public class Dice {
	static Random rand = new Random();
	private int value;
	
	public int Roll() {
		int roll = rand.nextInt(6)+1;
		value = roll;
		return roll;
	}
	
	public int Value() {	
		return value;
	}
	
	
}
