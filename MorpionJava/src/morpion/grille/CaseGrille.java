package morpion.grille;

import morpion.joueur.Joueur;

public class CaseGrille {
	//Variables d'intances
	private int numCase;
	private Symbole contenu; //pourra contenir des images
	
	//Constructeur
	public CaseGrille(int numCase) {
		this.numCase = numCase;
		this.contenu = null;
	}
	
	public CaseGrille(int numCase, Symbole symbole) {
		this.numCase = numCase;
		this.contenu = symbole;
	}
	
	//Méthodes
	public boolean isEmpty(){
		return this.contenu == null;
	}
	
	@Override
	public String toString(){
		if(this.contenu != null)
			return this.contenu.toString();
		else
			return Integer.toString(this.numCase);
	}

	public void setSymbole(Symbole symbole) {
		this.contenu = symbole;	
	}

	public Joueur getProprietaireSymbole() {
		if (this.contenu != null)
			return this.contenu.getProprietaire();
		else
			return null;
	}

}
