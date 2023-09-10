import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

 

public class Game {
	private River r = new River();
	private Player Player1 = new Player();
	private Player Player2 = new Player();
	private Dice dice1 = new Dice();
	private Dice dice2 = new Dice();
	Scanner input = new Scanner(System.in);
	Score s = new Score();
	
	public void Start() {
		System.out.println("Top 5 Scoreboard");
		System.out.println("Turns  Name");
		Score.Showboard();
		
		System.out.println("\nEnter Username 1: ");
		String p1name = input.next();
		Player1.setName(p1name);
		System.out.println("Enter Boat Name: ");
		String p1boatname = input.next();
		Boat boat = new Boat(p1boatname);
		
		
		System.out.println("Enter Username 2: ");
		String p2name = input.next();
		Player2.setName(p2name);
		System.out.println("Enter Boat Name: ");
		String p2boatname = input.next();
		Boat boat1 = new Boat(p2boatname);
		
		String duplicate = p1boatname + p2boatname;
		Boat dupeboat = new Boat(duplicate);
		
		System.out.println("\n" + Player1);
		r.getRiver().set(boat.getLocation(), dupeboat);
		r.display();
		

		int i = 0, j = 0;
		
		while ((boat.getLocation() != 100 || boat1.getLocation() != 100)) {
			try {
				System.out.println("\n\n"+Player1.getName()+ ": Roll dice [Y/N]:  ");
				String roll = input.next().toUpperCase();
				if (roll.equals("Y")) {
					
					System.out.println("Rolled Dice Value: "+dice1.Roll());

					boat.setLocation(dice1.Value());
					System.out.println("Boat " + boat.getSymbol()+" Position: "+boat.getLocation());
					Player1.setTurn(i + 1);

					
					System.out.print(r.getRiver().get(boat.getLocation()));
					
					if (r.getRiver().get(boat.getLocation()) == r.getRiver().get(boat.getLocation())) {
						r.getRiver().set(boat1.getLocation(), boat1);
					
					}
					if((r.getRiver().get(boat.getLocation()).getSymbol()) == "C") {
						System.out.println("Step on Current");
						boat.setLocation(Current.getStrength());
						System.out.println("Current strength: " + Current.getStrength());
						System.out.println("New Boat " + boat.getSymbol()+" Position: "+boat.getLocation());
						r.getRiver().set(boat.getLocation(), boat);
					}
					else if((r.getRiver().get(boat.getLocation()).getSymbol()) == "#") {
						System.out.println(":Step on Trap");
						boat.setLocation(-(Trap.getStrength()));
						System.out.println("Trap strength: " + Trap.getStrength());
						System.out.println("New Boat " + boat.getSymbol() + " Position: " + boat.getLocation());
						r.getRiver().set(boat.getLocation(), boat);
					}
					else if((r.getRiver().get(boat.getLocation()).getSymbol()) == boat1.getSymbol()) {
						
						
						
						r.getRiver().set(boat1.getLocation(), dupeboat);
						
					}
					else {
						r.getRiver().set(boat.getLocation(), boat);
					}
					
					r.display();

					r.getRiver().set(boat1.getLocation(), new Water());
					

					
				}
				else if(roll.equals("N")) {
					System.out.println("Thank you "+Player1.getName());
					System.exit(0);
				} else {
					System.out.println("Enter either Y or N");
					continue;
				}
			} catch(IndexOutOfBoundsException ie) {
				boat.setLocation(100);
				Score s1 = new Score();
				s1.setName(Player1.getName());
				s1.setScore(i);
				
				Score.Scoreboard(Player1.getName(),Player1.getTurn());
				System.out.println("Congrats " + Player1.getName() + " , your score is " + Player1.getTurn());
				break;
			}
			
			
			try {
				System.out.println("\n\n" + Player2);
				System.out.println(Player2.getName()+": Roll dice [Y/N]:  ");
				String roll1 = input.next().toUpperCase();
				
				if (roll1.equals("Y")) {
					
					System.out.println("Dice: "+dice2.Roll());
					System.out.println(dice2.Value());
					boat1.setLocation(dice2.Value());
					System.out.println("Boat " + boat1.getSymbol()+" Position: "+boat1.getLocation());
					Player2.setTurn(j + 1);

					
					System.out.print(r.getRiver().get(boat1.getLocation()));
					if (r.getRiver().get(boat1.getLocation()) == r.getRiver().get(boat1.getLocation())) {
						r.getRiver().set(boat.getLocation(), boat);
					
					}
					if((r.getRiver().get(boat1.getLocation()).getSymbol()) == "C") {
						System.out.println(":Step on Current");
						boat1.setLocation(Current.getStrength());
						System.out.println("Current strength: " + Current.getStrength());
						System.out.println("New Boat " + boat1.getSymbol()+" Position: "+boat1.getLocation());
						r.getRiver().set(boat1.getLocation(), boat1);
					}
					else if((r.getRiver().get(boat1.getLocation()).getSymbol()) == "#") {
						System.out.println(":Step on Trap");
						boat1.setLocation(-(Trap.getStrength()));
						System.out.println("Trap strength: " + Trap.getStrength());
						System.out.println("New Boat " + boat1.getSymbol() + " Position: " + boat.getLocation());
						r.getRiver().set(boat1.getLocation(), boat1);
					}
					else if((r.getRiver().get(boat1.getLocation()).getSymbol()) == boat.getSymbol()) {
						
						
						
						r.getRiver().set(boat1.getLocation(), dupeboat);
						
					}
					else {
						r.getRiver().set(boat1.getLocation(), boat1);
					}
					
					r.display();
					
					r.getRiver().set(boat.getLocation(), new Water());
					

				}
				
				else if(roll1.equals("N")) {
					System.out.println("Thank you "+Player2.getName());
					System.exit(0);
				} else {
					System.out.println("Enter only either Y or N");
					continue;
				}
			} catch(IndexOutOfBoundsException ie) {
					boat1.setLocation(100);
					Score s2 = new Score();
					s2.setName(Player1.getName());
					s2.setScore(j);

					Score.Scoreboard(Player2.getName(),Player2.getTurn());
					System.out.println("Congrats " + Player2.getName() + " , your score is " + Player2.getTurn());
					break;
			}
			
			
			
	}
	}
	public void end() throws NumberFormatException, IOException {
		Score.ShowSorted();
		System.out.println("\nDid u get into top 5 ? ");
		System.out.println("\nTop 5 Scoreboard");
		System.out.println("\nTurns  Name");
		Score.Showboard();
		
		
		boolean check = false;
		while (check != true) {
			System.out.println("\nDo you want to give feedback?");
			System.out.println("Type Y or N: ");
			String checker = input.next().toUpperCase();
			if (checker.equals("Y")) {
				
				try {
					System.out.print("One word Feedback to describe: ");
					
					String feedback = input.next();
					FileWriter fstream = new FileWriter("userfeedback.txt",true);
					BufferedWriter out = new BufferedWriter(fstream);
					out.write(feedback+"\n");
					out.close();
					System.out.println("Thank you");
					check = true;
					
				}
				catch(SecurityException se) {
					System.out.println("Error");
					System.exit(1);
				}catch(FileNotFoundException fe) {
					System.out.println("Error file");
					System.exit(1);
				}catch (Exception e){
					 System.err.println("Error while writing to file: " +
					          e.getMessage());
				}
			}
			else if(checker.equals("N")){
				
				System.out.println("Thank you");
				break;
				
			}
			else {
				System.out.println("Enter only either Y or N");
				continue;
			}
		}
		
		
		
	}
}