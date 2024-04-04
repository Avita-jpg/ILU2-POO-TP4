package produit;

public class Poisson extends Produit {

	private String datePeche;
	
	public Poisson(String nom, Unite unite, String datePeche) {
		super(nom, unite);
		this.datePeche = datePeche;
	}
	
	@Override
	public String donnerDescription() {
		return getNom() + " pêchés " + datePeche;
	}
}
