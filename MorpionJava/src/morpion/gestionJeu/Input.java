package morpion.gestionJeu;

import java.util.Scanner;

//g�rer les input, pourra int�grer la souris dans v2.0
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
