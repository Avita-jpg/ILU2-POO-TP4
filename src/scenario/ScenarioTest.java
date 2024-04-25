package scenario;

import personnages.Gaulois;
import produit.Poisson;
import produit.Sanglier;
import villagegaulois.Etal;
import villagegaulois.IEtal;


public class ScenarioTest {
	public static void main(String[] args) {

		Gaulois ordralfabetix = new Gaulois("Ordralfab�tix",9);
		Gaulois obelix = new Gaulois("Ob�lix",20);
		Gaulois asterix = new Gaulois("Asterix", 6);
		
		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);
		Sanglier[] sangliersObelix = {sanglier1, sanglier2};
		Sanglier[] sangliersAsterix = {sanglier3, sanglier4};
		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = {poisson1};
		
		
		IEtal[] marche = new IEtal[3];
		Etal<Sanglier> etalSanglier1 = new Etal<>();
		Etal<Sanglier> etalSanglier2 = new Etal<>();
		
		Etal<Poisson> etalPoisson1 = new Etal<>();
		
		marche[0] = etalSanglier1;
		marche[1] = etalSanglier2;
		marche[2] = etalPoisson1;
		
		etalSanglier1.installerVendeur(asterix, sangliersAsterix, 10);
		etalSanglier2.installerVendeur(obelix, sangliersObelix, 8);
		etalPoisson1.installerVendeur(ordralfabetix, poissons, 7);
		
		System.out.println("ETAT MARCHE");
		for (int i = 0; i < marche.length; i++) {
			System.out.println(marche[i].etatEtal());
		}
		
//		int quantiteSouhaitee = 3;
//		int quantiteAcheter = quantiteSouhaitee;
//		int etal = 0;
//		while (quantiteAcheter > 0 && etal < marche.length) {
//			int qte = marche[etal].contientProduit("sanglier", quantiteAcheter);
//			if (qte > quantiteAcheter) {
//				qte = quantiteAcheter;
//			}
//			double prixPaye = marche[etal].acheterProduit(qte);
//			quantiteAcheter-=qte;
//			System.out.println("A l'étal "+etal+" je paye "+prixPaye+" sous.");
//			
//			etal++;
//		}
		
		int quantiteSouhaitee = 3;
		int numEtal = 0;
		int quantiteAchetee = 0;
		while (quantiteAchetee < quantiteSouhaitee && numEtal < marche.length) {
			int quantiteAAcheter = quantiteSouhaitee - quantiteAchetee;
			int qteDispo = marche[numEtal].contientProduit("sanglier", quantiteAAcheter);
			if (qteDispo <= quantiteAAcheter) {
				quantiteAAcheter = qteDispo;
			}
			double prixPaye = marche[numEtal].acheterProduit(quantiteAAcheter);
			quantiteAchetee += quantiteAAcheter;
			System.out.println("A l'étal "+numEtal+" je paye "+prixPaye+" sous.");
			numEtal++;
		}
		
		System.out.println("Je voulais "+quantiteSouhaitee+" sangliers, j'en ai acheté "+ (quantiteAchetee));
		
		System.out.println("ETAT MARCHE");
		for (int i = 0; i < marche.length; i++) {
			System.out.println(marche[i].etatEtal());
		}
	}
	
}
