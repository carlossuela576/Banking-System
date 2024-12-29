import java.util.Scanner;

//This is a simple banking system that allows users to create an account, sign in, deposit, withdraw and logout.

public class BankingSystem {
    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);

        //account creation
        System.out.println("WELCOME! create an account");
        
        //fake data
        long accountNum;
        long pinCode;
        double bankAmount = 0;

        System.out.print("Enter your account number: ");
        accountNum = sc.nextLong();
        System.out.print("Enter your PIN code: ");
        pinCode = sc.nextLong();


        //Account/sign in authentication
        boolean isAuthenticated = false;
        System.out.println("Sign in to your account");
        System.out.println("-------------------------");

        for (int i = 3; i >= 0; i--) {
            System.out.print("Please enter your account number: ");
            long inaccountNum = sc.nextLong();
            System.out.print("Please enter your PIN code: ");
            long inpinCode = sc.nextLong();

            
            if (inaccountNum == accountNum && inpinCode == pinCode){
                isAuthenticated = true;
                System.out.println("You have successfully logged in");
                break;
            }
            else{
                System.out.println("Invalid account number or PIN code, please try again");
                System.out.println("You have " + i + " attempts left");
            }
        }

        //Landing page
        while (isAuthenticated) { 
            System.out.println("---------------------");
            System.out.println("WELCOME!!");
            System.out.println("Your account balance is: " + bankAmount);
            System.out.println("---------------------");
            System.out.println("Choose your transaction:");
            System.out.println("(1) Deposit" + "\n" + "(2) Withdraw" + "\n" + "(3) Logout");
            int userTransac = sc.nextInt();

            switch (userTransac){
                case 1:
                    System.out.println("---------------------");
                    System.out.print("Enter the amount you want to deposit: ");
                    double userDeposit = sc.nextDouble();
                    System.out.println("Are you sure you want to deposit an amount of " + userDeposit);
                    System.out.println("Your account balance is " + bankAmount);
                    System.out.println("(1) Yes" + "\n" + "(2) No");
                    int userChoiceD = sc.nextInt();
                    if (userChoiceD == 1){
                        bankAmount += userDeposit;
                        System.out.println("Your new account balance is " + bankAmount);
                    }
                    else if (userChoiceD == 2){
                        System.out.println("Have a nice day!");
                    }
                    else{
                        System.out.println("Out of parameters");
                    }
                    break;
                case 2:
                    System.out.println("---------------------");
                    System.out.print("Enter the amount you want to withdraw: ");
                    double userWithdraw = sc.nextDouble();
                    System.out.println("Are you sure you want to withdraw an amount of " + userWithdraw);
                    System.out.println("Your account balance is " + bankAmount);
                    System.out.println("(1) Yes" + "\n" + "(2) No");
                    int userChoiceW = sc.nextInt();
                    if (userChoiceW == 1){
                        //error handling, does not allow user to withdraw amounts bigger than their account balance.
                        if( bankAmount > userWithdraw){
                            bankAmount -= userWithdraw;
                            System.out.println("Your new account balance is " + bankAmount);
                        }
                        else{
                            System.out.println("Insufficient funds, please try again");
                        }
                        
                    }
                    else if (userChoiceW == 2){
                        System.out.println("Have a nice day!");
                    }
                    else{
                        System.out.println("Out of parameters");
                    }
                    break;
                case 3:
                    System.out.println("Logging out....");
                    isAuthenticated = false;
                    System.out.println("Logged out, thank you for using ATM");
                    break;
                default:
                    System.out.println("Out of parameters, please try again.");
            }

        }
        sc.close();

    }
}