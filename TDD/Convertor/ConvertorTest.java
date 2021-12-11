import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertorTest {
    private Convertor convertor;

    @BeforeEach
    public void setup(){
        convertor = new Convertor();
    }

    @Nested
    public class CoversionOfUnits{
        @Test
        public void checkIfOneCentimeterIsOneCentimeter(){
            double actualMeasurement= convertor.unitConvertor(1,"cm","cm");
            double expectedMeasurement = 1;
            assertEquals(expectedMeasurement,actualMeasurement);
        }

        @Test
        public void checkIfOneMeterIsHundredCentimeter(){
            double actualMeasurement= convertor.unitConvertor(1,"m","cm");
            double expectedMeasurement = 100;
            assertEquals(expectedMeasurement,actualMeasurement);
        }

        @Test
        public void checkIfHundredCentimeterIsPointZeroZeroOneKilometer(){
            double actualMeasurement= convertor.unitConvertor(100,"cm","km");
            double expectedMeasurement = 0.001;
            assertEquals(expectedMeasurement,actualMeasurement);
        }

        @Test
        public void checkIfOneKilometerIsThousantMeter(){
            double actualMeasurement= convertor.unitConvertor(100,"cm","m");
            double expectedMeasurement = 1;
            assertEquals(expectedMeasurement,actualMeasurement);
        }

        @Test
        public void checkIfTwoMeterIsPointZeroZeroTwoKilometer(){
            double actualMeasurement= convertor.unitConvertor(2,"m","km");
            double expectedMeasurement = 0.002;
            assertEquals(expectedMeasurement,actualMeasurement);
        }

        @Test
        public void checkIfTenCentimeterIsPointZeroOneMeter(){
            double actualMeasurement= convertor.unitConvertor(10,"cm","m");
            double expectedMeasurement = 0.1;
            assertEquals(expectedMeasurement,actualMeasurement);
        }

        @Test
        public void throwsIllegalArgumentExceptionIfMeasurementIsNegative(){
            assertThrows(IllegalArgumentException.class,() -> {
                convertor.unitConvertor(-1,"cm","cm");});
        }

        @Test
        public void throwsIllegalArgumentExceptionIfMeasurementIsZero(){
            assertThrows(IllegalArgumentException.class,() -> {
                convertor.unitConvertor(0,"cm","cm");});
        }

        @Test
        public void throwsIllegalArgumentExceptionIfMeasurementIsInvalid(){
            assertThrows(IllegalArgumentException.class,() -> {
                convertor.unitConvertor(10,"mm","cm");});
        }
    }

    @Nested
    public  class ConversionOfWeightUnits{
        @Test
        public void checkIf(){
            double actualMeasurement= convertor.unitConvertor(1,"kg","g");
            double expectedMeasurement = 1000;
            assertEquals(expectedMeasurement,actualMeasurement);
        }

        @Test
        public void checkIfOneKilogram(){
            double actualMeasurement= convertor.unitConvertor(1,"g","kg");
            double expectedMeasurement = 0.001;
            assertEquals(expectedMeasurement,actualMeasurement);
        }

        @Test
        public void checkIfFiveHundredGramIsHalfKilogram(){
            double actualMeasurement= convertor.unitConvertor(500,"g","kg");
            double expectedMeasurement = 0.5;
            assertEquals(expectedMeasurement,actualMeasurement);
        }

        @Test
        public void checkIfZeroPointOneKilogramIsHundredGram(){
            double actualMeasurement= convertor.unitConvertor(0.1,"kg","g");
            double expectedMeasurement = 100;
            assertEquals(expectedMeasurement,actualMeasurement);
        }

        @Test
        public void checkIfHalfKilogramIsFiveHundredGram(){
            double actualMeasurement= convertor.unitConvertor(0.5,"kg","g");
            double expectedMeasurement = 500;
            assertEquals(expectedMeasurement,actualMeasurement);
        }

        @Test
        public void  checkIfOnePointFiveKilogramIsFifteenHundred(){
            double actualMeasurement = convertor.unitConvertor(1.5, "kg", "g");
            double expectedMeasurement = 1500;
            assertEquals(expectedMeasurement,actualMeasurement);
        }

        @Test
        public void checkIfTwoKilogramIsTwoThousandGram(){
            double actualMeasurement= convertor.unitConvertor(2,"kg","g");
            double expectedMeasurement = 2000;
            assertEquals(expectedMeasurement,actualMeasurement);
        }

        @Test
        public void checkIfTwoThousandGramIsTwoKilogram(){
            double actualMeasurement= convertor.unitConvertor(2000,"g","kg");
            double expectedMeasurement = 2;
            assertEquals(expectedMeasurement,actualMeasurement);
        }
    }

    @Nested
    public class ArithmaticOperationsOnUnits{
        @Test
        public void checkIfOneMeterPlusHundresCentimeterIsTwoMeter(){
            double actualMeasurement= convertor.add(1,"m",100,"cm");
            double expectedMeasurement = 2;
            assertEquals(expectedMeasurement,actualMeasurement);
        }

        @Test
        public void checkIfOneMeterMinusFiftyCentimeterIsZeroPointFiveMeterMeter(){
            double actualMeasurement= convertor.subtract(1,"m",50,"cm");
            double expectedMeasurement = 0.5;
            assertEquals(expectedMeasurement,actualMeasurement);
        }

        @Test
        public  void checkIfTwoHundredCentimeterPlusOneKilometerIsHundredThousandTwoHundredCentimeter(){
            double actualMeasurement = convertor.add(200,"cm",1,"km");
            double expectedMeasurement = 100200;
            assertEquals(expectedMeasurement,actualMeasurement);
        }

        @Test
        public void checkIfTwoThousandCentimeterMinusOneMeterIsNinteenHundredCentimeter(){
            double actualMeasurement= convertor.subtract(2000,"cm",1,"m");
            double expectedMeasurement = 1900;
            assertEquals(expectedMeasurement,actualMeasurement);
        }

        @Test
        public void checkIfFourThousandMeterMinuseTwoMeterIsTwoThousandMeter(){
            double actualMeasurement= convertor.subtract(4000,"m",2,"km");
            double expectedMeasurement = 2000;
            assertEquals(expectedMeasurement,actualMeasurement);
        }

        @Test
        public void checkIf4KilometerMinuseTwoKilometerIs2Kilometer(){
            double actualMeasurement= convertor.subtract(4,"km",2,"km");
            double expectedMeasurement = 2;
            assertEquals(expectedMeasurement,actualMeasurement);
        }
    }

    @Nested
    public class ArithmaticOperationsOnWeightUnit{

        @Test
        public  void checkIfTenGramPlusOneKiligramsIsOneThousandTen(){
            double actualMeasurement = convertor.add(10,"g",1,"kg");
            double expectedMeasurement = 1010;
            assertEquals(expectedMeasurement,actualMeasurement);
        }

        @Test
        public  void checkIfTenGramPlusOneKiligrams(){
            double actualMeasurement = convertor.subtract(1.5,"kg",500,"g");
            double expectedMeasurement = 1;
            assertEquals(expectedMeasurement,actualMeasurement);
        }
    }

}

