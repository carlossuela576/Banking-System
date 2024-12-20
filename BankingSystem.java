import java.util.Scanner;

/*adjustments to be made----
 * dynamic accounts, enabling users to create accounts
 * error-handling, not allowing users to withdraw when withdraw balance was greater than (>) bankAmount
 * use arrays as temporary storage
 */

/*adjustments made 12-17-24
 * dynamic accounts, this enables users to create an account and use it as a login info
 * used an array as temporary storage
 * 
 * Problems:
 * was planning to put the "fake data" code segment in a loop or selective statements to check if an array is empty or not, if it's empty 
 * (or the user didn't input any value in the fields) the program would supposedly not proceed to the sign-in code block. The problem is
 * that variables inside loops cannot be referenced outside or after that loop (as per the rule of procedural programming).
 * Still finding a way to make it work, Lord please help me.
 * 
 * adjustments made 12-20-24
 * error-handling, not allowing users to withdraw when withdraw balance was greater than (>) bankAmount
 */

public class BankingSystem {
    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);

        //account creation
        System.out.println("WELCOME! create an account");
        
        //fake data
        System.out.print("Enter number of accounts: ");
        int numofAcc = sc.nextInt();

        long accountNum[] = new long[numofAcc];
        long pinCode[] = new long[numofAcc];
        double bankAmount = 0;

        for (int i = 0; i < numofAcc; i++) {
            System.out.print("Enter account number " + (i+1) + ": ");
            accountNum[i] = sc.nextLong();
            
            System.out.print("Enter PIN code " + (i+1) + ": ");
            pinCode[i] = sc.nextLong();
        }


        //Account/sign in authentication
        boolean isAuthenticated = false;

        for (int i = 2; i >= 0; i--) {
            System.out.print("Please enter your account number: ");
            long inaccountNum = sc.nextLong();
            System.out.print("Please enter your PIN code: ");
            long inpinCode = sc.nextLong();

            
            for (int j = 0; j < numofAcc; j++){
                if (inaccountNum == accountNum[j] && inpinCode == pinCode[j]){
                    isAuthenticated = true;
                    System.out.println("Access granted!");
                    break;
                }
                else {
                    System.out.println("Invalid account number or PIN code, please try again" + "\n" +"Attempts left: " + i);
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