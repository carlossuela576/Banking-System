import java.util.Scanner;

public class BankingSystem {
    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);

        //account creation
        System.out.println("WELCOME! create an account");
        
        //fake data
        long accountNum[] = {0, 0, 0, 0, 0};
        long pinCode[] = {0, 0, 0, 0, 0};
        double bankAmount = 0;

        //account initialization & selection
        boolean accInit = true;
        int choiceRep = 0;

        while(accInit){
            //input for account creation
            System.out.print("Enter account number: ");
            accountNum[choiceRep] = sc.nextLong();

            System.out.print("Enter PIN code: ");
            pinCode[choiceRep] = sc.nextLong();
            choiceRep++;
            
            //fill up input buffer from previous integer input
            //DON'T REMOVE THIS, removing would cause skipping on the "initChoice" input
            sc.nextLine();

            //selection for another account creation or not
            System.out.println("Would you like to create another account? \n(y) yes \n(n) no");
            String initChoice = sc.nextLine();

            if(initChoice.equalsIgnoreCase("y")){
                accInit = true;
            }
            else{
                accInit = false;
            }
        }


        //Account/sign in authentication
        boolean isAuthenticated = false;

        for (int i = 5; i >= 0; i--) {
            System.out.print("Please enter your account number: ");
            long inaccountNum = sc.nextLong();
            System.out.print("Please enter your PIN code: ");
            long inpinCode = sc.nextLong();

            
            for (int j = 0; j < choiceRep; j++){
                if (inaccountNum == accountNum[j] && inpinCode == pinCode[j]){
                    isAuthenticated = true;
                    System.out.println("Access granted!");
                    break;
                }
                else {
                    System.out.println("Invalid account number or PIN code, please try again \nAttempts left: " + i);
                }
            }

            if (isAuthenticated){
                break;
            }
        }

        //Landing page
        while (isAuthenticated) { 
            System.out.println("---------------------");
            System.out.println("WELCOME!!");
            System.out.println("Your account balance is: " + bankAmount);
            System.out.println("---------------------");
            System.out.println("Choose your transaction:");
            System.out.println("(1) Deposit \n(2) Withdraw \n(3) Logout");
            int userTransac = sc.nextInt();

            switch (userTransac){
                case 1:
                    System.out.println("---------------------");
                    System.out.print("Enter the amount you want to deposit: ");
                    double userDeposit = sc.nextDouble();
                    System.out.println("Are you sure you want to deposit an amount of " + userDeposit);
                    System.out.println("Your account balance is " + bankAmount);
                    System.out.println("(1) Yes \n(2) No");
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
                    System.out.println("(1) Yes \n(2) No");
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