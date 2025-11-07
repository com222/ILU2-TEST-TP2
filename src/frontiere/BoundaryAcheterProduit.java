package frontiere;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis desole " + nomAcheteur
					+ " mais il faut etre un habitant de notre village pour commencer ici.");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Quel produit voulez-vous acheter ?\n");
			String produit = Clavier.entrerChaine(question.toString());
			Gaulois[] vendeurs = controlAcheterProduit.trouverVendeurProduit(produit);
			if (vendeurs.length == 0) {
				System.out.println("Desole, personne ne vend ce produit au marche.");
			} else {
				StringBuilder question2 = new StringBuilder();

				question2.append("Chez quel commercant voulez-vous acheter des ").append(produit).append("? \n");

				for (int i = 0; i < vendeurs.length; i++) {
					question2.append(i + 1).append(" - ").append(vendeurs[i].getNom()).append("\n");
				}
				int indiceVendeur = (Clavier.entrerEntier(question2.toString())) - 1;
				String nomVendeur = vendeurs[indiceVendeur].getNom();

				StringBuilder question3 = new StringBuilder();
				question3.append(nomAcheteur).append(" se deplace jusqu'a l'etal du vendeur ").append(nomVendeur)
						.append("\n");
				question3.append("Combien de ").append(produit).append(" voulez-vous acheter ?\n");
				int quantiteAcheter = Clavier.entrerEntier(question3.toString());

				int achat = controlAcheterProduit.acheterProduit(nomVendeur, quantiteAcheter);
				if (achat == 0) {
					System.out.println(nomAcheteur + " veut acheter " + quantiteAcheter + " " + produit
							+ ", malheureseument il n'y en a plus!");
				} else if (achat < quantiteAcheter) {
					System.out.println(nomAcheteur + " veut acheter " + quantiteAcheter + " " + produit
							+ ", malheureusement " + nomVendeur + " n'en a plus que " + achat + ". " + nomAcheteur
							+ " achete tout le stock de " + nomVendeur + ".\n");
				} else {
					System.out.println(nomAcheteur + " achete " + achat + " " + produit + " à " + nomVendeur + " .\n");

				}
			}
		}
	}
}
