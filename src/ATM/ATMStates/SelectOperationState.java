package ATM.ATMStates;

import ATM.ATMRoomComponents.ATM;
import ATM.ATMRoomComponents.Card;

import java.util.Scanner;

public class SelectOperationState extends ATMState{
    public SelectOperationState(){
        System.out.println("Machine Select Operation State");
    }

    @Override
    public void selectAction(ATM atm, Card card){
        int selection;
        Scanner input = new Scanner(System.in);
        System.out.println("Press 1 for cash withdraw, press 2 for Balance check: ");
        selection = input.nextInt();
        switch (selection){
            case 1:
                atm.setATMState(new CashWithdrawalState());
                break;
            case 2:
                atm.setATMState(new CheckBalanceState());
                break;
            default:
                System.out.println("Invalid selection");
                returnCard(atm);
        }
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
