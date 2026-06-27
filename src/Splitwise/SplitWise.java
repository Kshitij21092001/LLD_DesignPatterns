package Splitwise;

import Splitwise.Expense.ExpenseController;
import Splitwise.Expense.ExpenseSplitType;
import Splitwise.Expense.Split.Split;
import Splitwise.Group.Group;
import Splitwise.Group.GroupController;
import Splitwise.User.User;
import Splitwise.User.UserController;

import java.util.ArrayList;
import java.util.List;

public class SplitWise {
    public BalanceSheetController balanceSheetController;
    public GroupController groupController;
    public UserController userController;
    public ExpenseController expenseController;

    public SplitWise() {
        this.groupController = new GroupController();
        this.balanceSheetController = new BalanceSheetController();
        this.userController=new UserController();
        this.expenseController=new ExpenseController(this.balanceSheetController);
    }

    public void demo(){
        setUserAndGroup();

        Group group=groupController.getGroup("G001");
        group.addGroupUsers(userController.getUser("G002"));
        group.addGroupUsers(userController.getUser("G003"));

        List<Split> restaurantSplit = new ArrayList<Split>();
        Split s1=new Split(userController.getUser("U001"),250);
        Split s2=new Split(userController.getUser("U002"),250);
        Split s3=new Split(userController.getUser("U003"),250);
        restaurantSplit.add(s1);
        restaurantSplit.add(s2);
        restaurantSplit.add(s3);
        group.createGroupExpense("E001","Dinner",750,userController.getUser("U001"), ExpenseSplitType.EQUAL,restaurantSplit);

        List<Split> grocerry=new  ArrayList<>();
        Split s4=new Split(userController.getUser("U001"),300);
        Split s5=new Split(userController.getUser("U002"),500);
        grocerry.add(s4);
        grocerry.add(s5);
        expenseController.createExpense("E002","Grocerry",800,userController.getUser("U002"),ExpenseSplitType.UNEQUAL,grocerry);

        for(User user:userController.getUsers()){
            balanceSheetController.showBalanceSheetOfUser(user);
        }
    }

    public void setUserAndGroup(){
        createUsers();

        User Kshitij=userController.getUser("U001");
        groupController.createNewGroup("G001","Roommates", Kshitij);
    }

    public void createUsers(){
        User Kshitij = new User("U001","Kshitij");
        User Hemant = new User("U002","Hemant");
        User Bikram = new User("U003","Bikram");

        userController.addUser(Kshitij);
        userController.addUser(Hemant);
        userController.addUser(Bikram);
    }
}
