import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;


public class ReadNCAA {
    private ArrayList<Team> teams = new ArrayList<Team>();
	public ReadNCAA() {
		try{
		    Scanner reader = new Scanner(new File("ncaa2014.csv"));	        
			while (reader.hasNextLine()) {
				String next = reader.nextLine();
				String[] values = next.split(",");
            	if(values.length < 3){}else{
            		teams.add(new Team(values[0], Integer.parseInt(values[1]), Double.parseDouble(values[2])));
            	}		
			}
		}catch (FileNotFoundException e){
            System.out.println("File not found1.");
        }
	}
    public ArrayList<Team> getTeams(){
    	return teams;
    }

}

