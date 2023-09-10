import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class River {
	Random rand = new Random();
	List<Object> river = new ArrayList<Object>();
	
	public River() {
		for (int i =0; i<100; i++) {
			river.add(new Water());
			}
		for (int j =0; j<10; j++) {
			river.set(rand.nextInt(6,100), new Current());
		}
		for (int j =0; j<10; j++) {
			river.set(rand.nextInt(6,100), new Trap());
		}
	}
	
	public void display() {
		System.out.print(river);
	}
	
	public List<Object> getRiver() {
		return river;
	}

	public void setRiver(ArrayList<Object> river) {
		this.river = river;
	}
}
