package morpion.joueur;

import morpion.grille.Symbole;

public class Joueur {
	//Variables d'instances
	private int numJoueur;
	private Symbole symbole;
	
	//Constructeur
	public Joueur(int numJoueur, char c) {
		this.numJoueur = numJoueur;
		this.symbole = new Symbole(c, this);
	}
	
	//Méthodes
	@Override
	public boolean equals(Object o){
		if(o == null)
			return false;
		if(o instanceof Joueur){
			Joueur joueur = (Joueur)o;
			return joueur.numJoueur == this.numJoueur;
		}else
			return false;
	}
	
	public int getNumJoueur() {
		return this.numJoueur;
	}

	public Symbole getSymbole() {
		return this.symbole;
	}

}
