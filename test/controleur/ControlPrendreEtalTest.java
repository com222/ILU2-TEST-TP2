package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village;
	private Chef chef;
	private ControlVerifierIdentite controlVerifierIdentite;
	
	@BeforeEach 
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		//setup village
		village = new Village("village", 10, 5);
		chef = new Chef("chef", 10, village);
		village.setChef(chef);
		//setup vendeur 
		Gaulois vendeur = new Gaulois("vendeur",10);
		village.ajouterHabitant(vendeur);
	}

	@Test
	void testControlPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite,village);
		assertNotNull(controlPrendreEtal, "Constructeur ne renvoie pas null");
	}

	@Test
	void testResteEtals() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite,village);
		assertTrue(controlPrendreEtal.resteEtals());
	}
	
	@Test
	void testNeRestePasEtals() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite,village);
		for (int i = 0; i < 5; i++) {
			controlPrendreEtal.prendreEtal("vendeur", "choses", 5);
		}
		assertFalse(controlPrendreEtal.resteEtals());
	}

	
	@Test
	void testPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite,village);
		assertEquals(controlPrendreEtal.prendreEtal("vendeur", "choses", 5), 1);
	}
	
	@Test
	void testPasPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite,village);
		for (int i = 0; i < 5; i++) {
			controlPrendreEtal.prendreEtal("vendeur", "choses", 5);
		}
		assertEquals(controlPrendreEtal.prendreEtal("vendeur", "choses", 5), -1);
	}

}
