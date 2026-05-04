package ATM.ATMStates;

import ATM.ATMRoomComponents.ATM;
import ATM.ATMRoomComponents.Card;
import ATM.AmountWithdrawal.CashWithdrawProcessor;
import ATM.AmountWithdrawal.FiveHundredWithdrawProcessor;
import ATM.AmountWithdrawal.OneHundredWithdrawProcessor;
import ATM.AmountWithdrawal.TwoThousandWithdrawProcessor;

import java.util.Scanner;

public class CashWithdrawalState extends ATMState {
    public boolean transactionSuccess = true;
    public CashWithdrawalState(){
        System.out.println("ATM is in Cash Withdrawal State.");
    }

    public void cashWithdrawal(ATM atm, Card card){
        int amount;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the amount to withdraw:");
        amount=input.nextInt();

        if(amount>atm.getATMBalance()){
            System.out.println("Insufficient money in ATM.");
            returnCard(atm);
        }
        else if(amount> card.getBalance()){
            System.out.println("Insufficient money in Bank Account.");
            returnCard(atm);
        }
        else{
            CashWithdrawProcessor withdrawProcessor =
                    new TwoThousandWithdrawProcessor(new FiveHundredWithdrawProcessor(new OneHundredWithdrawProcessor(null)));

            withdrawProcessor.withdraw(atm,amount);
            if(transactionSuccess){
                System.out.println("Transaction successful.");
                atm.deductATMBalance(amount);
                card.withDraw(amount);
            }
            returnCard(atm);
        }
    }

    public void setTransactionSuccess(boolean transactionSuccess){
        this.transactionSuccess = transactionSuccess;
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
