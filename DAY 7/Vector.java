import java.util.Collections;
import java.util.Vector;

public class Vectoredemo {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>();

        v.add(15);
        v.add(23);
        v.add(10);
        v.add(30);
        v.add(5);

        System.out.println("Vector elements before sorting:");
        for (Object obj : v) {
            System.out.println(obj);
        }
        Collections.sort(v);

        System.out.println("Vector elements after sorting:");
        for (Object elements : v) {
            System.out.println(elements);
        }
    }
}


