package no.hvl.dat102.koe;
import no.hvl.dat102.koe.adt.KoeADT;


public class KjedetKoe<T> implements KoeADT<T> {

    private LinearNode<T> front, bak;
    private int antall;

    public KjedetKoe() {
        front = bak = null;
        antall = 0;
    }

    @Override
    public void innKoe(T element) {
        LinearNode<T> nyNode = new LinearNode<T>(element);

        if(erTom()) {
            front = nyNode;
        } else {
            bak.setNeste(nyNode);
        }
        bak = nyNode;

        antall++;
    }

    @Override
    public T utKoe() {
        
        if(erTom()) {
            throw new EmptyCollectionException("K�");
        }

        T resultat = front.getElement();
        
        front = front.getNeste();
        antall--;

        if(erTom()) {
            bak = null;
        }
        
        return resultat;
    }

    @Override
    public T foerste() {
        if(erTom()) {
            throw new EmptyCollectionException("K�");
        }

        T resultat = front.getElement();
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