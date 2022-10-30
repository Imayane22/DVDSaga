package application;

import java.io.FileNotFoundException;

import composant.Panier;

/**
 * 
 * @author Imane
 * Classe principale de notre programme qui prend en param le nom de fichier panier
 *
 */
public class Start {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Panier panier= new Panier(args[0]);
		System.out.println("Le prix de votre panier est: "+panier.prix());
	}

}
