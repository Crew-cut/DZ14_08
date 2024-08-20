public class NewLinkedList <E> {

//    private static final Object [] EMPTY_OBJECT = {};
    private int size;

    private Node<E> first;
    private Node<E> last;

    public NewLinkedList(){
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

}
