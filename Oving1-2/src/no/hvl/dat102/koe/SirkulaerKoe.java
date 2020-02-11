package no.hvl.dat102.koe;
import no.hvl.dat102.koe.adt.KoeADT;

public class SirkulaerKoe<T> implements KoeADT<T> {

	private final static int STDK = 100;
    private int front, bak, antall;
    private T[] koe;

    public SirkulaerKoe(int storrelse) {
        this.koe = (T[]) new Object[storrelse];
        this.front = 0;
        this.bak = 0;
        this.antall = 0;
    }

    public SirkulaerKoe() {
        this(STDK);
    }

    @Override
    public void innKoe(T element) {
        if (antall() == koe.length) {
            utvid();
        }
        koe[front] = element;
        bak = (bak+1) % koe.length;
        antall++;
    }

    @Override
    public T utKoe() {
        T resultat = koe[front];
        koe[front] = null;
        front = (bak+1) % koe.length;
        antall--;
        return resultat;
    }

    @Override
    public T foerste() {
        return koe[front];
    }

    @Override
    public boolean erTom() {
        return (antall() == 0);
    }

    @Override
    public int antall() {
        return antall;
    }

    private void utvid() {
        T[] hjelpetab = (T[])(new Object[koe.length * 2]);

        for (int i = 0; i < koe.length; i++) {
            hjelpetab[i] = koe[front];
            front = (bak+1) % koe.length;
        }

        front = 0;
        bak = antall;
        koe = hjelpetab;
    }

}