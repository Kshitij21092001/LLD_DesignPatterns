package Splitwise.Expense;

import Splitwise.BalanceSheetController;
import Splitwise.Expense.Split.ExpenseSplit;
import Splitwise.Expense.Split.Split;
import Splitwise.User.User;

import java.util.List;

public class ExpenseController {
    BalanceSheetController balanceSheetController;

    public ExpenseController(BalanceSheetController balanceSheetController) {
        this.balanceSheetController = balanceSheetController;
    }

    public Expense createExpense(String expenseID, String description, double expenseAmount, User paidByUser, ExpenseSplitType splitType, List<Split> splitDetails){
        ExpenseSplit expenseSplit=SplitFactory.getSplitType(splitType);
        try{
            assert expenseSplit != null;
            expenseSplit.validateSplitRequest(splitDetails,expenseAmount);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        balanceSheetController.updateUserExpenseBalanceSheet(paidByUser,expenseAmount,splitDetails);
        return new Expense(expenseID,description,expenseAmount,paidByUser,splitType,splitDetails);
    }
}