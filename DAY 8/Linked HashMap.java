import java.util.*;
class Book {
    int id;
    String name,author,publisher;
    int quantity;
    public Book(int id, String name, String author, String publisher, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }
}
public class LinkedHashMapExample {
    public static void main(String[] args) {

        LinkedHashMap<Integer,Book> map=new LinkedHashMap<>();

        Book b1=new Book(111,"Let us C","Yashwant Kanetkar","BPB",8);
        Book b2=new Book(222,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);
        Book b3=new Book(333,"Operating System","Galvin","Wiley",6);
        Book b4 = new Book(444,"Cheaper by dozen","Frank Bunker Gilbreth Jr. and Ernestine Gilbreth Carey","Thomas Y. Crowell Co.",10);

        map.put(1,b2);
        map.put(2,b1);
        map.put(3,b3);
        map.put(4,b4);
        System.out.print(map);

        System.out.println("\n");
        for(Map.Entry<Integer, Book> entry:map.entrySet()){
            int key=entry.getKey();
            Book b=entry.getValue();
            System.out.println(key+" Details:");
            System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);
        }

        System.out.println("\n\nAfter Cloning: ");
        map.clone();
        for(Map.Entry<Integer, Book> entry:map.entrySet()){
            int key=entry.getKey();
            Book b=entry.getValue();
            System.out.println(key+" Details:");
            System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);
        }

        System.out.print("\nDoes map contains given object: " + map.containsValue(b3));
        System.out.print("\nDoes map contains given object: " + map.containsValue(b2));
    }
}
