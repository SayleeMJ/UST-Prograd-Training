import java.util.Scanner;

class BankDetails{
    private String acc_no;
    private String name;
    private String acc_type;
    private long balance;

    Scanner s = new Scanner(System.in); // Created object of scanner 's'

    //  Add new details
    public void basic_details(){
        System.out.println("Enter Account No.: ");
        acc_no = s.next();
        System.out.println("Enter Account type: ");
        acc_type = s.next();
        System.out.println("Enter Name: ");
        name = s.next();
        System.out.println("Enter Balance: ");
        balance = s.nextLong();
        System.out.println("\n");
    }

    // Display the details.
    public void showAccount() {
        System.out.println("Name of account holder: " + name);
        System.out.println("Account no.: " + acc_no);
        System.out.println("Account type: " + acc_type);
        System.out.println("Balance: " + balance);
        System.out.println("\n");
    }

    // deposit amount
    public void deposit(){
        long amount;
        System.out.println("Enter the amount you want to deposit: ");
        amount = s.nextLong();
        balance += amount; // Adding deposited amount in balance so we get new balance amount
        System.out.println("Balance after deposit " + balance);
    }

    public void withdrawal(){
        long amount;
        System.out.println("Enter the amount you want to withdraw: ");
        amount = s.nextLong();
        if(balance >= amount){ // Checking if amount is valid or not to withdraw
            balance -= amount;  // deducting the amount
            System.out.println("Balance after withdraw: " + balance);
        }else{
            System.out.println("Your balance is less than" + amount + "\tTransaction failed..!");
        }
    }

    public boolean search(String ac_no){
        if(acc_no.equals(ac_no)){ // Searching if account is valid or not
            showAccount();
            return(true);
        }
        return(false);
    }
}

public class BankAccount {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("How many number of customers do you want to add: ");
        int n = sc.nextInt();
        BankDetails[] bd = new BankDetails[n]; // Passing the n value in object array

        for(int i=0; i<bd.length; i++){ // for loop will loop till n value
            bd[i] = new BankDetails();  // create a new object and assign to i
            bd[i].basic_details(); // calling function
        }

        // Displaying operations to be performed
        int ch;
        do{
            System.out.println("\n--Bank Details--");
            System.out.println("\n1. Display Account Details\n2. Deposit the amount\n3. Withdraw the amount\n4.Exit  ");
            System.out.println("Enter your choice: ");
            ch = sc.nextInt();

            switch (ch){
                case 1: // Displaying the details
                    for (BankDetails bankDetails : bd) {
                        bankDetails.showAccount();
                    }
                    break;

                case 2: // deposit amount
                    System.out.println("Enter Account No.: ");
                    String ac_no = sc.next();
                    boolean flag = false; // setting the flag false
                    for (BankDetails bankDetails : bd) {
                        flag = bankDetails.search(ac_no); // initializing flag whether true or false
                        if (flag) {
                            bankDetails.deposit(); // if true then call deposit()
                            break;

                        }
                    }
                    if(!flag){  // if not true
                        System.out.println("Account doesn't exists...!");
                    }
                    break;

                case 3:
                    System.out.println("Enter Account No.: ");
                    ac_no = sc.next();
                    flag = false; // setting the flag false
                    for (BankDetails bankDetails : bd) {
                        flag = bankDetails.search(ac_no); // initializing flag whether true or false
                        if (flag) {
                            bankDetails.withdrawal();  // if true then call withdrawal()
                            break;
                        }
                    }
                    if(!flag){ // if not true
                        System.out.println("Account doesn't exists...!");
                    }
                    break;

                case 4:
                    System.out.println("See you again...");
                    break;

                default:
                    System.out.println("Invalid Choice..");
            }
        }while(ch!=4);
    }
}
