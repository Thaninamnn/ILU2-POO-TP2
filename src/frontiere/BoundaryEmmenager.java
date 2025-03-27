package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {

		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println("Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
//			int force;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					// TODO a completer
					ajouterGaulois(nomVisiteur);

					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		// TODO a completer

		int effetPotionMin;
		int effetPotionMax;
		StringBuilder question = new StringBuilder();
		question.append("Bienvenue druide" + nomVisiteur);
		question.append("Quelle est votre force");
		int forceDruide = Clavier.entrerEntier(question.toString());
		do {

			effetPotionMin = Clavier.entrerEntier("quelle est la force de potion la plus faible que vous produiser?");

			effetPotionMax = Clavier.entrerEntier("quelle est la force de potion la plus forte que vous produiser?");
			if (effetPotionMax < effetPotionMin) {
				System.out.println("Attention Druide, vous vous etes trompe entre le minimum et le maximum");

			}
		} while (effetPotionMax < effetPotionMin);
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);

	}

	private void ajouterGaulois(String nomVisiteur) {
		// TODO a completer
		int force;

		System.out.println("Bienvenu villageois" + nomVisiteur);
		force = Clavier.entrerEntier("quelle est votre force ? ");
		controlEmmenager.ajouterGaulois(nomVisiteur, force);

	}
}
