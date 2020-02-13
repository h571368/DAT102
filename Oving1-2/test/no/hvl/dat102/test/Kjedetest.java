package no.hvl.dat102.test;

import no.hvl.dat102.koe.KjedetKoe;
import no.hvl.dat102.koe.adt.KoeADT;
import no.hvl.dat102.*;

public class Kjedetest extends Test{

	@Override
	protected KoeADT<Integer> reset() {
		return new KjedetKoe<Integer>();
	}

}
