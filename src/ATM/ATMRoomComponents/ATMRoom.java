package ATM.ATMRoomComponents;

public class ATMRoom {
    private static Card visaCard;
    private static User user1;
    public static void main(String[] args){
        ATM atm = ATM.getATMObj();
        initialize(atm);

        atm.printATMStatus();
        atm.getATMState().insertCard(atm,visaCard);
        atm.getATMState().authenticate(atm,visaCard);
        atm.getATMState().selectAction(atm,visaCard);
        atm.getATMState().cashWithdrawal(atm,visaCard);
        atm.printATMStatus();
    }

    private static void initialize(ATM atm){
        UserBankAccount account1=new UserBankAccount(4000,1800);
        visaCard = new Card(account1,46061234,1234);
        user1 = new User(visaCard,account1);

        atm.setATMBalance(2,5,1);
    }
}
