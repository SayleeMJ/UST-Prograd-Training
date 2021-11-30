import java.util.LinkedList;
import java.util.Scanner;


public class LinkedListdemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);
        linkedList.add(50);
        System.out.println(linkedList);

        int ch;
        System.out.println("Enter index: ");
        int n=sc.nextInt();
        do{
            System.out.println("\n1. Display \n2. Remove\n3. Get first\n4. Clone\n5. Get last ");
            System.out.println("Enter your choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1 -> System.out.println("Original Linked list:\n" + linkedList);
                case 2 -> {
                    System.out.println(linkedList.remove(n));
                    System.out.println("After removing:\n" + linkedList);
                }
                case 3 -> System.out.println("First element is:\n" + linkedList.getFirst());
                case 4 -> System.out.println("Cloned LinkedList:\n" + linkedList.clone());
                case 5 -> System.out.println("First element is:\n" + linkedList.getLast());
            }
        }while(ch!=6);

    }
}

