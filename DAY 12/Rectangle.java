public class Rectangle {
        private double length;
        private double breadth;

        Rectangle(double length, double breadth){
            setLength(length);
            setBreadth(breadth);
        }

        public Rectangle() {}

        public double getBreadth() {
            return breadth;
        }

        public double getLength() {
            return length;
        }

        public void setLength(double length) {
            if(length<=0){
                throw new IllegalArgumentException("Length can't be zero or less than zero or Negative");
            }
            this.length = length;
        }

        public void setBreadth(double breadth) {
            if(breadth<=0) {
                throw new IllegalArgumentException("Breadth can't be zero or less than zero or Negative");
            }
            this.breadth = breadth;
        }

        public double rectArea(){
            return length * breadth;
        }

        public double rectPerimeter(){
        return 2 * (length + breadth);
    }
}