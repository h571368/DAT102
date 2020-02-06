package no.hvl.dat102.oving2;
import no.hvl.dat102.oving2.Film;
import no.hvl.dat102.oving2.LinearNode;
import no.hvl.dat102.oving2.Sjanger;
import no.hvl.dat102.oving2.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT{
	private int antall;
	private LinearNode<Film> start;
	
	public Filmarkiv() {
		start = null;
		antall = 0;
	}
	
	@Override //Returnerer tabell av filmer
	public Film[] hentFilmTabell() {
		Film[] tab = new Film[antall];
		LinearNode<Film> nynode = start;
		int i = 0;
		while (nynode != null) {
			tab[i] = nynode.getElement();
			nynode = nynode.getNeste();
			i++;
		}
		return tab;
	}
	
	
	@Override // Legger til en Film
	public void leggTilFilm(Film nyFilm) {
		LinearNode<Film> nynode = new LinearNode<Film>(nyFilm);
		nynode.setNeste(start);
		start = nynode;
		antall++;
		
	}
	
	@Override // Sletter en film hvis den finnes.
	public boolean slettFilm(int filmNr) {
		LinearNode<Film> nynode = start.getNeste();
		LinearNode<Film> forrige = start;

		if (start != null && start.getElement().getNummer() == filmNr) {
			start = start.getNeste();
			antall--;
			return true;
		}

		while (nynode != null) {
			if (nynode.getElement().getNummer() == filmNr) {
				forrige.setNeste(nynode.getNeste());
				antall--;
				return true;
			}
			forrige = nynode;
			nynode = nynode.getNeste();
		}
		return false;
	}
	
	@Override
	public Film[] sokTittel(String delstreng) {
		Film[] tab = new Film[antall];
		Film[] tab2 = new Film[0];
		LinearNode<Film> nynode = start;

		int i = 0;
		while (nynode != null) {
			tab[i] = nynode.getElement();
			nynode = nynode.getNeste();
			i++;
		}
		int x = 0;
		for (int y = 0; y < tab.length; y++) {
			if (tab[y].getTittel().contains(delstreng)) {
				tab2[x] = tab[y];
				x++;
			}
		}
		return tab2;
	}
	
	@Override
	public Film[] sokProdusent(String delstreng) {
		Film[] tab = new Film[antall];
		Film[] tab2 = new Film[0];
		LinearNode<Film> nynode = start;

		
		int i = 0;
		while (nynode != null) {
			tab[i] = nynode.getElement();
			nynode = nynode.getNeste();
			i++;
		}
		
		int x = 0;
		for (int y = 0; y < tab.length; y++) {
			if (tab[y].getProdusent().contains(delstreng)) {
				tab2[x] = tab[y];
				x++;
			}
		}
		return tab2;
	}
	
	
	@Override
	public int antallSjanger(Sjanger sjanger) {
		Film[] tab = new Film[antall];
		LinearNode<Film> nynode = start;
		
		int i = 0;
		while (nynode != null) {
			tab[i] = nynode.getElement();
			nynode = nynode.getNeste();
			i++;
		}
		
		int antallSjanger = 0;
		for (int y = 0; y < tab.length; y++) {
			if (tab[y].getSjanger() == sjanger) {
				antallSjanger++;
			}
		}
		return antallSjanger;
	}
	
	
	@Override
	public int antall() {
		return antall;
	}
	
//class
}