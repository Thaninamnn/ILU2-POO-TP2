package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		// TODO a completer
		boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if (! nomVendeurConnu) {

			System.out.println("Je suis desolee " + nomVendeur
					+ " mais il faut etre un habitant de notre village pour commencer ici ");

		} else {
			System.out.println("Bonjour" + nomVendeur + "je vais regarder si je peux vous trouver un etal");
			boolean etalDisponible = controlPrendreEtal.resteEtals();
			if (!etalDisponible) {
				System.out.println("desolee" + nomVendeur + "je n'ai plus d'etal qui ne soit pas occupe");
			} else {

				installerVendeur(nomVendeur);
			}
		}

	}

	private void installerVendeur(String nomVendeur) {
		// TODO a completer
		StringBuilder question = new StringBuilder();
		System.out.println("C'est parfait, il me reste un etal pour vous !\n");
		System.out.println("Il me faudrait quelques renseignements \n");
		System.out.println("quels produit souhaitez vous vendre ?");
		String produit = Clavier.entrerChaine("");
		
		System.out.print("combien souhaitez vous en vendre ?");
		int nbProduit = Clavier.entrerEntier("");
		
		
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if(numeroEtal!=-1) {
			
			System.out.println("le vendeur"+nomVendeur+"s'est installer a l'etal numero:"+numeroEtal);
		}

	}
}
