package produit;

public interface IProduit {

	String getNom();

	Unite getUnite();

	String donnerDescription();

	double calculerPrix(int prix);

}