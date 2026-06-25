package Splitwise.Expense.Split;

import java.util.List;

public class EqualExpenseSplit implements ExpenseSplit {

    @Override
    public void validateSplitRequest(List<Split> splitDetails, double totalAmount) throws Exception {
        double equalAmount=totalAmount/(double)splitDetails.size();
        for(Split split : splitDetails){
            if(equalAmount!=split.getAmount()){
                throw new  Exception("Split amounts are not equal, please validate");
            }
        }
    }
}
