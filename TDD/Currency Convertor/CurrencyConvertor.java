public class CurrencyConvertor {
    private double balAmount = 0;
    public double currencyConvertor(double currency, String fromCurrency, String toCurrency){
        if(currency<=0){
            throw new IllegalArgumentException("Currency can't be zero or negative");
        }else{
            return switch(toCurrency){
                case "INR" -> rupeesToDollar(currency, fromCurrency);
                case  "USD" -> dollarToRupees(currency, fromCurrency);
                default -> throw new IllegalStateException("Unexpected value: " + toCurrency);
            };
        }
    }

    public double rupeesToDollar(double currency, String fromCurrency){
        return switch (fromCurrency){
            case "INR" -> currency;
            case "USD" -> currency * 74.85;
            default -> throw new IllegalStateException("Unexpected value: " + fromCurrency);
        };
    }

    public  double dollarToRupees(double currency, String fromCurrency){
        return switch (fromCurrency){
            case "INR" -> currency / 74.85;
            case "USD" -> currency;
            default -> throw new IllegalStateException("Unexpected value: " + fromCurrency);
        };
    }

    public double depositAmount(double amount, String toAmount) {
        switch (toAmount) {
            case "INR":
                this.balAmount = this.balAmount + currencyConvertor(amount,"USD", "INR");
                return balAmount;
            case "USD":
                this.balAmount = this.balAmount + currencyConvertor(amount,"INR", "USD");
                return balAmount;
        }
        return 0;
    }

    public double withdrawAmount(double amount) {
        if(balAmount<amount){
            throw new IllegalArgumentException("No Sufficient balance");
        }
        return  balAmount - amount;
    }

    public double getBalAmount(){
        return balAmount;
    }
}


/*
1. As a wallet owner, I would like to be able to know that 74.85 rupees is equal to 1 dollar. (74.85/74.85 = 1)
2. As a wallet owner I would like to be able to put money into my wallet so that I can take it out later.
3. As a wallet owner, I want to know the total money my wallet has for the preferred currency. When Rs.50 & $1
   added to my wallet, Then the sum of money in the wallet is Rs.124.85, (Given preferred currency is Rs.)
4. As a wallet owner, I want to know the total money my wallet has for the preferred currency.
   When Rs.74.85, $1, Rs.149.7 added to my wallet, Then sum of money in the wallet is $4,
   (Given preferred currency is $)
5. As a wallet owner I would like to be able to take a specified amount of money out of the wallet.

1000/74.85 = dollar...... dollar/rupees = dollar

1000 dollar * 74.85 rupees = rupees

1 * 74.85 = 74.85 rupees .......dollar * rupees = dollar
*/