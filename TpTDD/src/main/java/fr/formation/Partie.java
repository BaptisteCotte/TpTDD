package fr.formation;

public class Partie {
	
	private Joueur joueur1;
	private Joueur joueur2;
	private boolean decisif;
	private Joueur Winner;
	
	public Partie() {}
	
	public Partie(Joueur joueur1,Joueur joueur2) {
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		this.decisif = false;
		this.Winner = null;
	}

	public Joueur getJoueur1() {
		return joueur1;
	}

	public void setJoueur1(Joueur joueur1) {
		this.joueur1 = joueur1;
	}

	public Joueur getJoueur2() {
		return joueur2;
	}

	public void setJoueur2(Joueur joueur2) {
		this.joueur2 = joueur2;
	}

	public void AjoutPoint(Joueur joueur) {
		if(this.Winner == null) {
			if(!isDecisif()){
				//joueur 1 win
				if(this.getJoueur1().equals(joueur)) {
					
					//test egalité
					if(this.getJoueur1().getPoints() == 40 && this.getJoueur2().getPoints() == 40) {
						//ajout point
						this.getJoueur1().addPoint();
						//ajout avantage
						this.getJoueur1().addAvantage();
						//test avantage joueur 2
						if(this.getJoueur2().isAvantage()) {
							//perte avantage joueur 2
							this.getJoueur2().loseAvantage();
						}
						//test avantage joueur 1
						if(this.getJoueur1().isAvantage()) {
							this.ajoutJeu(joueur);
						}
						//sinon
					} else {
						//ajout point
						this.getJoueur1().addPoint();
						//test avantage
						if(this.getJoueur1().isAvantage()) {
							this.joueur1.addJeu();
						}
					}
					
					
				}else {
					
					//test egalité
					if(this.getJoueur1().getPoints() == 40 && this.getJoueur2().getPoints() == 40) {
						//ajout point
						this.getJoueur2().addPoint();
						//ajout avantage
						this.getJoueur2().addAvantage();
						//test avantage joueur 1
						if(this.getJoueur1().isAvantage()) {
							//perte avantage joueur 1
							this.getJoueur1().loseAvantage();
						}
						//test avantage joueur 2
						if(this.getJoueur2().isAvantage()) {
							//gain d'un jeu
							this.ajoutJeu(joueur);
						}
						//sinon
					} else {
						//ajout point
						this.getJoueur2().addPoint();
						//test avantage
						if(this.getJoueur2().isAvantage()) {
							this.joueur2.addJeu();
						}
					}
				}
			} else {
				this.AjoutPointDecisif(joueur);
			}
		}
	}
	
	
	
	private void AjoutPointDecisif(Joueur joueur) {
		if(this.getJoueur1().equals(joueur)) {
			this.joueur1.addPointDecisif();
			if(this.getJoueur1().getPoints() >= 7 && this.getJoueur2().getPoints()<=(this.getJoueur1().getPoints()-2)) {
				this.ajoutJeu(joueur);
				this.setDecisif(false);
				this.ajoutSet(joueur);
			}
		}else {
			this.joueur2.addPointDecisif();
			if(this.getJoueur2().getPoints() >= 7 && this.getJoueur1().getPoints()<=(this.getJoueur2().getPoints()-2)) {
				this.ajoutJeu(joueur);
				this.setDecisif(false);
				this.ajoutSet(joueur);
			}
		}
	}

	
	
	public void ajoutJeu(Joueur joueur) {
		
		if(this.getJoueur1().equals(joueur)) {
			//gain d'un jeu
			this.getJoueur1().addJeu();
			//remise a 0 points
			this.joueur1.setPoints(0);
			this.joueur2.setPoints(0);
			
			if(this.getJoueur1().getJeux() >= 6 && this.getJoueur2().getJeux()<=(this.getJoueur1().getJeux()-2)) {
				this.ajoutSet(joueur);
			}
			
		} else {
			//gain d'un jeu
			this.getJoueur2().addJeu();
			//remise a 0 points
			this.joueur1.setPoints(0);
			this.joueur2.setPoints(0);
			
			if(this.getJoueur2().getJeux() >= 6 && this.getJoueur1().getJeux()<=(this.getJoueur2().getJeux()-2)) {
				this.ajoutSet(joueur);
			}
		}
		
		if(this.getJoueur1().getJeux() == 6 && this.getJoueur2().getJeux() == 6) {
			this.setDecisif(true);
		}
		
	}

	
	
	private void ajoutSet(Joueur joueur) {
		
		if(this.getJoueur1().equals(joueur)) {
			this.joueur1.addSet();
			if(this.joueur1.getSets()==2) {
				this.setWinner(joueur);
			}
		}else {
			this.joueur2.addSet();
			if(this.joueur2.getSets()==2) {
				this.setWinner(joueur);
			}
		}
	}

	public boolean isDecisif() {
		return decisif;
	}

	public void setDecisif(boolean decisif) {
		this.decisif = decisif;
	}

	public Joueur getWinner() {
		return Winner;
	}

	public void setWinner(Joueur winner) {
		Winner = winner;
	}
	
}
