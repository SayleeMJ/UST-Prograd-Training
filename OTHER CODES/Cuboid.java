class Rectangle{
    public double length;
    public double breadth;

    public double area()
    {
        return length * breadth;
    }
}

class  Cuboid extends Rectangle{
    public double height;

    public double getVolume()
    {
        return area() * height;
    }
}

public class Main {
    public static void main(String[] args)
    {

        Cuboid m = new Cuboid();
        m.length = 12;
        m.breadth = 10;
        m.height = 20;
        System.out.println(m.getVolume());
        System.out.println(m.area());
    }
}

