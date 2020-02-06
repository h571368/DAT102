package no.hvl.dat102.adt;
import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;

public interface FilmarkivADT {
	
 Film[] hentFilmTabell();
 
 void leggTilFilm(Film nyFilm);
 
 boolean slettFilm(int filmNr);
 
 Film[] sokTittel(String delstreng);
 // Søker og henter produsenter med en gitt delstreng
 
 Film[] sokProdusent(String delstreng);
 // Henter antall Filmer for en gitt sjanger
 
 int antallSjanger(Sjanger sjanger);
 // Returnerer antall sjangre

 
 int antall();
//Returnerer antall Filmer
 
}