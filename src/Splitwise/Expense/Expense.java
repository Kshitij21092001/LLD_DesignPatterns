package Splitwise.Expense;

import Splitwise.Expense.Split.Split;
import Splitwise.User.User;

import java.util.List;

public class Expense {
    String expenseID;
    String description;
    double expenseAmount;
    User paidByUser;
    ExpenseSplitType splitType;
    List<Split> splitDetails;

    public Expense(String expenseID, String description, double expenseAmount, User paidByUser, ExpenseSplitType splitType, List<Split> splitDetails) {
        this.expenseID = expenseID;
        this.description = description;
        this.expenseAmount = expenseAmount;
        this.paidByUser = paidByUser;
        this.splitType = splitType;
        this.splitDetails = splitDetails;
    }

    public String getExpenseID() {
        return expenseID;
    }

    public double getExpenseAmount(){
        return expenseAmount;
    }

    public User getPaidByUser() {
        return paidByUser;
    }

    public List<Split> getSplitDetails() {
        return splitDetails;
    }
}
