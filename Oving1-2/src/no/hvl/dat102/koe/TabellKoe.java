package no.hvl.dat102.koe;
import no.hvl.dat102.koe.adt.KoeADT;


public class TabellKoe<T> implements KoeADT<T> {

	private final static int STDK = 100;
	private int antall; // antall og nesteplass
	private T[] koe; // front ved indeks 0

	public TabellKoe() {
		this(STDK);
	}

	public TabellKoe(int startKapasitet) {
		this.koe = ((T[]) (new Object[startKapasitet]));
		this.antall = 0;
	}

	public void innKoe(T element) {
		if (antall() == koe.length) {
			utvid();
		}

		koe[antall] = element;
		antall++;
	}

	public T utKoe() {
		T resultat = koe[0];
		antall--;
		
		
		/** flytter elementene en plass fram */
		for (int i = 1; i < koe.length; i++) {
			koe[i-1] = koe[i];
		}
		koe[antall] = null;
		return resultat;
	}

	public T foerste() {
		T resultat = koe[0];
		return resultat;
	}

	public boolean erTom() {
		return (antall == 0);
	}

	public int antall() {
		return antall;
	}
	
	private void utvid() {
	       T[] hjelpetabell = (T[])(new Object[koe.length*2]);

	      for (int soek = 0; soek < koe.length; soek++){
	         hjelpetabell[soek] = koe[soek];
		  }

	       koe = hjelpetabell;
	   }

	
}// class