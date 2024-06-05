import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
public class Echiquier {

		private static  int taille;
		
		boolean[][] tableau;
		
		
		Echiquier(int t )
		{
			taille=t;
			tableau= new boolean[taille][taille];
			for (int i=0;i<taille;i++)
				for (int j=0;j<taille;j++)
					tableau[i][j]=false;
		}
		
		//En principe, comme les reines sont ajout�es une a une, il n'est pas n�c�ssaire de v�rifier tous le  tableau, mais il n'est pas faux de le faire. 
		boolean EstPositionValide(int ligne, int colonne)
		{
			
			//v�rifier la ligne
			for(int i=0;i<taille;i++)
			{
				if(tableau[ligne][i]==true)
					return false;
			}
			
			//v�rifier la colonne
			for(int i=0;i<taille;i++)
			{
				if(tableau[i][colonne]==true)
					return false;
			}
			
			//v�rifier la diagonale  gauche croissante
	        for (int i = ligne,  j = colonne; i >= 0 && j >= 0; i--, j--)
	            if (tableau[i][j] == true)
	                return false;
	        
			//v�rifier la diagonale  gauche d�croissante
	        for (int i = ligne,  j = colonne; i < taille && j < taille; i++, j++)
	            if (tableau[i][j] == true)
	                return false;
	        
			//v�rifier la diagonale  droite croissante
	        for (int i = ligne,  j = colonne; i >= 0 && j < taille; i--, j++)
	            if (tableau[i][j] == true)
	                return false;
	        
			//v�rifier la diagonale  droite d�croissante
		for (int i = ligne,  j = colonne; i < taille &&  j >= 0; i++, j--)
	            if (tableau[i][j] == true)
	                return false;
			
			return true;
		}
		
		
		int getTaille()
		{
			return taille; 
		}
		
		
		void placerReine(int ligne, int colone)
		{
			tableau[ligne][colone]=true; 
		}
		
		void enleverReine(int ligne, int colone)
		{
			tableau[ligne][colone]=false; 
		}
		
	   
	void printEchiquierTexte()// Pour afficher l'�chiquier en version texte
		{
			for (int i=0;i<taille;i++)
			{
				for (int j=0;j<taille;j++)
				{	
					if (tableau[i][j]==false)
						System.out.print("0");
					else
						System.out.print("X");
				}
				System.out.println();
			}
		}


        void printEchiquier()//Pour afficher l'�chiquier en version GUI.
        {
            new ChessGUI(tableau);
        }
        private static class ChessGUI extends JFrame {
       
            private boolean[][] tableau;
            private int taille;
       
            public ChessGUI(boolean[][] tableau) {
                this.tableau = tableau;
                this.taille = tableau.length;
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setTitle("�chiquier");
                setSize(800, 800);
                setLocationRelativeTo(null);
                setLayout(new GridLayout(taille, taille));
                afficherEchiquier();
            }
       
            private void afficherEchiquier() {
                Color beige = new Color(245, 245, 220);
                Color brun = new Color(139, 69, 19);
       
                for (int i = 0; i < taille; i++) {
                    for (int j = 0; j < taille; j++) {
                        JPanel casePanel = new JPanel();
                        casePanel.setLayout(new BorderLayout());
       
                        if ((i + j) % 2 == 0) {
                            casePanel.setBackground(beige);
                        } else {
                            casePanel.setBackground(brun);
                        }
       
                        if (tableau[i][j]) {
                            JLabel reineLabel = new JLabel();
                            ImageIcon reineIcon = new ImageIcon(getClass().getResource("queen.png"));
                            reineLabel.setIcon(new ImageIcon(reineIcon.getImage().getScaledInstance(800/taille, 800/taille, Image.SCALE_SMOOTH)));
                            reineLabel.setHorizontalAlignment(SwingConstants.CENTER);
                            reineLabel.setVerticalAlignment(SwingConstants.CENTER);
                            casePanel.add(reineLabel, BorderLayout.CENTER);
                        }
       
                        add(casePanel);
                    }
                }
                setVisible(true);
            }
        }
       

	
}
