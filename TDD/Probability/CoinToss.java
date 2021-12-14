public class CoinToss {

    double possibleOutcomes = 2;
    public double probability(double favorableOutcomes, double possibleOutcomes) {
        if(favorableOutcomes == 0){
            throw new IllegalArgumentException("Favorable Outcomes Can't be Zero");
        }
        return favorableOutcomes/possibleOutcomes;
    }

    public double twoEventsOccurringTogether(double event1, double event2){
        return probability(event1, possibleOutcomes) * probability(event2, possibleOutcomes);
    }

    public double twoEventsNotOccurringTogether(double event1, double event2){
        if(event1 == 1) {
            return 1 - probability(event1, possibleOutcomes);
        }else{
            return 1 - probability(event2, possibleOutcomes);
        }
    }

    public double eitherEventsOccurring(double event1, double event2){
        return probability(event1, possibleOutcomes) + probability(event2, possibleOutcomes) - twoEventsOccurringTogether(event1, event2);
    }
}


/*
1. As a statistician, I want to be able to know that the probability of a heads in a coin
   toss is equal to the probability of a tails in a coin toss.
2. As a statistician, I want to be able to know the probability of two events occurring together.
   (1/2)*(1/2) -> 1/4 -> 0.25
3. As a statistician, I want to be able to know the probability of an event not occurring.
   1 - (1/2) -> 1/2
4. As a statistician, I want to be able to know the probability of either two events occurring.
   (1/2) + (1/2) - (1/4) -> 0.75


               Number of favorable outcomes        1
           ----------------------------------    -----
 P(H) =   total number of possible outcomes =     2
*/