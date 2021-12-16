import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CLASS CURRENCY CONVERSION TEST")
class CurrencyConvertorTest {
    CurrencyConvertor currencyConvertor = new CurrencyConvertor();

    @Nested
    @DisplayName("CLASS FOR CONVERSION TESTING")
    class conversionTest{

        @Test
        @DisplayName("CONVERTING ₹ 74.85 TO $ 1")
        public void checkIfSeventyFourPointEightyFiveRupeesIsOneDollar(){
            double actualCurrency = currencyConvertor.currencyConvertor(74.85, "INR", "USD");
            double expectedCurrency = 1;
            assertEquals(expectedCurrency, actualCurrency);
        }

        @Test
        @DisplayName("CONVERTING $ 1 TO ₹ 74.85")
        public void checkIfOneDollarIsSeventyFourPointEightyFiveRupees(){
            double actualCurrency = currencyConvertor.currencyConvertor(1, "USD", "INR");
            double expectedCurrency = 74.85;
            assertEquals(expectedCurrency, actualCurrency);
        }

        @Test
        @DisplayName("CONVERTING $ 2 TO ₹ 149.7")
        public void checkIfTwoDollarsIsOneHundredFortyNinePointSeven(){
            double actualCurrency = currencyConvertor.currencyConvertor(2, "USD", "INR");
            double expectedCurrency = 149.7;
            assertEquals(expectedCurrency, actualCurrency);
        }
    }

    @Nested
    @DisplayName("CLASS FOR ADDITION OF CURRENCY TESTING")
    class additionOfCurrency {

        @Test
        @DisplayName("CHECKING IF ₹ 50 + $ 1 = ₹ 124.85 ")
        public void checkSumOfRupeesAndDollarGivesInRupees() {
            double actualAmount = 50 + currencyConvertor.currencyConvertor(1, "USD", "INR");
            double expectedAmount = 124.85;
            assertEquals(expectedAmount, actualAmount);
        }

        @Test
        @DisplayName("CHECKING IF $ 1 + ₹ 74.85 = $4 ")
        public void checkSumOfRupeesAndDollarGivesInDollar() {
            double actualAmount = 1 + currencyConvertor.currencyConvertor(74.85, "INR", "USD") + currencyConvertor.currencyConvertor(149.7, "INR", "USD");
            double expectedAmount = 4;
            assertEquals(expectedAmount, actualAmount);
        }
    }

    @Nested
    @DisplayName("CLASS FOR DEPOSIT TESTING")
    class depositTest {

        @Test
        @DisplayName("CHECKING ₹ 149.7 IS DEPOSITED IN FORM OF $ 2 ")
        public void checkIfDepositAmountInDollarAddedToWallet() {
            assertEquals(2, currencyConvertor.depositAmount(149.7, "USD"));
        }

        @Test
        @DisplayName("CHECKING MULTIPLE DEPOSITS IN FORM OF $ TO ₹")
        public void checkMultipleDepositAmountInRupeeIntoWallet() {
            assertEquals(374.25, currencyConvertor.depositAmount(5, "INR"));
            assertEquals(1122.75, currencyConvertor.depositAmount(10, "INR"));
        }


        @Test
        @DisplayName("CHECKING MULTIPLE DEPOSITS IN FORM OF ₹ TO $")
        public void checkMultipleDepositAmountInDollarIntoWallet() {
            assertEquals(2, currencyConvertor.depositAmount(149.7, "USD"));
            assertEquals(4, currencyConvertor.depositAmount(149.7, "USD"));
        }
    }

    @Nested
    @DisplayName("CLASS FOR WITHDRAW TESTING")
    class withdrawTest {

        @Test
        @DisplayName("WITHDRAWING AMOUNT IN FORM OF ₹ TO $")
        public void withdrawAmountInDollarFromWallet() {
            assertEquals(2, currencyConvertor.depositAmount(149.7, "USD"));
            assertEquals(1, currencyConvertor.withdrawAmount(1));
        }

        @Test
        @DisplayName("WITHDRAWING AMOUNT IN FORM OF $ TO ₹")
        public void withdrawAmountInRupeeFromWallet() {
            assertEquals(149.7, currencyConvertor.depositAmount(2, "INR"));
            assertEquals(74.85, currencyConvertor.withdrawAmount(74.85));
        }

        @Test
        @DisplayName("THROW EXCEPTION WHEN INPUT IS INVALID ")
        public void throwsExceptionWhenUnitIsInvalidUnit() {
            assertThrows(IllegalArgumentException.class, () -> {
                currencyConvertor.withdrawAmount(2);
            });
        }
    }

    @Nested
    @DisplayName("CLASS FOR GETTING BALANCE TESTING")
    class getBalanceTest{

       @Test
       @DisplayName("CHECKING WALLET BALANCE")
        public void checkWalletBalance(){
            assertEquals(2, currencyConvertor.depositAmount(149.7, "USD"));
            assertEquals(2,currencyConvertor.getBalAmount());
        }
    }
}