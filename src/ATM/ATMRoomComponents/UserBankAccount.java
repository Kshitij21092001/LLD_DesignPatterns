package ATM.ATMRoomComponents;

public class UserBankAccount {
    int balance;
    int accountNumber;

    public  UserBankAccount(int balance, int accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public void withDrawAmount(int amount) {
        this.balance -= amount;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return this.balance;
    }
}
