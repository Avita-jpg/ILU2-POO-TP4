package produit;

public enum Unite {
	LITRE("L"), GRAMME("g"), KILOGRAMME("kg"), CENTILITRE("cL"), MILILITRE("mL"), PARPIECE("");
	
	private String symbole;
	
	private Unite(String symbole) {
		this.symbole = symbole;
	}
	@Override
	public String toString() {
		return symbole;
	}
}
