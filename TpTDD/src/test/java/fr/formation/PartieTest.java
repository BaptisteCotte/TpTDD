package fr.formation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PartieTest {

	@Test
	@DisplayName("Test création partie")
	public void testCréationPartie() {
		//GIVEN	
		Partie p = new Partie();
		//WHEN
		//THEN
		Assertions.assertInstanceOf(Partie.class, p);
	}
	
	@Test
	@DisplayName("Test affectation partie")
	public void testAffectationPartie() {
		//GIVEN	
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.setJoueur2(new Joueur());
		//WHEN
		//THEN
		Assertions.assertInstanceOf(Joueur.class, p.getJoueur1());
		Assertions.assertInstanceOf(Joueur.class, p.getJoueur2());
	}
	
	@Test
	@DisplayName("Test initialisation des points")
	public void testInitialisationDesPoints() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.setJoueur2(new Joueur());
		//WHEN
		//THEN
		Assertions.assertEquals(0, p.getJoueur1().getPoints());
		Assertions.assertEquals(0, p.getJoueur2().getPoints());
	}
	
	@Test
	@DisplayName("Test initialisation des jeux")
	public void testInitialisationDesJeux() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.setJoueur2(new Joueur());
		//WHEN
		//THEN
		Assertions.assertEquals(0, p.getJoueur1().getJeux());
		Assertions.assertEquals(0, p.getJoueur2().getJeux());
	}
	
	@Test
	@DisplayName("Test initialisation des sets")
	public void testInitialisationDesSets() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.setJoueur2(new Joueur());
		//WHEN
		//THEN
		Assertions.assertEquals(0, p.getJoueur1().getSets());
		Assertions.assertEquals(0, p.getJoueur2().getSets());
	}
	
	@Test
	@DisplayName("Test gain de points 2")
	public void testGainDePoints_2() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.setJoueur2(new Joueur());
		//WHEN
		p.AjoutPoint(p.getJoueur2());
		//THEN
		Assertions.assertTrue(p.getJoueur1().getPoints()==0);
		Assertions.assertTrue(p.getJoueur2().getPoints()>0);
	}
	
	@Test
	@DisplayName("Test gain de points 1")
	public void testGainDePoints_1() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.setJoueur2(new Joueur());
		//WHEN
		p.AjoutPoint(p.getJoueur1());
		//THEN
		Assertions.assertTrue(p.getJoueur2().getPoints()==0);
		Assertions.assertTrue(p.getJoueur1().getPoints()>0);
	}
	
	@Test
	@DisplayName("Test gain de points 0-15")
	public void testGainDePoints015() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.setJoueur2(new Joueur());
		//WHEN
		p.AjoutPoint(p.getJoueur2());
		//THEN
		Assertions.assertEquals(15,p.getJoueur2().getPoints());
	}
	
	
	@Test
	@DisplayName("Test gain de points 15-30")
	public void testGainDePoints1530() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.setJoueur2(new Joueur());
		//WHEN
		p.AjoutPoint(p.getJoueur2());
		p.AjoutPoint(p.getJoueur2());
		//THEN
		Assertions.assertEquals(30,p.getJoueur2().getPoints());
	}
	
	@Test
	@DisplayName("Test gain de points 30-40")
	public void testGainDePoints3040() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.setJoueur2(new Joueur());
		//WHEN
		p.AjoutPoint(p.getJoueur2());
		p.AjoutPoint(p.getJoueur2());
		p.AjoutPoint(p.getJoueur2());
		//THEN
		Assertions.assertEquals(40,p.getJoueur2().getPoints());
	}
	
	@Test
	@DisplayName("Test initialisation avantage")
	public void testAvantage() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.setJoueur2(new Joueur());
		//WHEN
		//THEN
		Assertions.assertFalse(p.getJoueur1().isAvantage());
		Assertions.assertFalse(p.getJoueur2().isAvantage());
	}
	
	@Test
	@DisplayName("Test gain avantage 1")
	public void testGainAvantage_1() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.setJoueur2(new Joueur());
		p.getJoueur1().setPoints(40);
		p.getJoueur2().setPoints(40);
		//WHEN
		p.AjoutPoint(p.getJoueur2());
		//THEN
		Assertions.assertTrue(p.getJoueur2().isAvantage());
		Assertions.assertFalse(p.getJoueur1().isAvantage());
	}
	
	@Test
	@DisplayName("Test gain avantage 2")
	public void testGainAvantage_2() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.setJoueur2(new Joueur());
		p.getJoueur1().setPoints(40);
		p.getJoueur2().setPoints(40);
		//WHEN
		p.AjoutPoint(p.getJoueur1());
		//THEN
		Assertions.assertTrue(p.getJoueur1().isAvantage());
		Assertions.assertFalse(p.getJoueur2().isAvantage());
	}
	
	@Test
	@DisplayName("Test perte avantage 1")
	public void testPerteAvantage_1() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.setJoueur2(new Joueur());
		p.getJoueur1().setPoints(40);
		p.getJoueur1().addAvantage();
		p.getJoueur2().setPoints(40);
		//WHEN
		p.AjoutPoint(p.getJoueur2());
		//THEN
		Assertions.assertFalse(p.getJoueur1().isAvantage());
	}
	
	@Test
	@DisplayName("Test perte avantage 2")
	public void testPerteAvantage_2() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.setJoueur2(new Joueur());
		p.getJoueur1().setPoints(40);
		p.getJoueur2().addAvantage();
		p.getJoueur2().setPoints(40);
		//WHEN
		p.AjoutPoint(p.getJoueur1());
		//THEN
		Assertions.assertFalse(p.getJoueur2().isAvantage());
	}
	
	@Test
	@DisplayName("Test gain jeu avec avantage 1")
	public void testGainJeuAvantage_1() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.setJoueur2(new Joueur());
		p.getJoueur1().setPoints(40);
		p.getJoueur1().addAvantage();
		p.getJoueur2().setPoints(40);
		//WHEN
		p.AjoutPoint(p.getJoueur1());
		//THEN
		Assertions.assertEquals(1,p.getJoueur1().getJeux());
		Assertions.assertEquals(0,p.getJoueur2().getJeux());
	}
	
	@Test
	@DisplayName("Test gain jeu avec avantage 2")
	public void testGainJeuAvantage_2() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.setJoueur2(new Joueur());
		p.getJoueur1().setPoints(40);
		p.getJoueur2().setPoints(40);
		p.getJoueur2().addAvantage();
		//WHEN
		p.AjoutPoint(p.getJoueur2());
		//THEN
		Assertions.assertEquals(0,p.getJoueur1().getJeux());
		Assertions.assertEquals(1,p.getJoueur2().getJeux());
	}
	
	@Test
	@DisplayName("Test remise à 0 points cas gain jeu avec avantage 1")
	public void testRemiseA0_1() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.setJoueur2(new Joueur());
		p.getJoueur1().setPoints(40);
		p.getJoueur1().addAvantage();
		p.getJoueur2().setPoints(40);
		//WHEN
		p.AjoutPoint(p.getJoueur1());
		//THEN
		Assertions.assertEquals(0,p.getJoueur1().getPoints());
		Assertions.assertEquals(0,p.getJoueur2().getPoints());
	}
	
	@Test
	@DisplayName("Test remise à 0 points cas gain jeu avec avantage 2")
	public void testRemiseA0_2() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.setJoueur2(new Joueur());
		p.getJoueur1().setPoints(40);
		p.getJoueur2().setPoints(40);
		p.getJoueur2().addAvantage();
		//WHEN
		p.AjoutPoint(p.getJoueur2());
		//THEN
		Assertions.assertEquals(0,p.getJoueur1().getPoints());
		Assertions.assertEquals(0,p.getJoueur2().getPoints());
	}
	
	@Test
	@DisplayName("Test gain set 1")
	public void testGainSet_1() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.getJoueur1().setPoints(40);
		p.getJoueur1().setJeux(5);
		p.setJoueur2(new Joueur());
		p.getJoueur2().setPoints(40);
		p.getJoueur2().setJeux(4);
		//WHEN
		p.AjoutPoint(p.getJoueur1());
		//THEN
		Assertions.assertEquals(1,p.getJoueur1().getSets());
		Assertions.assertEquals(0,p.getJoueur2().getSets());
	}
	
	@Test
	@DisplayName("Test gain set 2")
	public void testGainSet_2() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.getJoueur1().setPoints(40);
		p.getJoueur1().setJeux(4);
		p.setJoueur2(new Joueur());
		p.getJoueur2().setPoints(40);
		p.getJoueur2().setJeux(5);
		//WHEN
		p.AjoutPoint(p.getJoueur2());
		//THEN
		Assertions.assertEquals(0,p.getJoueur1().getSets());
		Assertions.assertEquals(1,p.getJoueur2().getSets());
	}
	
	@Test
	@DisplayName("Test gain set 3")
	public void testGainSet_3() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.getJoueur1().setPoints(40);
		p.getJoueur1().setJeux(5);
		p.setJoueur2(new Joueur());
		p.getJoueur2().setPoints(40);
		p.getJoueur2().setJeux(5);
		//WHEN
		p.AjoutPoint(p.getJoueur1());
		//THEN
		Assertions.assertEquals(0,p.getJoueur1().getSets());
		Assertions.assertEquals(0,p.getJoueur2().getSets());
	}
	
	@Test
	@DisplayName("Test gain set 4")
	public void testGainSet_4() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.getJoueur1().setPoints(40);
		p.getJoueur1().setJeux(5);
		p.setJoueur2(new Joueur());
		p.getJoueur2().setPoints(40);
		p.getJoueur2().setJeux(5);
		//WHEN
		p.AjoutPoint(p.getJoueur2());
		//THEN
		Assertions.assertEquals(0,p.getJoueur1().getSets());
		Assertions.assertEquals(0,p.getJoueur2().getSets());
	}
	
	
	@Test
	@DisplayName("Test gain set 5")
	public void testGainSet_5() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.getJoueur1().setPoints(40);
		p.getJoueur1().setJeux(7);
		p.setJoueur2(new Joueur());
		p.getJoueur2().setPoints(40);
		p.getJoueur2().setJeux(5);
		//WHEN
		p.AjoutPoint(p.getJoueur1());
		//THEN
		Assertions.assertEquals(1,p.getJoueur1().getSets());
		Assertions.assertEquals(0,p.getJoueur2().getSets());
	}
	
	
	@Test
	@DisplayName("Test gain set 6")
	public void testGainSet_6() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.getJoueur1().setPoints(40);
		p.getJoueur1().setJeux(5);
		p.setJoueur2(new Joueur());
		p.getJoueur2().setPoints(40);
		p.getJoueur2().setJeux(7);
		//WHEN
		p.AjoutPoint(p.getJoueur2());
		//THEN
		Assertions.assertEquals(0,p.getJoueur1().getSets());
		Assertions.assertEquals(1,p.getJoueur2().getSets());
	}
	
	
	@Test
	@DisplayName("Test gain set 7")
	public void testGainSet_7() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.getJoueur1().setPoints(40);
		p.getJoueur1().setJeux(4);
		p.setJoueur2(new Joueur());
		p.getJoueur2().setPoints(40);
		p.getJoueur2().setJeux(2);
		//WHEN
		p.AjoutPoint(p.getJoueur1());
		//THEN
		Assertions.assertEquals(0,p.getJoueur1().getSets());
		Assertions.assertEquals(0,p.getJoueur2().getSets());
	}
	
	
	@Test
	@DisplayName("Test gain set 8")
	public void testGainSet_8() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.getJoueur1().setPoints(40);
		p.getJoueur1().setJeux(2);
		p.setJoueur2(new Joueur());
		p.getJoueur2().setPoints(40);
		p.getJoueur2().setJeux(4);
		//WHEN
		p.AjoutPoint(p.getJoueur2());
		//THEN
		Assertions.assertEquals(0,p.getJoueur1().getSets());
		Assertions.assertEquals(0,p.getJoueur2().getSets());
	}
	
	@Test
	@DisplayName("Test initialisation Decisif")
	public void testInitialisationDecisif() {
		//GIVEN
		Partie p = new Partie();
		//WHEN
		//THEN
		Assertions.assertFalse(p.isDecisif());
	}
	
	@Test
	@DisplayName("Test passage decisif 1")
	public void testPassageDecisif_1() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.getJoueur1().setPoints(40);
		p.getJoueur1().setJeux(5);
		p.setJoueur2(new Joueur());
		p.getJoueur2().setPoints(40);
		p.getJoueur2().setJeux(6);
		//WHEN
		p.AjoutPoint(p.getJoueur1());
		//THEN
		Assertions.assertTrue(p.isDecisif());
	}
	
	@Test
	@DisplayName("Test passage decisif 2")
	public void testPassageDecisif_2() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.getJoueur1().setPoints(40);
		p.getJoueur1().setJeux(6);
		p.setJoueur2(new Joueur());
		p.getJoueur2().setPoints(40);
		p.getJoueur2().setJeux(5);
		//WHEN
		p.AjoutPoint(p.getJoueur2());
		//THEN
		Assertions.assertTrue(p.isDecisif());
	}
	
	
	@Test
	@DisplayName("Test gain point decisif 1")
	public void testGainPointDecisif_1() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.setJoueur2(new Joueur());
		p.setDecisif(true);
		//WHEN
		p.AjoutPoint(p.getJoueur1());
		//THEN
		Assertions.assertEquals(1,p.getJoueur1().getPoints());
	}
	
	@Test
	@DisplayName("Test gain point decisif 2")
	public void testGainPointDecisif_2() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.setJoueur2(new Joueur());
		p.setDecisif(true);
		//WHEN
		p.AjoutPoint(p.getJoueur2());
		//THEN
		Assertions.assertEquals(1,p.getJoueur2().getPoints());
	}
	
	@Test
	@DisplayName("Test gain point decisif 3")
	public void testGainPointDecisif_3() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.getJoueur1().setPoints(6);
		p.setJoueur2(new Joueur());
		p.getJoueur2().setPoints(5);
		p.setDecisif(true);
		//WHEN
		p.AjoutPoint(p.getJoueur1());
		//THEN
		Assertions.assertEquals(1,p.getJoueur1().getJeux());
	}
	
	@Test
	@DisplayName("Test gain point decisif 4")
	public void testGainPointDecisif_4() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.getJoueur1().setPoints(5);
		p.setJoueur2(new Joueur());
		p.getJoueur2().setPoints(6);
		p.setDecisif(true);
		//WHEN
		p.AjoutPoint(p.getJoueur2());
		//THEN
		Assertions.assertEquals(1,p.getJoueur2().getJeux());
	}
	
	@Test
	@DisplayName("Test gain point decisif 5")
	public void testGainPointDecisif_5() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.getJoueur1().setPoints(7);
		p.setJoueur2(new Joueur());
		p.getJoueur2().setPoints(7);
		p.setDecisif(true);
		//WHEN
		p.AjoutPoint(p.getJoueur1());
		//THEN
		Assertions.assertEquals(0,p.getJoueur1().getJeux());
	}
	
	@Test
	@DisplayName("Test gain point decisif 6")
	public void testGainPointDecisif_6() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.getJoueur1().setPoints(7);
		p.setJoueur2(new Joueur());
		p.getJoueur2().setPoints(7);
		p.setDecisif(true);
		//WHEN
		p.AjoutPoint(p.getJoueur2());
		//THEN
		Assertions.assertEquals(0,p.getJoueur2().getJeux());
	}
	
	
	@Test
	@DisplayName("Test gain set decisif 1")
	public void testGainSetDecisif_1() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.getJoueur1().setPoints(6);
		p.setJoueur2(new Joueur());
		p.getJoueur2().setPoints(5);
		p.setDecisif(true);
		//WHEN
		p.AjoutPoint(p.getJoueur1());
		//THEN
		Assertions.assertEquals(1,p.getJoueur1().getSets());
	}
	
	
	@Test
	@DisplayName("Test gain set decisif 2")
	public void testGainSetDecisif_2() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.getJoueur1().setPoints(6);
		p.setJoueur2(new Joueur());
		p.getJoueur2().setPoints(6);
		p.setDecisif(true);
		//WHEN
		p.AjoutPoint(p.getJoueur1());
		//THEN
		Assertions.assertEquals(0,p.getJoueur1().getSets());
	}
	
	
	@Test
	@DisplayName("Test gain set decisif 3")
	public void testGainSetDecisif_3() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.getJoueur1().setPoints(5);
		p.setJoueur2(new Joueur());
		p.getJoueur2().setPoints(6);
		p.setDecisif(true);
		//WHEN
		p.AjoutPoint(p.getJoueur2());
		//THEN
		Assertions.assertEquals(1,p.getJoueur2().getSets());
	}
	
	
	@Test
	@DisplayName("Test gain set decisif 4")
	public void testGainSetDecisif_4() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.getJoueur1().setPoints(6);
		p.setJoueur2(new Joueur());
		p.getJoueur2().setPoints(6);
		p.setDecisif(true);
		//WHEN
		p.AjoutPoint(p.getJoueur2());
		//THEN
		Assertions.assertEquals(0,p.getJoueur2().getSets());
	}
	
	
	@Test
	@DisplayName("Test gain partie 1")
	public void testGainPartie_1() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.getJoueur1().setPoints(6);
		p.getJoueur1().addSet();
		p.setJoueur2(new Joueur());
		p.getJoueur2().setPoints(5);
		p.setDecisif(true);
		//WHEN
		p.AjoutPoint(p.getJoueur1());
		//THEN
		Assertions.assertEquals(p.getJoueur1(),p.getWinner());
	}
	
	
	@Test
	@DisplayName("Test gain partie 2")
	public void testGainPartie_2() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.getJoueur1().setPoints(5);
		p.setJoueur2(new Joueur());
		p.getJoueur2().setPoints(6);
		p.setDecisif(true);
		p.getJoueur2().addSet();
		//WHEN
		p.AjoutPoint(p.getJoueur2());
		//THEN
		Assertions.assertEquals(p.getJoueur2(),p.getWinner());
	}
	
	
	@Test
	@DisplayName("Test gain partie 3")
	public void testGainPartie_3() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.getJoueur1().setPoints(6);
		p.setJoueur2(new Joueur());
		p.getJoueur2().setPoints(5);
		p.setDecisif(true);
		//WHEN
		p.AjoutPoint(p.getJoueur1());
		//THEN
		Assertions.assertNotEquals(p.getJoueur1(),p.getWinner());
	}
	
	
	@Test
	@DisplayName("Test gain partie 4")
	public void testGainPartie_4() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.getJoueur1().setPoints(5);
		p.setJoueur2(new Joueur());
		p.getJoueur2().setPoints(6);
		p.setDecisif(true);
		//WHEN
		p.AjoutPoint(p.getJoueur2());
		//THEN
		Assertions.assertNotEquals(p.getJoueur2(),p.getWinner());
	}
	
	
	@Test
	@DisplayName("Test bloquage points 1")
	public void testBloquagePts_1() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.getJoueur1().setPoints(0);
		p.setJoueur2(new Joueur());
		p.getJoueur2().setPoints(0);
		p.setDecisif(true);
		p.setWinner(p.getJoueur1());
		//WHEN
		p.AjoutPoint(p.getJoueur1());
		//THEN
		Assertions.assertEquals(0,p.getJoueur1().getPoints());
	}
	
	
	@Test
	@DisplayName("Test bloquage points 2")
	public void testBloquagePts_2() {
		//GIVEN
		Partie p = new Partie();
		p.setJoueur1(new Joueur());
		p.getJoueur1().setPoints(0);
		p.setJoueur2(new Joueur());
		p.getJoueur2().setPoints(0);
		p.setDecisif(true);
		p.setWinner(p.getJoueur1());
		//WHEN
		p.AjoutPoint(p.getJoueur2());
		//THEN
		Assertions.assertEquals(0,p.getJoueur2().getPoints());
	}
	
}
