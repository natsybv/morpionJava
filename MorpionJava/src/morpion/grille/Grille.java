package morpion.grille;

import morpion.joueur.Joueur;


public class Grille {
	//Variables d'instances
	final static int TAILLE = 9;
	private CaseGrille[] grille;
	
	//possibilité à l'avenir de sauvegarder une partie en cours
	//Constructeur
	public Grille(){
		this.grille = new CaseGrille[TAILLE];
		this.initGrille();
	}
	
	//Methodes
	private Joueur ligneGagnante(){
		Joueur gagnant = null;
		
		for(int i=0; i < 3; ++i){
			Joueur joueur = this.getProprietaireSymbole(i*3);
			
			if (joueur == null)
				continue;
			
			if(joueur != null && joueur.equals(getProprietaireSymbole(i*3+1))){
				if(joueur.equals(this.getProprietaireSymbole(i*3+2))){
					gagnant = joueur;
					return gagnant;
				}
			}
		}
		
		return gagnant;
	}
	
	private Joueur colonneGagnante(){
		Joueur gagnant = null;
		
		for(int i=0; i < 3; ++i){
			Joueur joueur = this.getProprietaireSymbole(i);
			
			if (joueur == null)
				continue;
			
			if(joueur != null && joueur.equals(getProprietaireSymbole(i+3*1))){
				if(joueur.equals(this.getProprietaireSymbole(i+3*2))){
					gagnant = joueur;
					return gagnant;
				}
			}
		}
		
		return gagnant;
	}
	
	public Joueur getGagnant(){
		Joueur gagnant = null;
		
		gagnant = ligneGagnante();
		if (gagnant != null)
			return gagnant;
		
		gagnant = colonneGagnante();
		if (gagnant != null)
			return gagnant;
		
		Joueur joueur = this.getProprietaireSymbole(0);
		if(joueur != null && joueur.equals(getProprietaireSymbole(4))){
			if(joueur.equals(this.getProprietaireSymbole(8))){
				return joueur;
			}
		}
		
		joueur = this.getProprietaireSymbole(2);
		if(joueur != null && joueur.equals(getProprietaireSymbole(4))){
			if(joueur.equals(this.getProprietaireSymbole(6))){
				return joueur;
			}
		}
		
		return gagnant;
	}
	public boolean estPleine(){
		for (int i = 0; i < this.grille.length; ++i){
			if(this.grille[i].isEmpty())
				return false;
		}
		return true;
		
	}
		
	public void initGrille(){
		for (int i = 0; i < this.grille.length; ++i){
			if(this.grille[i] == null)
				this.grille[i] = new CaseGrille(i+1);
			else
				this.grille[i].setSymbole(null);
		}
	}
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder("***").append(System.lineSeparator());
		//fonction à faire pour remplacer afficher.
		return builder.toString();
	}
	
	public void afficher(){
		
			System.out.println("* * * * * * * * * * * * *\n*       *       *       *");
			System.out.println("*   "+this.grille[0]+"   *   "+this.grille[1]+"   *   "+this.grille[2]+"   *");
			System.out.println("*       *       *       *\n* * * * * * * * * * * * *\n*       *       *       *");
			System.out.println("*   "+this.grille[3]+"   *   "+this.grille[4]+"   *   "+this.grille[5]+"   *");
			System.out.println("*       *       *       *\n* * * * * * * * * * * * *\n*       *       *       *");
			System.out.println("*   "+this.grille[6]+"   *   "+this.grille[7]+"   *   "+this.grille[8]+"   *");
			System.out.println("*       *       *       *\n* * * * * * * * * * * * *\n");
	}
	
	public Joueur getProprietaireSymbole(int numCase){
		return this.grille[numCase].getProprietaireSymbole();
	}
	
	public void setSymbole(int numCase, Symbole symbole){
		this.grille[numCase].setSymbole(symbole);
	}
}
