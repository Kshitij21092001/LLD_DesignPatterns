package Splitwise;

import Splitwise.User.User;

import java.util.HashMap;
import java.util.Map;

public class UserExpenseBalanceSheet {
    public Map<User,Balance> userVsBalance;
    public double totalPayment;
    public double totalSelfExpense;
    public double totalAmountOwe;
    public double totalAmountGetBack;

    public UserExpenseBalanceSheet() {
        userVsBalance = new HashMap<>();
        this.totalPayment = 0;
        this.totalSelfExpense = 0;
        this.totalAmountOwe = 0;
        this.totalAmountGetBack = 0;
    }

    public Map<User,Balance> getUserVsBalance() {
        return userVsBalance;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public void setTotalSelfExpense(double totalSelfExpense) {
        this.totalSelfExpense = totalSelfExpense;
    }

    public void setTotalAmountOwe(double totalAmountOwe) {
        this.totalAmountOwe = totalAmountOwe;
    }

    public void setTotalAmountGetBack(double totalAmountGetBack) {
        this.totalAmountGetBack = totalAmountGetBack;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public double getTotalSelfExpense() {
        return totalSelfExpense;
    }

    public double getTotalAmountOwe() {
        return totalAmountOwe;
    }

    public double getTotalAmountGetBack() {
        return totalAmountGetBack;
    }
}
