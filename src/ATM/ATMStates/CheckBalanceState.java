package ATM.ATMStates;

import ATM.ATMRoomComponents.ATM;
import ATM.ATMRoomComponents.Card;

public class CheckBalanceState extends ATMState{
    public CheckBalanceState() {
        System.out.println("ATM is in Check Balance State");
    }

    @Override
    public void displayBalance(ATM atm, Card card){
        System.out.println("Your account balance is "+ card.getBalance());
        returnCard(atm);
    }

    @Override
    public void returnCard(ATM atm){
        System.out.println("Please collect your card");
        exit(atm);
    }

    @Override
    public void exit(ATM atm){
        atm.setATMState(new IdleState());
        System.out.println("Machine is in Idle State.");
    }
}
