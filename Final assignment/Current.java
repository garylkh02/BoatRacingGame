import java.util.Random;

public class Current extends Object {
	Random rand = new Random();
	public Current() {
		super("C");
		setLocation(rand.nextInt(100));
	}
	@Override
	public String toString() {
		return String.format(
				getSymbol());
	}
}
