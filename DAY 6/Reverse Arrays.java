class Printer<T>{
    public <T> void printArray(T[] size) {
       for(T element : size){
           System.out.print(element);
       }
    }
}

public class Solution {
    public static void main(String[] args) {
        Printers printers = new Printers();
        Integer[] intArray = {1,2,3,4};
        String[] stringArray = {"Hey","What's_up","?"};

        printers.printArray(intArray);
        printers.printArray(stringArray);

        System.out.println("After Reversing: ");
        for(int i=intArray.length-1;i>=0;i--)
            System.out.print(intArray[i] + "  ");
        System.out.println("\n");
        for(int i=stringArray.length-1;i>=0;i--)
            System.out.print(stringArray[i] + "  ");
    }
}

