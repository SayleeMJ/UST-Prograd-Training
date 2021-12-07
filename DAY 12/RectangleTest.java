import org.junit.jupiter.api.*;

public class RectangleTest {
    private Rectangle rectangle;

    @BeforeEach
    public void setup(){
        rectangle= new Rectangle();
    }

    @Nested
    public class AreaOFRectangle {
        @Test
        public void areaLengthMultiplyBreadth() {
            rectangle.setLength(10);
            rectangle.setBreadth(5);
            double answer = rectangle.rectArea();
            double expected = 50;
            System.out.println("Test for Area - 10 * 5 = 50 ");
            Assertions.assertEquals(answer, expected);
        }

        @Test
        public void throwsExceptionWhenBreadthIsZero() {
            System.out.println("Test for Area - Breadth is Zero ");
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                rectangle.setLength(10);
                rectangle.setBreadth(0);
                rectangle.rectArea();
            });
        }

        @Test
        public void throwsExceptionWhenLengthIsZero() {
            System.out.println("Test for Area - Length is Zero ");
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                rectangle.setLength(0);
                rectangle.setBreadth(20);
                rectangle.rectArea();
            });
        }

        @Test
        public void throwsExceptionWhenLengthIsNegative() {
            System.out.println("Test for Area - Length is Negative ");
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                rectangle.setLength(-10);
                rectangle.setBreadth(20);
                rectangle.rectArea();
            });
        }

        @Test
        public void throwsExceptionWhenBreadthIsNegative() {
            System.out.println("Test for Area - Breadth is Negative ");
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                rectangle.setLength(30);
                rectangle.setBreadth(-20);
                rectangle.rectArea();
            });
        }

        @Test
        public void areaFloatLengthMultiplyBreadth() {
            rectangle.setLength(4.5);
            rectangle.setBreadth(6);
            double answer = rectangle.rectArea();
            double expected = 27;
            System.out.println("Test for Area - 4.5 * 6 = 27 ");
            Assertions.assertEquals(answer, expected);
        }

        @Test
        public void areaFloatBreadthMultiplyBreadth() {
            rectangle.setLength(10);
            rectangle.setBreadth(5.5);
            double answer = rectangle.rectArea();
            double expected = 55;
            System.out.println("Test for Area - 10 * 5.5 = 55 ");
            Assertions.assertEquals(answer, expected);
        }
    }

    // Perimeter Tests
    @Nested
    public class PerimeterOfRectangle {

        @BeforeEach
        public void setup(){
            rectangle= new Rectangle();
        }

        @Test
        public void perimeterLengthIsTwoBreadthIsFive() {
            rectangle.setLength(2);
            rectangle.setBreadth(5);
            double answer = rectangle.rectPerimeter();
            double expected = 14;
            System.out.println("Test for perimeter - 2 (2 + 5) = 14 ");
            Assertions.assertEquals(answer, expected);
        }

        @Test
        public void throwsExceptionWhenLengthIsNegative(){
            System.out.println("Test for perimeter - Length is Negative");
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                rectangle.setLength(-10);
                rectangle.setBreadth(20);
                rectangle.rectPerimeter();
            });
        }

        @Test
        public void throwsExceptionWhenBreadthIsNegative() {
            System.out.println("Test for perimeter - Breadth is Negative ");
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                rectangle.setLength(20);
                rectangle.setBreadth(-5);
                rectangle.rectPerimeter();
            });
        }

        @Test
        public void throwsExceptionWhenLengthIsZero(){
            System.out.println("Test for perimeter - Length is Zero");
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                rectangle.setLength(0);
                rectangle.setBreadth(40);
                rectangle.rectPerimeter();
            });
        }

        @Test
        public void throwsExceptionWhenBreadthIsZero(){
            System.out.println("Test for perimeter - Breadth is Zero");
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                rectangle.setLength(15);
                rectangle.setBreadth(0);
                rectangle.rectPerimeter();
            });
        }

        @Test
        public void perimeterFloatLengthFourPointFourBreadthIsFive() {
            rectangle.setLength(4.4);
            rectangle.setBreadth(5);
            double answer = rectangle.rectPerimeter();
            double expected = 18.8;
            System.out.println("Test for perimeter - 2 (4.4 + 5) = 18.8 ");
            Assertions.assertEquals(answer, expected);
        }

        @Test
        public void perimeterLengthFiveFloatBreadthIsTwelvePointFour() {
            rectangle.setLength(5);
            rectangle.setBreadth(12.4);
            double answer = rectangle.rectPerimeter();
            double expected = 34.8;
            System.out.println("Test for perimeter - 2 (5 + 12.5)= 34.8 ");
            Assertions.assertEquals(answer, expected);
        }
    }
}
