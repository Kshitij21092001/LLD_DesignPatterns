package Splitwise;

import Splitwise.Expense.Split.Split;
import Splitwise.User.User;

import java.util.List;
import java.util.Map;

import static java.lang.Math.abs;

public class BalanceSheetController {
    public void updateUserExpenseBalanceSheet(User paidBy, double totalExpenseAmount, List<Split> splitList) {
        UserExpenseBalanceSheet paidUserBalanceSheet=paidBy.getExpenseBalanceSheet();
        paidUserBalanceSheet.setTotalPayment(paidUserBalanceSheet.getTotalPayment()+totalExpenseAmount);

        for(Split split : splitList){
            User userOwe=split.getUser();
            UserExpenseBalanceSheet oweUserExpenseSheet=userOwe.getExpenseBalanceSheet();
            double oweAmount=split.getAmount();

            if(userOwe.getUserID().equals(paidBy.getUserID())){
                paidUserBalanceSheet.setTotalSelfExpense(paidUserBalanceSheet.getTotalSelfExpense()+oweAmount);
            }
            else{
                paidUserBalanceSheet.setTotalAmountGetBack(paidUserBalanceSheet.getTotalAmountGetBack()+oweAmount);

                Balance oweUserBalance;
                if(paidUserBalanceSheet.getUserVsBalance().containsKey(userOwe)){
                    oweUserBalance=paidUserBalanceSheet.getUserVsBalance().get(userOwe);
                }
                else{
                    oweUserBalance=new Balance();
                    paidUserBalanceSheet.getUserVsBalance().put(userOwe,oweUserBalance);
                }
                oweUserBalance.setAmountGetBack(oweUserBalance.getAmountGetBack()+oweAmount);

                oweUserExpenseSheet.setTotalSelfExpense(oweUserExpenseSheet.getTotalSelfExpense()+oweAmount);
                oweUserExpenseSheet.setTotalAmountOwe(oweUserExpenseSheet.getTotalAmountOwe()+oweAmount);

                Balance paidUserBalance;
                if(oweUserExpenseSheet.getUserVsBalance().containsKey(paidBy)){
                    paidUserBalance=oweUserExpenseSheet.getUserVsBalance().get(paidBy);
                }
                else{
                    paidUserBalance=new Balance();
                    oweUserExpenseSheet.getUserVsBalance().put(paidBy,paidUserBalance);
                }
                paidUserBalance.setAmountOwe(paidUserBalance.getAmountOwe()+oweAmount);
            }
        }
    }

    public void showBalanceSheetOfUser(User user){
        System.out.println("-------- Balance Sheet of "+ user.getUserID());
        UserExpenseBalanceSheet userExpenseBalanceSheet=user.getExpenseBalanceSheet();

        System.out.println("Total Payment done: "+userExpenseBalanceSheet.getTotalPayment());
        System.out.println("Total Self Expense: "+ userExpenseBalanceSheet.getTotalSelfExpense());
        System.out.println("Total Amount Owe: "+userExpenseBalanceSheet.getTotalAmountOwe());
        System.out.println("Total AmountGetBack: "+userExpenseBalanceSheet.getTotalAmountGetBack());

        for(Map.Entry<User,Balance> entry : userExpenseBalanceSheet.getUserVsBalance().entrySet()){
            String userID=entry.getKey().getUserID();
            Balance balance=entry.getValue();

            double diff=balance.getAmountGetBack()-balance.getAmountOwe();
            if(diff>0){
                System.out.println(user.getUserID()+" will receive "+diff+" from user "+userID);
            }
            else{
                System.out.println(user.getUserID()+" will give "+abs(diff)+" to user "+userID);
            }
        }

        System.out.println("------End of Sheet, Happy Splitting!!-----");
    }
}
