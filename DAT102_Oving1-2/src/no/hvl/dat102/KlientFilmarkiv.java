package no.hvl.dat102;
import no.hvl.dat102.adt.*;
public class KlientFilmarkiv {

	public static void main(String[] args) {
		Filmarkiv filma = new Filmarkiv();
		Meny meny = new Meny(filma);
		meny.start();
		}
		
}
