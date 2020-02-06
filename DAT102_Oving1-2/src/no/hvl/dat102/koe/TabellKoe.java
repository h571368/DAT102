package no.hvl.dat102.koe;
import no.hvl.dat102.koe.adt.KoeADT;


public class TabellKoe<Object> implements KoeADT<Object> {

	private int antall;
	private final static int STDK = 100;
	private int bak;
	private Object[] koe; 

	   public TabellKoe()   {
	     this(STDK);     
	   }

	   
	   public TabellKoe (int startKapasitet){
	      bak = 0;     
	      koe = (Object[])(new Object[startKapasitet]);
	    }
	
	@Override
	public void innKoe(Object element) {
		Object[] hjelpetab = new Object[antall+1]; 
		
		for(int i = 0; i < antall; i++) {
			hjelpetab[i]=koe[i];
		}
		koe = hjelpetab;
		
		koe[antall] = element;
		antall++;
		
	}

	@Override
	public T utKoe() {
		T ut = new T();
		ut = koe[0];
		
		for(int i = 1; i < antall; i++ ) {
			koe[i-1] = koe[i];
		}
		
		antall--;
		return ut;		
	}

	@Override
	public T foerste() {
		return T[0];
	}

	@Override
	public boolean erTom() {
		if(antall == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int antall() {
		return antall;
	}

}
