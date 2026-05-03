package ATM.ATMStates;

import ATM.ATMRoomComponents.ATM;
import ATM.ATMRoomComponents.Card;
import ATM.Enums.TransactionType;

public abstract class ATMState {
    public boolean transactionSuccess = true;
    public void insertCard(ATM atm, Card card){
        System.out.println("Something went wrong!");
    }

    public void authenticate(ATM atm, Card card){
        System.out.println("Something went wrong!");
    }

    public void selectAction(ATM atm, Card card){
        System.out.println("Something went wrong!");
    }

    public void cashWithdrawal(ATM atm, Card card){
        System.out.println("Something went wrong!");
    }

    public void displayBalance(ATM atm, Card card){
        System.out.println("Something went wrong!");
    }

    public void returnCard(ATM atm){
        System.out.println("Something went wrong!");
    }

    public void exit(ATM atm){
        System.out.println("Something went wrong!");
    }

    public void setTransactionSuccess(boolean transactionSuccess){
        this.transactionSuccess = transactionSuccess;
    }
}
