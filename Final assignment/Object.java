import java.util.Random;

public class Object {
	private static int strength;
	private  String symbol;
	private  int location;
	
	public Object(String s){
		Random rand = new Random();
		strength = rand.nextInt(5)+1;
		location = 0;
		this.setSymbol(s);
		
	}

	public static int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public int getLocation() {
		return location;
	}
	
	public void setLocation(int locate) {
		location = location + locate;
	}
}
