import org.junit.jupiter.api.*;

public class CalculatorTest {
    private Calculator calc;
    @BeforeEach
    public void setup(){
        calc = new Calculator();
    }

    @Nested
    public class TestingAddFunction{
        @BeforeEach
        public void setup(){
            calc = new Calculator();
        }
        @Test
        public void additionThreePlusFiveEqualsEight() {
            // Calculator calc = new Calculator();
            double answer = calc.add(3,5);
            double expected = 8;
            Assertions.assertEquals(answer, expected);
        }
        @Test
        public void additionFivePlusFiveEqualsTen() {
            // Calculator calc = new Calculator();
            double answer = calc.add(5,5);
            double expected = 10;
            Assertions.assertEquals(answer, expected);
        }
        @Test
        public void additionFivePlusZeroEqualsFive() {
            double answer = calc.add(5,0);
            double expected = 5;
            Assertions.assertEquals(answer, expected);
        }

        @Test
        public void additionNegativeFivePlusTwoEqualsNegativeThree() {
            double answer = calc.add(-5,2);
            double expected = -3;
            Assertions.assertEquals(answer, expected);
        }
    }

    @Nested
    public class TestingSubtractionFunction{
        @BeforeEach
        public void setup(){
            calc = new Calculator();
        }
        @Test
        public void subtractionFiveMinusZeroEqualsFive() {
            double answer = calc.sub(5,0);
            double expected = 5;
        //    System.out.println("testcase4");
            Assertions.assertEquals(answer, expected);
        }
        @Test
        public void subtractionFiveMinusTwoEqualsThree() {
            double answer = calc.sub(5,2);
            double expected = 3;
         //   System.out.println("testcase5");
            Assertions.assertEquals(answer, expected);
        }

        @Test
        public void subtractionEightMinusThreeEqualsFive() {
            double answer = calc.sub(8,3);
            double expected = 5;
         //   System.out.println("testcase6");
            Assertions.assertEquals(answer, expected);
        }
        @Test
        public void subtractionEightMinusTenEqualsNegativeTwo() {
            double answer = calc.sub(8,10);
            double expected = -2;
         //   System.out.println("testcase7");
            Assertions.assertEquals(answer, expected);
        }
    }

    @Nested
    public class TestingDivisionFunction{
        @BeforeEach
        public void setup(){
            calc = new Calculator();
        }
        @Test
        public void divisionFourDivideTwoEqualsTwo() {
            double answer = calc.div(4,2);
            double expected = 2;
            Assertions.assertEquals(answer, expected);
        }

        @Test
        public void throwsExceptionWhenDividedByZero(){
            Assertions.assertThrows(ArithmeticException.class, ()-> calc.div(10,0));
        }

        @Test
        public void divisionSixPointFourDivideHundrequals() {
            double answer = calc.div(6.4,100);
            double expected = 0.064;
            Assertions.assertEquals(answer, expected);
        }

    }

    @Nested
    public class TestingMultiplicationFunction{
        @BeforeEach
        public void setup(){
            calc = new Calculator();
        }

        @Test
        public void multiplicationFourMultiplyFour(){
            double answer = calc.mul(4, 4);
            double expected = 16;
            Assertions.assertEquals(answer, expected);
        }

        @Test
        public void multiplicationFiveMultiplyTen(){
            double answer = calc.mul(5,10);
            double expected = 50;
            Assertions.assertEquals(answer, expected);
        }

        @Test
        public void multiplicationThirtyMultiplyThirty(){
            double answer = calc.mul(30,30);
            double expected = 900;
            Assertions.assertEquals(answer, expected);
        }

        @Test
        public void multiplicationThirtyMultiplyZero(){
            double answer = calc.mul(30,0);
            double expected = 0;
            Assertions.assertEquals(answer, expected);
        }

        @Test
        public void multiplicationTwentyMultiplyZeroPointOne(){
            double answer = calc.mul(20,0.1);
            double expected = 2;
            Assertions.assertEquals(answer, expected);
        }

        @Test
        public void multiplicationOnePointTwoMultiplyZeroPointOne(){
            double answer = calc.mul(1.2,0.1);
            double expected = 0.12;
            Assertions.assertEquals(answer, expected);
        }
        @Test
        public void multiplicationNegativeTwentyMultiplyNegativeTen(){
            double answer = calc.mul(-20,-10);
            double expected = 200;
            Assertions.assertEquals(answer, expected);
        }

        @Test
        public void multiplicationMinusTwoMultiplyFour(){
            double answer = calc.mul(-2,4);
            double expected = -8;
            Assertions.assertEquals(answer, expected);
        }

        @Test
        public void multiplicationOneHundredThousandMultiplyHundred(){
            double answer = calc.mul(100000,100);
            double expected = 10000000;
            Assertions.assertEquals(answer, expected);
        }
    }
}
