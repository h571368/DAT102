package no.hvl.dat102.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.function.Executable;

import no.hvl.dat102.koe.EmptyCollectionException;
import no.hvl.dat102.koe.KjedetKoe;
import no.hvl.dat102.koe.SirkulaerKoe;
import no.hvl.dat102.koe.TabellKoe;
import no.hvl.dat102.koe.adt.KoeADT;

public abstract class Test {

	private KoeADT<Integer> Koe;

	
	// Testdata
		private Integer e0 = 1;
		private Integer e1 = 2;
		private Integer e2 = 3;
		private Integer e3 = 4;
		private Integer e4 = 5;
		
		protected abstract KoeADT<Integer> reset;

		/**
		 * Hent en ny stabel for hver test.
		 * 
		 * @return
		 */
		@BeforeEach
		public void setup() {
			Koe = reset;
		}
	
		@org.junit.jupiter.api.Test
		public void ErTom() {
		assertTrue(Koe.erTom());
		Koe.innKoe(e1);
		assertFalse(Koe.erTom());
		}
		@org.junit.jupiter.api.Test
		public void leggTilOgSlett() {

		Koe.innKoe(e0);
		

		try {
			assertEquals(e0, Koe.utKoe());
			
			
		} catch (EmptyCollectionException e) {
			fail("Utkø feilet uventet " + e.getMessage());
		}
		}
		@org.junit.jupiter.api.Test
		public void leggTilOgSlettDuplikat() {

		Koe.innKoe(e0);
		Koe.innKoe(e1);
		Koe.innKoe(e1);
		
		

		try {
			assertEquals(e0, Koe.utKoe());
			assertEquals(e1, Koe.utKoe());
			assertEquals(e1, Koe.utKoe());
			
			
			
		} catch (EmptyCollectionException e) {
			fail("pop feilet uventet " + e.getMessage());
		}
	}
	
	
}
