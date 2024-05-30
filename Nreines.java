
public class Nreines {

	public static void main(String[] args) {

		Echiquier echiquier = new Echiquier (4);
		
		
		 
		if (ResoudreNReine(echiquier, 0)) {
            echiquier.printEchiquier();
        } else {
            System.out.println("Aucune solution n'existe pour " + 2 + " reines.");
        }
		
	 

	}

	
	public static boolean  ResoudreNReine( Echiquier e  , int col )
	{
		int taille = e.getTaille();
		
		//si toutes les reines sont positionées
		if(col >= taille) {
			return true;
		}
		
		// placer une reine dans chaque ligne de la colonne actuelle
        for (int i = 0; i < taille; i++) {
            if (e.EstPositionValide(i, col)) {
                e.placerReine(i, col);
                //récursivement pour placer les reines dans les colonnes col+1
                if (ResoudreNReine(e, col + 1)) {  
                    return true;
                }
               // Si positionner la reine ne mène pas à une solution, l'enlever (backtracking)
                e.enleverReine(i, col);
            } 
	} 
	
      //Si la reine ne peut pas être positionée dans aucune ligne de cette colonne
        return false; 
}
}
