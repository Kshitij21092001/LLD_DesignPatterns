package VendingMachine.VendingStates;

import VendingMachine.VendingMachine;
import VendingMachine.Coin;
import VendingMachine.Item;

public interface State {
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception;
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception;
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception;
    public void chooseProduct(VendingMachine machine, int code) throws Exception;
    public int getChange(int returnChangeMoney) throws Exception;
    public Item dispenseProduct(VendingMachine machine, int code) throws Exception;
    public int refundFullMoney(VendingMachine machine) throws Exception;
    public void updateInventory(VendingMachine machine, Item item, int code) throws Exception;
}
