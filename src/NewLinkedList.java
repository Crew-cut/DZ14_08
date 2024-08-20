import java.util.LinkedList;

public class NewLinkedList <E> {

//    private static final Object [] EMPTY_OBJECT = {};
    private int size;

    private Node<E> first;
    private Node<E> last;

    public NewLinkedList(){
    }
    public void add (int index, E element){
        if(index == size){
            linkLast(element);
        }else {
            linkPrev(element, node(index));
        }
    }

    public boolean add (E element){
        linkLast(element);
        return true;
    }

    private void linkLast(E element) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, element, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }
    void linkPrev(E e, Node<E> succ) {

        final Node<E> prev = succ.prev;
        final Node<E> newNode = new Node<>(prev, e, succ);
        succ.prev = newNode;
        if (prev == null)
            first = newNode;
        else
            prev.next = newNode;
        size++;
    }

    private static class Node <E>{
        E item;
        Node<E> prev;
        Node<E> next;
        Node (Node<E> prev, E element, Node<E> next){
            this.item = element;
            this.prev = prev;
            this.next = next;
        }
    }
    Node<E> node(int index) {

        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

}
