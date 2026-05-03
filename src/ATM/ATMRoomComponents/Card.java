package ATM.ATMRoomComponents;

public class Card {
    UserBankAccount account;
    int cardNumber;
    int cvv;
    private int pin;

    public Card(UserBankAccount account, int cardNumber, int pin){
        this.account = account;
        this.cardNumber = cardNumber;
        this.pin = pin;
    }

    public boolean isPinCorrect(int pin){
        return this.pin==pin;
    }

    public void withDraw(int amount){
        account.withDrawAmount(amount);
    }

    public int getBalance(){
        return account.getBalance();
    }

    public void setBankAccount(UserBankAccount account){
        this.account = account;
    }

    public void changePin(int pin){
        this.pin = pin;
    }
}
