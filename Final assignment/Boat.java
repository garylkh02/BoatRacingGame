
public class Boat extends Object{
	public Boat(String c) {
		super(c);
	}

	@Override
	public String toString() {
		return String.format(
				getSymbol());
	}
}
