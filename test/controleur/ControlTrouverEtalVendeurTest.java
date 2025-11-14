package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	private Village village;
	private Chef chef;
	private Gaulois vendeur;
	private ControlPrendreEtal controlPrendreEtal; 
	private ControlVerifierIdentite controlVerifierIdentite;
	
	@BeforeEach 
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		// setup village 
		village = new Village("village", 10, 5);
		chef = new Chef("chef", 10, village);
		village.setChef(chef);
		// setup vendeur
		vendeur = new Gaulois("vendeur",10);
		village.ajouterHabitant(vendeur);
		// setup controleur 
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village); 
	}

	@Test
	void testControlTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		assertNotNull(controlTrouverEtalVendeur,"constructeur ne renvoie pas null"); 
	}

	@Test
	void testTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlPrendreEtal.prendreEtal("vendeur", "chose", 10); 
		assertNotNull(controlTrouverEtalVendeur.trouverEtalVendeur("vendeur"));
	}

	@Test
	void testPasTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("personne"));
	}
}
