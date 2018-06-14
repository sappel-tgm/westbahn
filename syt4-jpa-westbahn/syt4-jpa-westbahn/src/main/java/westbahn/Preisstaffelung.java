package westbahn;

public class Preisstaffelung {
	private static Long serialVersionUID;

	private float grossGepaeck = (float) 1.02;

	private float fahrrad = (float) 1.05;

	private int zeitkarteWoche = 8;

	private int zeitkarteMonat = 25;

	private int zeitkarteJahr = 250;

	private static Preisstaffelung instance;

	public static Preisstaffelung getInstance() {
		return Preisstaffelung.instance;
	}

	public Preisstaffelung(){}

	public static Long getSerialVersionUID() {
		return serialVersionUID;
	}

	public static void setSerialVersionUID(Long serialVersionUID) {
		Preisstaffelung.serialVersionUID = serialVersionUID;
	}

	public float getGrossGepaeck() {
		return grossGepaeck;
	}

	public void setGrossGepaeck(float grossGepaeck) {
		this.grossGepaeck = grossGepaeck;
	}

	public float getFahrrad() {
		return fahrrad;
	}

	public void setFahrrad(float fahrrad) {
		this.fahrrad = fahrrad;
	}

	public int getZeitkarteWoche() {
		return zeitkarteWoche;
	}

	public void setZeitkarteWoche(int zeitkarteWoche) {
		this.zeitkarteWoche = zeitkarteWoche;
	}

	public int getZeitkarteMonat() {
		return zeitkarteMonat;
	}

	public void setZeitkarteMonat(int zeitkarteMonat) {
		this.zeitkarteMonat = zeitkarteMonat;
	}

	public int getZeitkarteJahr() {
		return zeitkarteJahr;
	}

	public void setZeitkarteJahr(int zeitkarteJahr) {
		this.zeitkarteJahr = zeitkarteJahr;
	}

	public static void setInstance(Preisstaffelung instance) {
		Preisstaffelung.instance = instance;
	}
	
	

}
