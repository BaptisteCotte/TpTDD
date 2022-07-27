package fr.formation;

public class Joueur {

	private int points;
	private int jeux;
	private int sets;
	private boolean avantage;
	
	public Joueur() {
		this.points = 0;
		this.jeux = 0;
		this.sets = 0;
		this.avantage = false;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getJeux() {
		return jeux;
	}

	public void setJeux(int jeux) {
		this.jeux = jeux;
	}

	public int getSets() {
		return sets;
	}

	public void setSets(int sets) {
		this.sets = sets;
	}

	public void addPoint() {
		if(this.getPoints() == 0) {
			this.setPoints(15);
		} else if(this.getPoints() == 15) {
			this.setPoints(30);
		} else if(this.getPoints() == 30) {
			this.setPoints(40);
		}
	}

	public boolean isAvantage() {
		return avantage;
	}

	public void setAvantage(boolean avantage) {
		this.avantage = avantage;
	}

	public void addAvantage() {
		this.setAvantage(true);
	}

	public void loseAvantage() {
		this.setAvantage(false);
	}

	public void addJeu() {
		this.setJeux(this.getJeux()+1);
	}

	public void addSet() {
		this.setSets(this.getSets()+1);
	}

	public void addPointDecisif() {
		this.setPoints(this.getPoints()+1);	
	}


}
