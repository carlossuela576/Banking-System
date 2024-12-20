import java.util.Scanner;

/*adjustments to be made----
 * dynamic accounts, enabling users to create accounts
 * error-handling, not allowing users to withdraw when balance was below 0
 * use arrays as temporary storage
 */

public class BankingSystem {
    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);

        //fake data
        long accountNum = 7898754L;
        long pinCode = 33499845L;
        double bankAmount = 0;

        //Account/sign in authentication
        boolean isAuthenticated = false;

        for (int i = 2; i >= 0; i--) {
            System.out.print("Please enter your account number: ");
            long inaccountNum = sc.nextLong();
            System.out.print("Please enter your PIN code: ");
            long inpinCode = sc.nextLong();

            if (inaccountNum == accountNum && inpinCode == pinCode){
                isAuthenticated = true;
                System.out.println("Access granted!");
                break;
            }
            else {
                System.out.println("Invalid account number or PIN code, please try again" + "\n" +"Attempts left: " + i);
            }
        }

        //Landing page
        while (isAuthenticated) { 
            System.out.println("---------------------");
            System.out.println("WELCOME!!");
            System.out.println("Your account balance is: " + bankAmount);
            System.out.println("---------------------");
            System.out.println("Choose your transaction:");
            System.out.println("(1) Deposit" + "\n" + "(2) Withdraw" + "\n" + "(3) Back" + "\n" + "(4) Logout");
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
                        bankAmount -= userWithdraw;
                        System.out.println("Your new account balance is " + bankAmount);
                    }
                    else if (userChoiceW == 2){
                        System.out.println("Have a nice day!");
                    }
                    else{
                        System.out.println("Out of parameters");
                    }
                    break;
                case 3:
                    System.out.println("Redirecting to landing page....");
                    break;
                case 4:
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