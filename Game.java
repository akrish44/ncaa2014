import java.util.Random;

public class Game {
    private Random r; 
    
    public Game(){
        r = new Random();
    }

    public Team play(Team a, Team b){
    	double pab = ((a.wp() - (a.wp()*b.wp()))/(a.wp()+b.wp()-(2*a.wp()*b.wp())))*100;
        double win = r.nextDouble();
        if(win  * 100 > pab){
        	return a;
        }else {
        	return b;
        }
    }


}