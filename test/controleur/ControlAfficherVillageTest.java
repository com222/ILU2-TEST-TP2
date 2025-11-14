package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private Chef chef;
	
	@BeforeEach 
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		// setup village 
		village = new Village("village", 10, 5);
		chef = new Chef("chef", 10, village);
		village.setChef(chef);
	}

	@Test
	void testControlAfficherVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage);
	}

	@Test
	void testDonnerNomsVillageois() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		Gaulois gaulois = new Gaulois("gaulois",1);
		village.ajouterHabitant(gaulois);
		String[] villageois = controlAfficherVillage.donnerNomsVillageois();
		assertEquals(villageois.length,2);
		assertEquals(villageois[0], "chef");
		assertEquals(villageois[1],"gaulois"); 
	}
	@Test
	void testDonnerNomsVillageoisAvecDruide() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		Druide druide = new Druide("druide",1,1,10);
		village.ajouterHabitant(druide);
		String[] villageois = controlAfficherVillage.donnerNomsVillageois();
		assertEquals(villageois.length,2);
		assertEquals(villageois[0], "chef");
		assertEquals(villageois[1],"le druide druide"); 
	}
	
	@Test
	void testDonnerNomsQueChef() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		String[] villageois = controlAfficherVillage.donnerNomsVillageois();
		assertEquals(villageois.length,1);
		assertEquals(villageois[0],"chef");
	}

	@Test
	void testDonnerNomVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertEquals(controlAfficherVillage.donnerNomVillage(),"village");
	}

	@Test
	void testDonnerNbEtals() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertEquals(controlAfficherVillage.donnerNbEtals(),5);
	}
	
}
