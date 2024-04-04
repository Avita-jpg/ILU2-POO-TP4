package produit;

public class Sanglier extends Produit {
	
	private int poids;
	private String nomChasseur;
	
	public Sanglier(String nom, Unite unite, int poids, String nomChasseur) {
		super(nom, unite);
		this.poids = poids;
		this.nomChasseur = nomChasseur;
	}

	@Override
	public String donnerDescription() {
		return getNom() + " de " + poids + " " + getUnite().toString() + " chassé par " + nomChasseur + ".";
	}

}
