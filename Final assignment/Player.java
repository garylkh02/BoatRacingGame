
public class Player {
	private String name;
	private int turn;
	
	
	public Player() {
		name = " ";
		turn = 0;	
	}
	
	public Player(String N) {
		this.setName(N);	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int t) {
		turn = turn + t;
	}
	
	@Override
	public String toString() {
		return String.format("Player [name=%s]", name);
	}
}
