package ATM.AmountWithdrawal;

import ATM.ATMRoomComponents.ATM;

public class OneHundredWithdrawProcessor extends CashWithdrawProcessor{
    public OneHundredWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor){
        super(nextCashWithdrawProcessor);
    }

    public void withdraw(ATM atm, int remainingAmount){
        int required = remainingAmount/100;
        int balance = remainingAmount%100;

        if(required<=atm.getHundredNotes()){
            atm.deductHundredNotes(required);
            System.out.println("Hundred notes - "+ required);
        }
        else if(required>atm.getHundredNotes()){
            balance+=(required-atm.getHundredNotes())*100;
            atm.deductHundredNotes(atm.getHundredNotes());
            System.out.println("Hundred notes - "+ atm.getHundredNotes());
        }

        if(balance!=0){
            System.out.println("Insufficient Cash");
            atm.getATMState().setTransactionSuccess(false);
            atm.getATMState().returnCard(atm);
        }
    }
}
