package ATM.AmountWithdrawal;

import ATM.ATMRoomComponents.ATM;

public class TwoThousandWithdrawProcessor extends CashWithdrawProcessor {
    public TwoThousandWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) {
        super(nextCashWithdrawProcessor);
    }

    public void withdraw(ATM atm, int remainingAmount) {
        int required = remainingAmount/2000;
        int balance = remainingAmount%2000;

        if(required<=atm.getTwoThousandNotes()){
            atm.deduceTwoThousandNotes(required);
        }
        else if(required>atm.getTwoThousandNotes()){
            balance+=(required-atm.getTwoThousandNotes())*2000;
            atm.deduceTwoThousandNotes(atm.getTwoThousandNotes());
        }

        if(balance!=0){
            super.withdraw(atm,balance);
        }
    }
}
