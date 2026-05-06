package ATM.AmountWithdrawal;

import ATM.ATMRoomComponents.ATM;

public class FiveHundredWithdrawProcessor extends CashWithdrawProcessor{
    public FiveHundredWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) {
        super(nextCashWithdrawProcessor);
    }

    public void withdraw(ATM atm, int remainingAmount) {
        int required = remainingAmount/500;
        int balance = remainingAmount%500;

        if(required<=atm.getFiveHundredNotes()){
            atm.deductFiveHundredNotes(required);
            System.out.println("Five Hundred notes - "+ required);
        }
        else if(required>atm.getFiveHundredNotes()){
            balance+=(required-atm.getFiveHundredNotes())*500;
            atm.deductFiveHundredNotes(atm.getFiveHundredNotes());
            System.out.println("Five Hundred notes - "+ atm.getFiveHundredNotes());
        }

        if(balance!=0){
            super.withdraw(atm,balance);
        }
    }
}
