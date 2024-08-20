public class Main {
    public static void main(String[] args) {
        NewLinkedList<Integer> integer = new NewLinkedList<>();
        integer.add(123);
        integer.add(0,2);
        integer.add(5);
//        integer.trimToSize();
        System.out.println("elem = " + integer);
    }
}