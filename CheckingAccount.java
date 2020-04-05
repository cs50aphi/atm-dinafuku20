public class CheckingAccount
{
    // Instance variables
    private int balance;

    // Constructors
    public CheckingAccount()
    {
        balance = 0;
    }
    public CheckingAccount(int startingBalance)
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
}