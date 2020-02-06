package no.hvl.dat102.oving1;
import java.util.Scanner;

import no.hvl.dat102.oving1.adt.FilmarkivADT;

public class Tekstgrensesnitt {

	
	// lese opplysningene om en FILM fra tastatur
	 public Film lesFilm() {
		 Scanner keyboard = new Scanner(System.in);
	
		 System.out.println("Nummer?");
		 int nummer = keyboard.nextInt();
		 
		 System.out.println("Produsent?");
		 keyboard.nextLine();
		 String produsent = keyboard.nextLine();
		 
		 System.out.println("Tittel på film?");
		 //keyboard.nextLine();
		 String tittel = keyboard.nextLine();
		 
		 System.out.println("Når ble filmen laget?");
		 int aar = keyboard.nextInt();

		 System.out.println("Hvilket filmselskap står bak?");
		 keyboard.nextLine();
		 String filmselskap = keyboard.nextLine();
		
		 System.out.println("Hvilken sjanger er filmen?");
		 String strSjanger = keyboard.nextLine();
		 
		
		 
		 
		 Sjanger sjanger = Sjanger.finnSjanger("drama");
		 
		 
		 

		 
		 
		 Film film = new Film(nummer, produsent, tittel, aar, filmselskap, sjanger);
		 //Film film = new Film(1, "s", "s", 1, "s", sjanger);
		 //keyboard.close();
		 return film;
		
	 }
	// vise en film med alle opplysninger på skjerm (husk tekst for sjanger)
	 public void visFilm(Film film){
		 System.out.println(film.getNummer() + "\t" + film.getProdusent() + "\t" + film.getTittel() + "\t" + film.getAar() + "\t" + film.getFilmselskap() + "\t" + film.getSjanger());
	 }
	// Skrive ut alle Filmer med en spesiell delstreng i tittelen
	 public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng){
		 Film[] subTittel = filma.sokTittel(delstreng);
		 for(int i = 0; i < subTittel.length; i++) {
			 System.out.println(subTittel[i].getTittel());
		 }
	 }
	// Skriver ut alle Filmer av en produsent / en gruppe
	 public void skrivUtFilmProdusent(FilmarkivADT filma, String delstreng) {
		 Film[] subProd = filma.sokProdusent(delstreng);
		 for(int i = 0; i < subProd.length; i++) {
			 System.out.println(subProd[i].getProdusent());
		 }
	 }
	// Skrive ut en enkel statistikk som inneholder antall Filmer totalt
	// og hvor mange det er i hver sjanger
	 public void skrivUtStatistikk(FilmarkivADT filma){
		 System.out.println("");
		 System.out.println("Antall Filmer totalt : " + filma.antall());
		 for(Sjanger s : Sjanger.values()) {
			 System.out.println(s.toString() + ": " + filma.antallSjanger(s));
			 
		 }
		 System.out.println("");
		 
	 }
}
