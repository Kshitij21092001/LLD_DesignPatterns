package ATM.ATMStates;

import ATM.ATMRoomComponents.ATM;
import ATM.ATMRoomComponents.Card;

public class IdleState extends ATMState{
    public IdleState(){
        System.out.println("ATM is in Idle state");
    }

    @Override
    public void insertCard(ATM atm, Card card){
        System.out.println("Card has been inserted" + card.getBalance());
        atm.setATMState(new HasCardState());
    }
}
