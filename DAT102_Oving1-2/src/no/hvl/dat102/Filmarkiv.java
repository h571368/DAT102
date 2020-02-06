package no.hvl.dat102;
import no.hvl.dat102.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {
	 //Instansvariable
	 private Film[] filmTabell;
	 private int antall;
	 
	 public Filmarkiv() {
		 this.antall = 0;
		 this.filmTabell = new Film[1];
	 }
	 
	@Override
	public Film[] hentFilmTabell() {
		return filmTabell;
	}
	
	@Override
	public void leggTilFilm(Film nyFilm) {
		if (antall == filmTabell.length){
			 utvidKapasitet();
			 }
			 filmTabell[antall] = nyFilm;
			 antall++;
	}
	
	private void utvidKapasitet(){//eks. utvide 10%
		 Film[] hjelpetabell = new Film[(int)Math.ceil(1.1 *filmTabell.length)];
		 for (int i = 0; i < filmTabell.length; i++){
		 hjelpetabell[i] = filmTabell[i];
		 }
		 filmTabell = hjelpetabell;
		}

	@Override
	public boolean slettFilm(int filmNr) {
		
		for (int i = 0; i < filmTabell.length; i++) {
			if(filmNr == filmTabell[i].getNummer()) {
				if(antall == 0) {
					filmTabell[i] = filmTabell[antall];
				}
				filmTabell[i] = filmTabell[antall-1];
				filmTabell[antall-1] = null;
				antall--;
				return true;
			}
		}		
		return false;
		
	}
	@Override
	public Film[] sokTittel(String delstreng) {
		Film[] sok = new Film[antall];
		int antalltab = 0;
		for(int i = 0; i < filmTabell.length; i++) {
		if(filmTabell[i].getTittel().contains(delstreng)) {
			sok[antalltab]=filmTabell[i];
			antalltab++;
		}
		}
		return sok;
	}
	@Override
	public Film[] sokProdusent(String delstreng) {
		Film[] sok = new Film[antall];
		int antalltab = 0;
		for(int i = 0; i < filmTabell.length; i++) {
		if(filmTabell[i].getProdusent().contains(delstreng)) {
			sok[antalltab]=filmTabell[i];
			antalltab++;
		}
		}
		return sok;
	}
	
	@Override
	public int antallSjanger(Sjanger sjanger) {

		int antall = 0;
		for(int i = 0; i < filmTabell.length; i++) {
			if(filmTabell[i].getSjanger().equals(sjanger)) {
				antall++;
			}
		}
		
				
		return antall;
	}
	
	
	@Override
	public int antall() {
		return antall;
	}
	}
