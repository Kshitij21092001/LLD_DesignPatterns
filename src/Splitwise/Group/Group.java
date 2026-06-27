package Splitwise.Group;

import Splitwise.BalanceSheetController;
import Splitwise.Expense.Expense;
import Splitwise.Expense.ExpenseController;
import Splitwise.Expense.ExpenseSplitType;
import Splitwise.Expense.Split.Split;
import Splitwise.User.User;

import java.util.ArrayList;
import java.util.List;

public class Group {
    public String groupID;
    public String groupName;
    List<User> groupUsers;
    List<Expense> groupExpenses;
    ExpenseController groupExpenseController;

    public Group(String groupID, String groupName) {
        this.groupID = groupID;
        this.groupName = groupName;
        groupUsers = new ArrayList<>();
        groupExpenses = new ArrayList<>();
        groupExpenseController=new ExpenseController(new BalanceSheetController());
    }

    public String getGroupID() {
        return groupID;
    }

    public List<User> getGroupUsers() {
        return groupUsers;
    }

    public List<Expense> getGroupExpenses() {
        return groupExpenses;
    }

    public void addGroupUsers(User groupUser) {
        groupUsers.add(groupUser);
    }

    public Expense createGroupExpense(String expenseID, String description, double expenseAmount, User paidByUser, ExpenseSplitType splitType, List<Split> splitDetails) {
        Expense groupExpense=groupExpenseController.createExpense(expenseID,description,expenseAmount,paidByUser,splitType,splitDetails);
        groupExpenses.add(groupExpense);
        return groupExpense;
    }
}
