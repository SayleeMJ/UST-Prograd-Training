import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoinTossTest {
    CoinToss coinToss = new CoinToss();
    @Test
    @DisplayName("CHECKING PROBABILITY OF TAILS AND HEADS IS EQUAL")
    public void checkIfHeadProbabilityIsEqualToTailProbabilityInCoinToss(){
        double actualCoin = coinToss.probability(1,2);
        double expectedCoin = 0.5;
        assertEquals(expectedCoin, actualCoin);
    }

    @Test
    @DisplayName("CHECKING TWO PROBABILITIES OCCURRING TOGETHER")
    public void checkIfProbabilityOfTwoEventsOccurringTogetherInCoinToss(){
        double actualCoin = coinToss.twoEventsOccurringTogether(1,1);
        double expectedCoin = 0.25;
        assertEquals(expectedCoin, actualCoin);
    }

    @Test
    @DisplayName("CHECKING PROBABILITY WHEN ONLY FIRST EVENT OCCUR")
    public void checkIfProbabilityOfFirstEventOccurringInCoinToss(){
        double actualCoin = coinToss.twoEventsNotOccurringTogether(1,0);
        double expectedCoin = 0.5;
        assertEquals(expectedCoin, actualCoin);
    }
    @Test
    @DisplayName("CHECKING PROBABILITY WHEN ONLY SECOND EVENT OCCUR")
    public void checkIfProbabilityOfSecondEventsOccurringInCoinToss(){
        double actualCoin = coinToss.twoEventsNotOccurringTogether(0,1);
        double expectedCoin = 0.5;
        assertEquals(expectedCoin, actualCoin);
    }

    @Test
    @DisplayName("CHECKING PROBABILITY WHEN EITHER OF EVENTS OCCUR")
    public void checkIfProbabilityOfEitherEventsOccurringInCoinToss(){
        double actualCoin = coinToss.eitherEventsOccurring(1,1);
        double expectedCoin = 0.75;
        assertEquals(expectedCoin, actualCoin);
    }

    @Test
    @DisplayName("THROWING EXCEPTION WHEN FAVORABLE OUTCOME IS ZERO")
    public void checkIfFavorableOutcomeIsZero(){
        assertThrows(IllegalArgumentException.class, () -> {
            coinToss.probability(0,2);
        });
    }
}