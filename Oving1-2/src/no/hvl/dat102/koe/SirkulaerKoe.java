package no.hvl.dat102.koe;
import no.hvl.dat102.koe.adt.KoeADT;

public class SirkulaerKoe<T> implements KoeADT<T> {

	
	private final static int STDK = 100;
	private int foran, bak, antall;
	private T[] koe;
	private LinearNode<Object> start;
	
	public SirkulaerKoe() {
		this(STDK);
	}

	public SirkulaerKoe(int startKapasitet) {
		foran = bak = antall = 0;
		koe = ((T[]) (new Object[startKapasitet]));
	}
	
	@Override
	public void innKoe(Object element) {
		LinearNode<Object> nynode = new LinearNode<Object>(element);
		nynode.setNeste(start);
		nynode = start;
		antall++;
		
	}

	@Override
	public Object utKoe() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object foerste() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean erTom() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int antall() {
		// TODO Auto-generated method stub
		return 0;
	}

}
