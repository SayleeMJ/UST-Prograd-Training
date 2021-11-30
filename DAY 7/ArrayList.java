import java.util.ArrayList;
public class ArrayListTask {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();
        al.add("Ice-Cream");
        al.add("Cake");
        al.add("Chocolate");
        al.add("Mousse");
        al.add("Cupcake");
        System.out.println(al);

        System.out.println("Getting element from position 0 to 4 ");
        for (int i = 0; i <= 4; i++) {
            String getElement = al.get(i);
            System.out.println(getElement);
        }
        String getE = al.get(3);
        System.out.println("Getting element at position 3: " + getE);
    }
}




