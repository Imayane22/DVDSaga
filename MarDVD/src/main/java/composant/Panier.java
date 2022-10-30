package composant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Imane
 * Creation de notre panier avec tous les DVD
 * Avec un method prix() qui retourne le prix de notre panier	
 */

public class Panier {
	private List<String> item;

	/**
	 * @return the item qui est la liste des titres de DVD
	 */
	public List<String> getItem() {
		return item;
	}

	/**
	 * @param item the item to set, prend en parametre une liste de DVD
	 */
	public void setItem(List<String> item) {
		this.item = item;
	}
	/**
	 * ajouter un DVD
	 */
	public void addItem(String item) {
		this.item.add(item);
	}
	/**
	 * Creer un panier a partir du fichier input
	 * @throws FileNotFoundException 
	 */
	public Panier (String path) throws FileNotFoundException {
		this.item=new ArrayList<String> ();
		File file = new File(path);
		Scanner scanner = new Scanner(file);
		while(scanner.hasNext())	
		{
			this.addItem(scanner.nextLine());
		}
		scanner.close();
	}
	/**
	 * Retourner nombre DVD saga
	 */
	public long nbDVDSaga ()
	{
		return this.getItem().stream().filter(titre->titre.startsWith("Back to the Future")).count();
	}
	/**
	 * Retourner nombre DVD saga differents
	 */
	public long nbDVDSagaDiff ()
	{
		return this.getItem().stream().filter(titre->titre.startsWith("Back to the Future")).distinct().count();
	}
	/**
	 * Retourner prix du panier ou 0 si panier vide
	 */
	public double prix()
	{
		if(this.item==null)
			return 0;
		else
		{
			long nbDVDsaga=this.nbDVDSaga();
			long nbDVDsagaDiff=this.nbDVDSagaDiff();
			long autreDVD=this.getItem().size()-nbDVDsaga;
			double promotion=0;
			if(nbDVDsagaDiff==2)
				promotion= 0.1;
			if(nbDVDsagaDiff>2)
				promotion=0.2;
			return autreDVD*20+15*nbDVDsaga-promotion*15*nbDVDsaga;
		}
	}
}
