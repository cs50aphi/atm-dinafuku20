public class SavingsAccount
{
    // Instance variables
    private int balance;
    private double interestRate = .1;

    // Constructors
    public SavingsAccount()
    {
        balance = 0;
    }
    public SavingsAccount(int startingBalance)
    {
        balance = startingBalance;
    }

    // Methods
    public int getBalance()
    {
        return balance;
    }
    public void deposit(int amount)
    {
        balance += amount;
    }
    public void withdraw(int amount)
    {
        balance -= amount;
    }
    public void interest()
    {
        balance = balance + (int)(balance*interestRate);
    }
}