import java.util.Iterator;

public class NewArrayIterator<E> implements Iterator<E> {
    private int index = 0;
    private E[] objects;

    NewArrayIterator (E[] objects){
        this.objects = objects;
    }
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public E next() {
        return null;
    }
}
