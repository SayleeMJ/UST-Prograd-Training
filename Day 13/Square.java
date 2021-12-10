public class Square extends Rectangle {
    Square(double side){
        super(side,side);
    }
}



/*
    double side;
    Square(double length){
        if(length<=0){
            throw new IllegalArgumentException("Side should not be less than or equal to zero");
        }
        this.side = length;
    }
    public double squareArea(){
        return side * side;
    }

    public double squarePerimeter(){

        return 4 * (side);
    }
*/