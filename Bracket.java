import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Bracket {
	private ArrayList<Team> teams = new ArrayList<Team>();
    private ReadNCAA bob;
    private Game game;
    private Team loser;

	public Bracket(){
		bob = new ReadNCAA();
		game = new Game();
	} 
    public void simulate(int n){
    	for(int k = 0; k<n; k++){
        	teams.clear();
			for (Team t : bob.getTeams()) {
				teams.add(t);
			}
			for (int i = 0; i<6; i++) {
				for (int j = 0; j<teams.size() - 1; j++) {
					loser = game.play(teams.get(j), teams.get(j+1));
					teams.get(teams.indexOf(loser)).lose();
				    teams.remove(teams.indexOf(loser));
				}
				if (teams.size() == 1) {
					teams.get(0).champion();
				}
				for (Team tea : teams) {
					tea.win();
				}
			
			}
        }

    }
    public void printwins(int n){
    	teams.clear();
		for (Team t : bob.getTeams()) {
			teams.add(t);
		}
    	Team champion = teams.get(0);
        for (Team tea : teams) {
        	System.out.println();
        	System.out.println(tea.name() + " won " + tea.wins()+" times.");
        	if(tea.champions() > champion.champions()){
        		champion = tea;
        	}
        }
        System.out.println();
        System.out.println(champion.name() +" won the championship overall, with "+champion.champions()+" champion wins");
        System.out.println("The simulation ran " +n+" times.");
    }

    public void printResults(int n){
    	
    	ArrayList<Team> te = sortPercent();
    	for(Team t: te){
    		System.out.println(t.name() + " won " + t.percent()+"% of the time.");
    		System.out.println(t.name() + " won the title of champion "+ t.champions() + " times.");
    	}
    	System.out.println("Simulation ran " + n + " times.");
    }



    public ArrayList<Team> sortPercent(){
    	ArrayList<Team> te = new ArrayList<Team>();
    	for (Team t : bob.getTeams()) {	
			te.add(t);
		}
    	Team storage;
		int min;
		for (int i = 0; i<te.size(); i++) {
			storage = te.get(i);
			min = i;
			for (int k = i; k<te.size(); k++) {
				if(te.get(k).percent() < storage.percent()){
					storage = te.get(k);
					min = k;
				}

			}
			te.set(min, te.get(i));	
			te.set(i, storage);

		}
		return te;
    }




}