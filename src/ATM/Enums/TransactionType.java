package ATM.Enums;

public enum TransactionType {
    CASH_WITHDRAWAL,
    BALANCE_CHECK;

    public static void showAllTransactionTypes(){
        for(TransactionType t : TransactionType.values()){
            System.out.println(t.name());
        }
    }
}
