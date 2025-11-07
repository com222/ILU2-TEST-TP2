package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis desole " + nomVendeur
					+ " mais il faut etre un habitant de notre village pour commencer ici.\n");
		} else {
			System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouvez un etal.\n");
			if (!controlPrendreEtal.resteEtals()) {
				System.out.println("Desole " + nomVendeur + " je n'ai plus d'etal qui ne soit pas occupe.\n");
			} else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder question = new StringBuilder();
		question.append("C'est parfait, il me reste un etal pour vous!\n Il me faudrait quelques renseignements. \n");
		question.append("Quel produits souhaitez-vous vendre ?\n");
		String produit = Clavier.entrerChaine(question.toString());
		StringBuilder question2 = new StringBuilder();
		question2.append("Combien souhaitez-vous en vendre ?\n");
		int nbrProduit = Clavier.entrerEntier(question2.toString());

		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbrProduit);
		if (numeroEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est installe a l'etal n'" + numeroEtal);
		}
	}
}
