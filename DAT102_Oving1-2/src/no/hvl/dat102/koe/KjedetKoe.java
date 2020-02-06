package no.hvl.dat102.koe;
import no.hvl.dat102.koe.adt.KoeADT;

public class KjedetKoe<T> implements KoeADT<T> {

	private int antall;
	private LinearNode<T> start;
	
	@Override
	public void innKoe(Object element) {
		LinearNode<T> nynode = new LinearNode<T>(element);
		nynode.setNeste(start);
		start = nynode;
		
		antall++;
		
	}

	@Override
	public Object utKoe() {
		LinearNode<Object> ser = start;
		LinearNode<Object> ut;

		while(ser.getNeste() != null) {
			ser = ser.getNeste();
		}
		
		antall--;
		
		ut = ser;
		ser = null;
		return ut;
	}

	@Override
	public Object foerste() {
		LinearNode<Object> ser = start;

		while(ser.getNeste() != null) {
			ser = ser.getNeste();
		}
		return ser;
	}

	@Override
	public boolean erTom() {
		if(start.getElement() == null) {
			return true;
		}
		return false;
	}

	@Override
	public int antall() {
		return antall;
	}

}
