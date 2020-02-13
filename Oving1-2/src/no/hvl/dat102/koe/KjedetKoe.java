package no.hvl.dat102.koe;
import no.hvl.dat102.koe.adt.KoeADT;


public class KjedetKoe<T> implements KoeADT<T> {

    private LinearNode<T> start, neste;
    private int antall;

    public KjedetKoe() {
        start = null;
        neste = null;
        antall = 0;
    }

    @Override
    public void innKoe(T element) {
        LinearNode<T> neste = new LinearNode<T>(element);

        /*neste.setNeste(start);
        start = neste;
        antall++;*/
        
        if(erTom()) {
            start = neste;
        } 
        else {
        	neste.setNeste(neste);
        }
        start = neste;

        antall++;
    }

    @Override
    public T utKoe() {
        
        T resultat = start.getElement();
        
        start = start.getNeste();
        antall--;

        if(erTom()) {
            neste = null;
        }
        
        return resultat;
    }

    @Override
    public T foerste() {
        T resultat = start.getElement();
        return resultat;
    }

    @Override
    public boolean erTom() {
        return antall() == 0;
    }

    @Override
    public int antall() {
        return antall;
    }
}