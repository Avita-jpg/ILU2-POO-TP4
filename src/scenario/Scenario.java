package scenario;

import personnages.Gaulois;
import produit.Poisson;
import produit.Produit;
import produit.Sanglier;
import village.IVillage;
import villagegaulois.DepenseMarchand;
import villagegaulois.IEtal;
import villagegaulois.Etal;

public class Scenario {

	public static void main(String[] args) {
		
		// debut classe Village
		class Village implements IVillage {
			IEtal[] marche; //????
			int nbEtalsOccupes = 0;
			
			public Village(int nbEtalsMax) {
				marche = new IEtal[nbEtalsMax];
			}
			
			@Override
			public <P extends Produit> boolean installerVendeur(villagegaulois.Etal<P> etal, Gaulois vendeur,
					P[] produit, int prix) {
				if (nbEtalsOccupes == marche.length)
					return false;

				etal.installerVendeur(vendeur, produit, prix);
				marche[nbEtalsOccupes] = etal;
				nbEtalsOccupes++;
				return true;
			}

			@Override
			public DepenseMarchand[] acheterProduit(String produit, int quantiteSouhaitee) {
				DepenseMarchand[] depense = new DepenseMarchand[nbEtalsOccupes];
				int numEtal = 0;
				int quantiteAchetee = 0;
				while (quantiteAchetee < quantiteSouhaitee && numEtal < nbEtalsOccupes) {
					int quantiteAAcheter = quantiteSouhaitee - quantiteAchetee;
					int qteDispo = marche[numEtal].contientProduit(produit, quantiteAAcheter);
					if (qteDispo <= quantiteAAcheter) {
						quantiteAAcheter = qteDispo;
					}
					double prixPaye = marche[numEtal].acheterProduit(quantiteAAcheter);
					quantiteAchetee += quantiteAAcheter;
					depense[numEtal] = new DepenseMarchand(marche[numEtal].getVendeur(), quantiteAAcheter, produit, prixPaye);
					numEtal++;
				}
				return depense;
			}
			@Override
			public String toString() {
				StringBuilder chaine = new StringBuilder();
				for (int i = 0; i < marche.length; i++) {
					chaine.append(marche[i].etatEtal());
					chaine.append("\n");
				}
				return chaine.toString();
			}
			
			
			
		}
		
		Village village = new Village(3);
		
		// fin

		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Astérix", 6);

		Etal<Sanglier> etalSanglierObelix = new Etal<>();
		Etal<Sanglier> etalSanglierAsterix = new Etal<>();
		Etal<Poisson> etalPoisson = new Etal<>();

		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);

		Sanglier[] sangliersObelix = { sanglier1, sanglier2 };
		Sanglier[] sangliersAsterix = { sanglier3, sanglier4 };

		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = { poisson1 };

		village.installerVendeur(etalSanglierAsterix, asterix, sangliersAsterix, 8);
		village.installerVendeur(etalSanglierObelix, obelix, sangliersObelix, 10);
		village.installerVendeur(etalPoisson, ordralfabetix, poissons, 5);

		System.out.println(village);

		DepenseMarchand[] depense = village.acheterProduit("sanglier", 3);

		for (int i = 0; i < depense.length && depense[i] != null; i++) {
			System.out.println(depense[i]);
		}

		System.out.println(village);

	}

}
