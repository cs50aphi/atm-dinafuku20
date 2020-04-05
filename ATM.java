// Driver class for ATM
// Provides a menu of options for user

import java.util.Scanner;

public class ATM
{
    public static void main(String[] args)
    {
        // Instantiate Scanner and Checking/SavingsAccount objects
        Scanner in = new Scanner(System.in);
        CheckingAccount checking = new CheckingAccount(10);
        SavingsAccount savings = new SavingsAccount(100);

        // Initialize variables
        boolean done = false;
        int transaction = 0;

        // Greet user
        System.out.println("");
        System.out.println("Welcome to ATM!");

        // while done is false:
        while (!done)
        {
            // Display user prompt for (D)eposit, (W)ithdraw, (C)heck Balance, (T)ransfer, (Q)uit
            System.out.print("Would you like to: (D)eposit, (W)ithdraw, (C)heck Balance, (T)ransfer, (Q)uit? ");
            String response = in.nextLine();
            int choice;
            int amount;
            // switch based on respone
            switch (response)
            {
                // "D" or "d" prompt user to choose either their checking or savings, ask deposit amount, add to the specified account, add operation costs
                case "D":
                case "d":
                    System.out.print("Deposit to: (1)Checking or (2)Savings? ");
                    choice = in.nextInt();
                    System.out.print("How many credits do you want to deposit? ");
                    amount = in.nextInt();
                    if (choice == 1)
                    {
                        checking.deposit(amount);
                    }
                    else if (choice == 2)
                    {
                        savings.deposit(amount);
                    }
                    System.out.println("Your checking account has " + checking.getBalance() + " credits.");
                    System.out.println("Your savings account has " + savings.getBalance() + " credits.");
                    transaction++;
                    break;
                case "W":
                case "w":
                    System.out.print("Withdraw from: (1)Checking or (2)Savings? ");
                    choice = in.nextInt();
                    System.out.print("How many credits do you want to withdraw? ");
                    amount = in.nextInt();
                    if (choice == 1 && amount > checking.getBalance())
                    {
                        System.out.println("Insufficient funds.");
                    }
                    else if (choice == 2 && amount > savings.getBalance())
                    {
                        System.out.println("Insufficient funds.");
                    }
                    else
                    {
                        if (choice == 1)
                        {
                            checking.withdraw(amount);
                        }
                        else if (choice == 2)
                        {
                            savings.withdraw(amount);
                        }
                        System.out.println("Your checking account has " + checking.getBalance() + " credits.");
                        System.out.println("Your savings account has " + savings.getBalance() + " credits.");
                        transaction++;
                    }
                    break;
                case "C":
                case "c":
                    System.out.println("Your checking account has " + checking.getBalance() + " credits.");
                    System.out.println("Your savings account has " + savings.getBalance() + " credits.");
                    transaction++;
                    break;
                case "T":
                case "t":
                    System.out.print("Transfer from: (1)Checking to Savings or (2) Savings to Checking? ");
                    choice = in.nextInt();
                    System.out.print("Amount to transfer? ");
                    amount = in.nextInt();
                    if (choice == 1 && amount > checking.getBalance())
                    {
                        System.out.println("Insufficient funds.");
                    }
                    else if (choice == 2 && amount > savings.getBalance())
                    {
                        System.out.println("Insufficient funds.");
                    }
                    else
                    {
                        if (choice == 1)
                        {
                            checking.withdraw(amount);
                            savings.deposit(amount);
                        }
                        else if (choice == 2)
                        {
                            savings.withdraw(amount);
                            checking.deposit(amount);
                        }
                        System.out.println("Your checking account has " + checking.getBalance() + " credits.");
                        System.out.println("Your savings account has " + savings.getBalance() + " credits.");
                        transaction++;
                    }
                    break;
                case "Q":
                case "q":
                    done = true;
                    break;
            }
            System.out.println(transaction);
            if (transaction == 5)
            {
                savings.interest();
                System.out.println("Interest calculated!");
                System.out.println("Your checking account has " + checking.getBalance() + " credits.");
                System.out.println("Your savings account has " + savings.getBalance() + " credits.");
                transaction = 0;
            }
        }

    }
}