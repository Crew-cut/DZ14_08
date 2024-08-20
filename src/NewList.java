public interface NewList <E> extends Iterable <E>{
    boolean add (E e);
    void remove (int index);
    E get (int index);
    int size();
    E set (int index, int e);
}
