package morpion.gestionJeu;

import java.util.Scanner;

import morpion.grille.Grille;
import morpion.joueur.Joueur;

//pourra ensuite être runnable pour jouer sur 2 pc (v3.0)
public class Jeu {
	
	//Variables d'instances
	private Grille grille;
	private Joueur joueur1, joueur2;
	private Joueur joueurActif;
	
	//Constructeur
	public Jeu(){
		this.grille = new Grille();
		this.joueur1 = new Joueur (1, 'X');
		this.joueur2 = new Joueur (2, 'O');
	}
	
	//Methodes
	private void changerTour(){

		if (this.joueurActif.equals(this.joueur1))
			this.joueurActif = this.joueur2;
		else
			this.joueurActif = this.joueur1;
	}
	
	//ajouter un traitement overshooté pour les développeurs if choix = 777... droit d'écraser le symbole de l'autre
	private int getJoueurInput(Scanner sc){
		int input = -1;
		
		while(true){
			System.out.print("Joueur"+this.joueurActif.getNumJoueur()+": ");
			input = Input.LireEntier(sc);
			
			if (1 <= input && input <=9)
				return input;
		}
	}
	
	public void lancer(){
		this.joueurActif = this.joueur1;
		Scanner sc = new Scanner(System.in);
		
		
		
		while (true){
			this.afficherGrille(); //normalement grille.toString()
			
			System.out.println(this.grille.toString());
			
			int input = getJoueurInput(sc)-1;
			this.grille.setSymbole(input, this.joueurActif.getSymbole());
			
			if (this.grille.getGagnant() != null){
				this.afficherGrille();
				//si il y a un gagnant
				System.out.println("joueur"+this.grille.getGagnant().getNumJoueur()+" a gagné");
				break;
			} else if (this.grille.estPleine()){
				// si il y a match null
				this.afficherGrille();
				System.out.println("Match null !");
				break;
			}
			
			this.changerTour();
		}
		
		sc.close();
	}
	private void afficherGrille(){
		this.grille.afficher(); //quand toString sera codé grille.toString();
	}
	
	public void reinitialiser(){
		this.grille.initGrille();
	}
}
