package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Village village;
	private Chef chef;
	private Gaulois vendeur;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite; 
	private ControlPrendreEtal controlPrendreEtal;
	
	@BeforeEach 
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		// setup village 
		village = new Village("village", 10, 5);
		chef = new Chef("chef", 10, village);
		village.setChef(chef);
		// setup controleur 
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		// setup vendeur
		vendeur = new Gaulois("vendeur",10);
		village.ajouterHabitant(vendeur);
		controlPrendreEtal.prendreEtal("vendeur", "produit", 10);
	}


	@Test
	void testControlAcheterProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		assertNotNull(controlAcheterProduit);
	}


	@Test
	void testTrouverVendeurProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		Gaulois[] vendeurs = controlAcheterProduit.trouverVendeurProduit("produit");
		assertEquals(vendeurs.length, 1);
		assertEquals(vendeurs[0].getNom(),"vendeur");
	}
	
	@Test
	void testPasTrouverVendeurProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		Gaulois[] vendeurs = controlAcheterProduit.trouverVendeurProduit("rien");
		assertNull(vendeurs);
	}

	@Test
	void testAcheterProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		int nbrAchat = controlAcheterProduit.acheterProduit("vendeur", 1);
		assertEquals(nbrAchat,1); 
	}
	
	@Test
	void testAcheterTousLesProduits() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		int nbrAchat = controlAcheterProduit.acheterProduit("vendeur", 10);
		assertEquals(nbrAchat,10); 
	}
	
	@Test
	void testAcheterProduitsVide() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		controlAcheterProduit.acheterProduit("vendeur", 10);
		int nbrAchat = controlAcheterProduit.acheterProduit("vendeur", 1);
		assertEquals(nbrAchat,0); 
	}
	
	@Test
	void testAcheterPasAssezProduits() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		controlAcheterProduit.acheterProduit("vendeur", 6);
		int nbrAchat = controlAcheterProduit.acheterProduit("vendeur", 6);
		assertEquals(nbrAchat,4); 
	}

}
