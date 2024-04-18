package produit;

public class Poisson extends Produit {

	private String datePeche;
	
	public Poisson(String datePeche) {
		super("poisson", Unite.PARPIECE);
		this.datePeche = datePeche;
	}
	

	@Override
	public String donnerDescription() {
		return getNom() + " p�ch�s " + datePeche;
	}


	@Override
	public double calculerPrix(int prix) {
		// puisque le poisson est vendu par pièce, le prix ne change pas
		return prix;
	}
}
