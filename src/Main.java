import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        NewArrayList<Integer> integer = new NewArrayList<>();
        integer.add(123);
        integer.add(0,2);
        integer.add(5);
        integer.trimToSize();
        System.out.println("elem = " + integer);
    }
}