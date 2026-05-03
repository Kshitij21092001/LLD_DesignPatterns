package ATM.ATMRoomComponents;

import ATM.ATMStates.ATMState;
import ATM.ATMStates.IdleState;

public class ATM {
    private ATMState state;
    private int ATMBalance=0;
    private int twoThousandNotes=0;
    private int fiveHundredNotes=0;
    private int hundredNotes=0;

    private static ATM atmObj = new ATM(); //Singleton : eager initialization

    public static ATM getATMObj(){
        atmObj.setATMState(new IdleState());
        return atmObj;
    }

    public void setATMState(ATMState state){
        this.state = state;
    }

    public ATMState getATMState(){
        return this.state;
    }

    public void setATMBalance(int fiveHundredNotes, int hundredNotes, int twoThousandNotes){
        this.hundredNotes+=hundredNotes;
        this.fiveHundredNotes+=fiveHundredNotes;
        this.twoThousandNotes+=twoThousandNotes;
        this.ATMBalance+=(this.hundredNotes*100+this.fiveHundredNotes*500+this.twoThousandNotes*2000);
    }

    public int getATMBalance(){
        return this.ATMBalance;
    }

    public int getFiveHundredNotes(){
        return this.fiveHundredNotes;
    }

    public int getHundredNotes(){
        return this.hundredNotes;
    }

    public int getTwoThousandNotes(){
        return this.twoThousandNotes;
    }

    public void deductATMBalance(int amount){
        this.ATMBalance-=amount;
    }

    public void deduceTwoThousandNotes(int number){
        this.twoThousandNotes-=number;
    }

    public void deductFiveHundredNotes(int number){
        this.fiveHundredNotes-=number;
    }

    public void deductHundredNotes(int number){
        this.hundredNotes-=number;
    }

    public void printATMStatus(){
        System.out.println("ATM Balance: "+this.ATMBalance);
        System.out.println("Two Thousand Notes "+ this.twoThousandNotes+ " Amount "+ this.twoThousandNotes*2000);
        System.out.println("Five Hundred Notes "+ this.fiveHundredNotes+ " Amount "+ this.fiveHundredNotes*500);
        System.out.println("Hundred Notes "+ this.hundredNotes+ " Amount "+ this.hundredNotes*100);
    }
}
