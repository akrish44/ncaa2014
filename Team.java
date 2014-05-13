public class Team {

	private String name;
	private double wp;
	private int seed;
	private int wins;
	private int champs = 0;
	private int losses;

	public Team(String name, int seed, double wp) {
		this.name = name;
		this.seed = seed;
		this.wp = wp;
		this.wins = 0;
	}
	public double percent(){
		double per = ((double)(wins()) / ((double)(wins())+(double)(losses())))*100.0;
		return per;
	}

	public void win() {
		wins++;
	}
	public void champion(){
		champs++;
	}
	public void lose(){
		losses++;
	}
	public int losses(){
		return losses;
	}
	public int champions(){
		return champs;
	}

	public int wins() {
		return wins;
	}

	public double wp() {
		return wp;
	}

	public int seed() {
		return seed;
	}

	public String name() {
		return name;
	}

}