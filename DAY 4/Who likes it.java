import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner;
        scanner = new Scanner(System.in);
        int ch;
       do {
           System.out.println("Enter choice: ");
           ch = scanner.nextInt();

           switch (ch) {
               case 0 -> System.out.println("No one likes this");
               case 1 -> System.out.println("Peter likes this");
               case 2 -> System.out.println("Jacob and Alex like this");
               case 3 -> System.out.println("Max, John and Mark like this");
               case 4 -> System.out.println("Alex, Jacob and 2 others like this");
           }
       }while(ch!=5);
    }
}

