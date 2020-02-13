package no.hvl.dat102.test;
import no.hvl.dat102.koe.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import no.hvl.dat102.koe.EmptyCollectionException;
import no.hvl.dat102.koe.adt.KoeADT;

public abstract class KoeTest {

	// Referanse til stabel
	private KoeADT<Integer> Koe;

	// Testdata
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;

	protected abstract KoeADT<Integer> reset();

	/**
	 * Hent en ny stabel for hver test.
	 * 
	 * @return
	 */
	@BeforeEach
	public void setup() {
		Koe = reset();
	}

	/**
	 * Test på at en ny stabel er tom.
	 */
	@Test
	public void nyStabelErTom() {
		assertTrue(Koe.erTom());
	}

	/**
	 * Test opå push and pop.
	 */
	@Test
	public void pushOgPop() {

		Koe.innKoe(e0);
		Koe.innKoe(e1);
		Koe.innKoe(e2);
		Koe.innKoe(e3);

		try {
			assertEquals(e3, Koe.utKoe());
			assertEquals(e2, Koe.utKoe());
			assertEquals(e1, Koe.utKoe());
			assertEquals(e0, Koe.utKoe());
		} catch (EmptyCollectionException e) {
			fail("utkø feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Test på push og pop med duplikate verdier.
	 */
	@Test
	public void pushOgPopMedDuplikater() {

		Koe.innKoe(e0);
		Koe.innKoe(e1);
		Koe.innKoe(e1);
		Koe.innKoe(e2);

		try {
			assertEquals(e2, Koe.utKoe());
			assertEquals(e1, Koe.utKoe());
			assertEquals(e1, Koe.utKoe());
			assertEquals(e0, Koe.utKoe());
		} catch (EmptyCollectionException e) {
			fail("pop feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Testing på peek.
	 */
	@Test
	public void pushPopPushPushPopPeek() {
		try {
			Koe.innKoe(e2);
			Koe.utKoe();
			Koe.innKoe(e3);
			Koe.innKoe(e4);
			Koe.utKoe();
			assertEquals(e3, Koe.foerste());

		} catch (EmptyCollectionException e) {
			fail("pop eller peek feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Test på at en stabel med noen elementer ikke er tom.
	 */
	@Test
	public final void erIkkeTom() {
		Koe.innKoe(e0);
		Koe.innKoe(e1);
		assertFalse(Koe.erTom());
	}

	/**
	 * Test på at en stabel med null elementer er tom.
	 */
	@Test
	public void pushPopErTom() {
		try {
			Koe.innKoe(e0);
			Koe.utKoe();
			assertTrue(Koe.erTom());

		} catch (EmptyCollectionException e) {
			fail("push eller pop feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Test på størrelsen
	 */
	@Test
	public void stor() {
		Koe.innKoe(e0);
		Koe.innKoe(e1);
		Koe.innKoe(e2);
		assertEquals(3, Koe.antall());
	}

	/**
	 * Forsøk på pop av en tom stabel skal gi "underflow excepton" *
	 * 
	 * @throws EmptyCollectionException expected exception
	 */
	@Test
	public void popFromEmptyIsUnderflowed() {
		/*
		 * Assertions.assertThrows(EmptyCollectionException.class, new Executable() {
		 * 
		 * @Override public void execute() throws Throwable { stabel.pop(); } });
		 */

		Assertions.assertThrows(EmptyCollectionException.class, () -> {
			Koe.utKoe();
		});
	}
}
