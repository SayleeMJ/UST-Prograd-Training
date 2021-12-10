import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class SquareTest {
    private Square square;

    @Nested
    public class AreaOfSquare{
        @Test
        public void AreaOFSquareSideSquare(){
            square= new Square(5);
            double actualArea = square.area();
            double expectedArea = 25;
            assertEquals(expectedArea , actualArea);
        }

        @Test
        public void AreaOFSquareFloatSideSquare(){
            square = new Square(2.4);
            double actualArea = square.area();
            double expectedArea = 5.76;
            assertEquals(expectedArea , actualArea);
        }

        @Test
        public void throwsExceptionWhenSideIsZero(){
            Assertions.assertThrows(IllegalArgumentException.class, () -> new Square(0));
        }

        @Test
        public void throwsExceptionWhenSideIsNegative(){
            Assertions.assertThrows(IllegalArgumentException.class, () -> new Square(-2));
        }
    }

    @Nested
    public  class PerimeterOfSquare{
        @Test
        public void PerimeterOFSquareIsFourMultiplySide(){
            square= new Square(2);
            double actualPerimeter = square.perimeter();
            double expectedPerimeter = 8;
            assertEquals(expectedPerimeter, actualPerimeter);
        }

        @Test
        public void PerimeterOFSquareFloatSideSquare(){
            square = new Square(2.4);
            double actualPerimeter = square.perimeter();
            double expectedPerimeter = 9.6;
            assertEquals(expectedPerimeter, actualPerimeter);
        }

        @Test
        public void throwsExceptionWhenSideIsZero(){
            Assertions.assertThrows(IllegalArgumentException.class, () -> new Square(0));
        }

        @Test
        public void throwsExceptionWhenSideIsNegative(){
            Assertions.assertThrows(IllegalArgumentException.class, () -> new Square(-8));
        }
    }
}