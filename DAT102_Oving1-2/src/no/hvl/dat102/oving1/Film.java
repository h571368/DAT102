package no.hvl.dat102.oving1;

public class Film {

	
	private int nummer;
	private String filmskaper;
	private String tittel;
	private int aar;
	private String filmselskap;
	private Sjanger sjanger;
	
	public Film() {	
		this(0,"","",0,"",null);
	}

	public Film(int nummer, String filmskaper, String tittel, int aar, String filmselskap, Sjanger sjanger) {
		this.nummer = nummer;
		this.filmskaper = filmskaper;
		this.tittel = tittel;
		this.aar = aar;
		this.filmselskap = filmselskap;
		this.sjanger = sjanger;
	}
	
	public int getNummer() {
		return nummer;
	}
	
	public String getTittel() {
		return tittel;
	}
	
	public int getAar() {
		return aar;
	}
	
	public String getFilmselskap() {
		return filmselskap;
	}
	
	public String getProdusent() {
		return filmskaper;
	}
	
	public Sjanger getSjanger() {
		return sjanger;
	}

	

}
