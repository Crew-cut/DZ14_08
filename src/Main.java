import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        NewArrayList<Number> ints = new NewArrayList<>();
        ints.add(123);
        ints.add(0,2);
        ints.add(5);
        ints.remove(0);
        ints.trimToSize();
        System.out.println("elem = "+ints);
    }
}