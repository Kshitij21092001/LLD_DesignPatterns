package ATM.ATMStates;

import ATM.ATMRoomComponents.ATM;
import ATM.ATMRoomComponents.Card;

import java.util.Scanner;

public class HasCardState extends ATMState{
    public HasCardState(){
        System.out.println("Machine is in Has Card State.");
    }

    @Override
    public void authenticate(ATM atm, Card card){
        int pin=0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter pin: ");
        pin = sc.nextInt();
        int attempts = 3;
        while(!card.isPinCorrect(pin) && attempts!=0){
            System.out.print("Enter pin again: ");
            pin = sc.nextInt();
            attempts--;
            System.out.println("Incorrect pin! Attempts remaining: "+attempts);
        }
        if(card.isPinCorrect(pin)){
            System.out.println("Card has been successfully authenticated!");
            atm.setATMState(new SelectOperationState());
        }
        else{
            System.out.println("Card has been blocked!");
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
