package morpion.gestionJeu;

import java.util.Scanner;

//gérer les input, pourra intégrer la souris dans v2.0
public class Input {
	public static int LireEntier(Scanner sc){
		String input = sc.nextLine();
		int result = -1;
		try{
			result = Integer.parseInt(input);
		} catch (NumberFormatException e){
			
		}
		
		return result;
	}
}
