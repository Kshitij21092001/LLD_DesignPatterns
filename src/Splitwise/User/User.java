package Splitwise.User;

import Splitwise.UserExpenseBalanceSheet;

public class User {
    String userID;
    String userName;
    UserExpenseBalanceSheet userExpenseBalanceSheet;

    public User(String userID, String userName) {
        this.userID=userID;
        this.userName=userName;
        this.userExpenseBalanceSheet=new UserExpenseBalanceSheet();
    }

    public String getUserID(){
        return userID;
    }

    public UserExpenseBalanceSheet getExpenseBalanceSheet(){
        return userExpenseBalanceSheet;
    }
}