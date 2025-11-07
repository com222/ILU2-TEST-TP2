package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Village village;
	private Chef chef;

	@BeforeEach 
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("village", 10, 5);
		chef = new Chef("chef", 10, village);
		village.setChef(chef);
	}
	
	@Test
	void testControlAcheterProduit() {
		fail("Not yet implemented");
	}

	@Test
	void testVerifierIdentite() {
		fail("Not yet implemented");
	}

	@Test
	void testTrouverVendeurProduit() {
		fail("Not yet implemented");
	}

	@Test
	void testAcheterProduit() {
		fail("Not yet implemented");
	}

}
