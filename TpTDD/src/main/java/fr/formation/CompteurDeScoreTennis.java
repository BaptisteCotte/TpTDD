package fr.formation;

public class CompteurDeScoreTennis {

	private Partie p;
		
	public CompteurDeScoreTennis() {
	}

	public void creerPartie() {
		this.p = new Partie();
	}
	
	public void definirJoueur1(Joueur j) {
		this.p.setJoueur1(j);
	}
	
	public void definirJoueur2(Joueur j) {
		this.p.setJoueur2(j);
	}
	
	
	public void AjoutPoint(Joueur joueur) {
		if(p.getWinner() == null) {
			if(!p.isDecisif()){
				//joueur 1 win
				if(p.getJoueur1().equals(joueur)) {
					
					//test egalité
					if(p.getJoueur1().getPoints() == 40 && p.getJoueur2().getPoints() == 40) {
						//ajout point
						p.getJoueur1().addPoint();
						//ajout avantage
						p.getJoueur1().addAvantage();
						//test avantage joueur 2
						if(p.getJoueur2().isAvantage()) {
							//perte avantage joueur 2
							p.getJoueur2().loseAvantage();
						}
						//test avantage joueur 1
						if(p.getJoueur1().isAvantage()) {
							this.ajoutJeu(joueur);
						}
						//sinon
					} else {
						//ajout point
						p.getJoueur1().addPoint();
						//test avantage
						if(p.getJoueur1().isAvantage()) {
							p.getJoueur1().addJeu();
						}
					}
					
					
				}else {
					
					//test egalité
					if(p.getJoueur1().getPoints() == 40 && p.getJoueur2().getPoints() == 40) {
						//ajout point
						p.getJoueur2().addPoint();
						//ajout avantage
						p.getJoueur2().addAvantage();
						//test avantage joueur 1
						if(p.getJoueur1().isAvantage()) {
							//perte avantage joueur 1
							p.getJoueur1().loseAvantage();
						}
						//test avantage joueur 2
						if(p.getJoueur2().isAvantage()) {
							//gain d'un jeu
							this.ajoutJeu(joueur);
						}
						//sinon
					} else {
						//ajout point
						p.getJoueur2().addPoint();
						//test avantage
						if(p.getJoueur2().isAvantage()) {
							p.getJoueur2().addJeu();
						}
					}
				}
			} else {
				this.AjoutPointDecisif(joueur);
			}
		}
	}
	
	
	
	private void AjoutPointDecisif(Joueur joueur) {
		if(p.getJoueur1().equals(joueur)) {
			p.getJoueur1().addPointDecisif();
			if(p.getJoueur1().getPoints() >= 7 && p.getJoueur2().getPoints()<=(p.getJoueur1().getPoints()-2)) {
				this.ajoutJeu(joueur);
				p.setDecisif(false);
				this.ajoutSet(joueur);
			}
		}else {
			p.getJoueur2().addPointDecisif();
			if(p.getJoueur2().getPoints() >= 7 && p.getJoueur1().getPoints()<=(p.getJoueur2().getPoints()-2)) {
				this.ajoutJeu(joueur);
				p.setDecisif(false);
				this.ajoutSet(joueur);
			}
		}
	}

	
	
	public void ajoutJeu(Joueur joueur) {
		
		if(p.getJoueur1().equals(joueur)) {
			//gain d'un jeu
			p.getJoueur1().addJeu();
			//remise a 0 points
			p.getJoueur1().setPoints(0);
			p.getJoueur2().setPoints(0);
			
			if(p.getJoueur1().getJeux() >= 6 && p.getJoueur2().getJeux()<=(p.getJoueur1().getJeux()-2)) {
				this.ajoutSet(joueur);
			}
			
		} else {
			//gain d'un jeu
			p.getJoueur2().addJeu();
			//remise a 0 points
			p.getJoueur1().setPoints(0);
			p.getJoueur2().setPoints(0);
			
			if(p.getJoueur2().getJeux() >= 6 && p.getJoueur1().getJeux()<=(p.getJoueur2().getJeux()-2)) {
				this.ajoutSet(joueur);
			}
		}
		
		if(p.getJoueur1().getJeux() == 6 && p.getJoueur2().getJeux() == 6) {
			p.setDecisif(true);
		}
		
	}

	
	
	private void ajoutSet(Joueur joueur) {
		
		if(p.getJoueur1().equals(joueur)) {
			p.getJoueur1().addSet();
			if(p.getJoueur1().getSets()==2) {
				p.setWinner(joueur);
			}
		}else {
			p.getJoueur2().addSet();
			if(p.getJoueur2().getSets()==2) {
				p.setWinner(joueur);
			}
		}
	}
	
	public Partie getPartie() {
		return this.p;
	}
}


