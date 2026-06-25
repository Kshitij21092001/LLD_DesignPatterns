package Splitwise.Expense.Split;

import java.util.List;

public class PercentageExpenseSplit implements  ExpenseSplit {

    @Override
    public void validateSplitRequest(List<Split> splitDetails, double totalAmount) throws Exception {
        double amountSum=0;
        for(Split split:splitDetails){
            amountSum+=split.getAmount();
        }
        if(amountSum!=totalAmount){
            throw new Exception("Percentage sum not matching");
        }
    }
}
