@FunctionalInterface
interface Addable{
    public int add (int a, int b);
//    public int sub (int a, int b);
//    public int multiplication  (int a, int b);
}

public class FunctionInterface {
    public static void main(String[] args) {
        Addable addable = (int a, int b)-> {
            return (a+b);
        };
        System.out.println("Addition: ");
        System.out.println(addable.add(4, 6));

        addable = (int a, int b)-> {
            return (a-b);
        };
        System.out.println("Subtraction: ");
        System.out.println(addable.add(10, 5));

        addable = (int a, int b)-> {
            return (a*b);
        };
        System.out.println("Multiplication: ");
        System.out.println(addable.add(3,6));

        addable = (int a, int b)-> {
          return (a/b);
        };
        System.out.println("Division: ");
        System.out.println(addable.add(15,5));
    }
}

