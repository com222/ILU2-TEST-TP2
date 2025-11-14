package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private Village village;
	private Chef chef;
	private Gaulois vendeur;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur; 
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
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village); 
	}

	@Test
	void testControlLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur); 
		assertNotNull(controlLibererEtal);
	}

	@Test
	void testLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		controlPrendreEtal.prendreEtal("vendeur", "chose", 10); 
		assertNotNull(controlLibererEtal.libererEtal("vendeur"));
	}
	
	@Test
	void testLibererEtalPasVendeur() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur); 
		assertNull(controlLibererEtal.libererEtal("personne"));
	}


}
