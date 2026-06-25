package Splitwise.Expense.Split;

import java.util.List;

public interface ExpenseSplit {
    public void validateSplitRequest(List<Split> splitDetails, double totalAmount)throws Exception;
}
