package morpion.grille;

import morpion.joueur.Joueur;

public class Symbole {
	//Variables d'instances
	private char SymboleChar;
	private Joueur proprietaire;
	
	//Constructeur
	public Symbole(char c, Joueur joueur) {
		this.SymboleChar = c;
		this.proprietaire = proprietaire;
	}
	
	//Methodes
	@Override
	public String toString(){
		return Character.toString(this.SymboleChar);
	}
	public Joueur getProprietaire() {
		// return Fouiny baby lol
		return this.proprietaire;
	}

}
