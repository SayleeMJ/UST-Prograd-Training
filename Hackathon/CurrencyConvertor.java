import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

class InvalidCurrency extends Exception{
    public InvalidCurrency(String message){
        super(message);
    }
}

public class CurrencyConvertor {
    public static void main(String[] args) throws InvalidCurrency, IOException {
        double dollar, rupee, euro, pound, yen;
        double amount;
        int code;
        DecimalFormat format = new DecimalFormat("#.##");
        Scanner scanner = new Scanner(System.in);

        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;
            fh = new FileHandler("log.txt");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            logger.info("Program Started");

            System.out.println("--Currency Calculator--");
            do {

                System.out.println("Enter amount you want to convert: ");
                amount = scanner.nextDouble();
                logger.info("User entered amount "+amount);
                if (amount <=0){
                    throw new InvalidCurrency("Invalid Currency");
                }
                System.out.println("Currency options:-  \n");
                System.out.println("1. Rupees\n2. Dollar\n3. Euro\n4. Pound\n5. Yen\n");
                System.out.println("Which currency you want to convert: ");
                code = scanner.nextInt();

                switch (code) {
                    case 1 -> { // rupees to other conversion
                           logger.info("User selected INR ");
                           System.out.println("Your amount " + amount + " rupees");

                           dollar = amount / 76.08;
                           System.out.println("In Dollar: " + format.format(dollar) + " dollar");

                           pound = amount / 100.71;
                           System.out.println("In Pound: " + format.format(pound) + " pound");

                           euro = amount / 85.69;
                           System.out.println("In Euro: " + format.format(euro) + " euro");

                           yen = amount / 0.67;
                           System.out.println("In Yen: " + format.format(yen) + " yen");
                    }
                    case 2 -> { //dollar to other conversion
                        logger.info("User selected USD");
                        System.out.println("Your amount " + amount + " Dollar");

                        rupee = amount * 76.08;
                        System.out.println("In Dollar: " + format.format(rupee) + " rupees");

                        pound = amount * 0.76;
                        System.out.println("In Pound: " + format.format(pound) + " pound");

                        euro = amount * 0.89;
                        System.out.println("In Euro: " + format.format(euro) + " euro");

                        yen = amount * 113.75;
                        System.out.println("In Yen: " + format.format(yen) + " yen");
                    }
                    case 3 -> { //euro to other conversion
                        logger.info("User selected Euro");
                        System.out.println("Your amount " + amount + " Euro");

                        rupee = amount * 85.68;
                        System.out.println("In Rupee: " + format.format(rupee) + " rupees");

                        dollar = amount * 1.13;
                        System.out.println("In Dollar: " + format.format(dollar) + " dollar");

                        pound = amount * 0.85;
                        System.out.println("In Pound: " + format.format(pound) + " pound");

                        yen = amount * 128.11;
                        System.out.println("In Yen: " + format.format(yen) + " yen");
                    }
                    case 4 -> { // pound to other conversion
                        logger.info("User selected POUND");
                        System.out.println("Your amount " + amount + " Pound");

                        rupee = amount * 100.70;
                        System.out.println("In Rupee: " + format.format(rupee) + " rupees");

                        dollar = amount * 1.32;
                        System.out.println("In Dollar: " + format.format(dollar) + " dollar");

                        euro = amount * 1.18;
                        System.out.println("In Euro: " + format.format(euro) + " euro");

                        yen = amount * 150.55;
                        System.out.println("In Yen: " + format.format(yen) + " yen");
                    }
                    case 5 -> { // yen to other conversion
                        logger.info("User selected YEN");
                        System.out.println("Your amount " + amount + " Yen");

                        rupee = amount * 0.67;
                        System.out.println("In Rupee: " + format.format(rupee) + " rupees");

                        dollar = amount * 0.0088;
                        System.out.println("In Dollar: " + format.format(dollar) + " dollar");

                        euro = amount * 0.67;
                        System.out.println("In Euro: " + format.format(euro) + " euro");

                        pound = amount * 0.0066;
                        System.out.println("In Pound: " + format.format(pound) + " pound");
                    }
                    default -> {
                        logger.info("Program Ended");
                        if (code>5){
                            throw new InvalidCurrency("Invalid Currency");
                        }
                    }
                }
            } while (code!=5);
    }

}
