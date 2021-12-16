public class Calculator extends Exception {
    public double add(double a, double b){
        return a+b;
    }

    public double sub(double a, double b){
        return a-b;
    }

    public double div(double a, double b){
        if(b==0){
            throw new ArithmeticException("Can't divide by zero");
        }
        double result = a/b;
        return result;
    }

    public double mul(double a, double b){
        double result = a*b;
        return result;
    }
}
