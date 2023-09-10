import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.SecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Score {
	//Attribute
	private int score;
	private String name;
	
	//Constructor
	public Score() {
		
	}
	
	public Score(int score, String name) {
		this.score = score;
		this.name = name;
	}

	//Setter getter
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//Other method
	public static void Scoreboard(String name, int score) {
		
		try {
			FileWriter fstream = new FileWriter("tempScore.txt",true);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write( score + " "+name +"\n");
			out.close();
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
	
	public static void Showboard() {
		
		
		try {
			File myObj = new File("TopScore.txt");
		      Scanner myReader = new Scanner(myObj);
		      int i =0;
		      while (myReader.hasNextLine() && i < 5) {
		        String data = myReader.nextLine();
		        System.out.println(data);
		        i++;
		      }
		      myReader.close();
			
		}catch(FileNotFoundException fe) {
			System.out.println("Error file");
		}catch(NoSuchElementException fe) {
			System.out.println("Error formed file");
			
		}
	}
	
	public static void ShowSorted() throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader("tempScore.txt"));
		ArrayList<String> str = new ArrayList<>();
		String line = "";
		while((line=reader.readLine())!=null){
				str.add(line);
		}
		reader.close();
		Collections.sort(str);
		FileWriter writer = new FileWriter("TopScore.txt");
		for(String s: str){
				
				writer.write(s);
				writer.write("\r\n");
		}
		
		writer.close();
	}
	

	  
	    
	
	//toString
	@Override
	public String toString() {
		return String.format("Name:%s Score:%d", name, score);
	}
	
	 
}
