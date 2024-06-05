
public class Nreines {

	public static void main(String[] args) {

		int tailleEchiquier = 4;
		Echiquier echiquier = new Echiquier(tailleEchiquier);

		// Vérification des cas où il n'y a pas de solution ou de cas trivials
		if (tailleEchiquier == 0) {
			System.out.println("Aucune reine à placer sur un échiquier de taille 0.");
		} else if (ResoudreNReine(echiquier, 0)) {
			echiquier.printEchiquier();
		} else {
			//exemple 2 ou 3
			System.out.println("Aucune solution n'existe pour " + tailleEchiquier + " reines.");
		}

	}

	public static boolean ResoudreNReine(Echiquier e, int col) {
		int taille = e.getTaille();

		// si toutes les reines sont positionées
		if (col >= taille) {
			return true;
		}

		// placer une reine dans chaque ligne de la colonne actuelle
		for (int i = 0; i < taille; i++) {
			if (e.EstPositionValide(i, col)) {
				e.placerReine(i, col);
				// récursivement pour placer les reines dans les colonnes col+1
				if (ResoudreNReine(e, col + 1)) {
					return true;
				}
				// Si positionner la reine ne mène pas à une solution, l'enlever (backtracking)
				e.enleverReine(i, col);
			}
		}

		// Si la reine ne peut pas être positionée dans aucune ligne de cette colonne
		return false;
	}
}
