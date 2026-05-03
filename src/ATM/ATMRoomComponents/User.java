package ATM.ATMRoomComponents;

public class User {
    private Card card;
    private UserBankAccount bankAccount;

    public User(Card card, UserBankAccount bankAccount){
        this.card = card;
        this.bankAccount = bankAccount;
    }

    public Card getCard() {
        return this.card;
    }

    public UserBankAccount getBankAccount() {
        return this.bankAccount;
    }
}
