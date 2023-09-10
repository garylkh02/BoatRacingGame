import java.util.Random;

public class Trap extends Object{
	Random rand = new Random();
	public Trap() {
		super("#");
		setLocation(rand.nextInt(100));
	}
	
	@Override
	public String toString() {
		return String.format(
				getSymbol());
	}
}
