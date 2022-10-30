package fr.DVD;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import composant.Panier;
/**
 * @author Imane
 * Classe qui regroupe l'ensemble des tests
 */
public class TestFichier {

	@Test
	/**
	 * test de bon chargement du fichier input
	 *
	 */
	public void lectureFichierTest() throws FileNotFoundException {
		Panier panier= new Panier("src/test/resources/testsagadiff");
		assertEquals("Back to the Future 1",panier.getItem().get(0));
		assertEquals("Back to the Future 2",panier.getItem().get(1));
		assertEquals("Back to the Future 3",panier.getItem().get(2));
		assertEquals("La chevre",panier.getItem().get(3));
	}
	@Test
	/**
	 * test des 2 fonctions nbDVDSaga() et nbDVDSagaDiff() sur fichier avec plusieurs DVD de la saga
	 * @throws FileNotFoundException 
	 */
	public void nbDVDSagaTest() throws FileNotFoundException {
		Panier panier= new Panier("src/test/resources/testsaga4");
		assertEquals(4,panier.nbDVDSaga());
		assertEquals(3,panier.nbDVDSagaDiff());
	}
	@Test
	/**
	 * test des 2 fonctions nbDVDSaga() et nbDVDSagaDiff() sur fichier avec aucun DVD de la saga
	 * @throws FileNotFoundException 
	 */
	public void nbDVDSansSagaTest() throws FileNotFoundException {
		Panier panier= new Panier("src/test/resources/testnosaga");
		assertEquals(0,panier.nbDVDSaga());
		assertEquals(0,panier.nbDVDSagaDiff());
	}
	@Test
	/**
	 * test du calcul du prix panier sans DVD de la saga
	 * @throws FileNotFoundException 
	 */
	public void prixPanier1Test() throws FileNotFoundException {
		Panier panier= new Panier("src/test/resources/testnosaga");
		assertEquals(20,panier.prix(),0);
	}
	@Test
	/**
	 * test du calcul du prix panier avec que des DVD saga 
	 * @throws FileNotFoundException 
	 */
	public void prixPanier2Test() throws FileNotFoundException {
		Panier panier= new Panier("src/test/resources/testsaga");
		assertEquals(36,panier.prix(),0);
	}
	@Test
	/**
	 * test du calcul du prix panier avec un seul DVD 
	 * @throws FileNotFoundException 
	 */
	public void prixPanier3Test() throws FileNotFoundException {  //
		Panier panier= new Panier("src/test/resources/testsaga1");
		assertEquals(15,panier.prix(),0);
	}
	@Test
	/**
	 * test du calcul du prix panier avec 2 DVD de la saga 
	 * @throws FileNotFoundException 
	 */
	public void prixPanier4Test() throws FileNotFoundException {
		Panier panier= new Panier("src/test/resources/testsaga2");
		assertEquals(27,panier.prix(),0);
	}
	@Test
	/**
	 * test du calcul du prix panier avec meme DVD de la saga 
	 * @throws FileNotFoundException 
	 */
	public void prixPanier5Test() throws FileNotFoundException {
		Panier panier= new Panier("src/test/resources/testsaga4");
		assertEquals(48,panier.prix(),0);
	}
	@Test
	/**
	 * test du calcul du prix panier avec autres DVD que la saga 
	 * @throws FileNotFoundException 
	 */
	public void prixPanier6Test() throws FileNotFoundException {
		Panier panier= new Panier("src/test/resources/testsagadiff");
		assertEquals(56,panier.prix(),0);
	}
	@Test
	/**
	 * test du calcul du prix panier vide
	 * @throws FileNotFoundException 
	 */
	public void prixPanierVideTest() throws FileNotFoundException {
		Panier panier= new Panier("src/test/resources/testfichiervide");
		assertEquals(0,panier.prix(),0);
	}
}
