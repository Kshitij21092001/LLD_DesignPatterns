package VendingMachine.VendingStates.Impl;

import VendingMachine.VendingMachine;
import VendingMachine.VendingStates.State;
import VendingMachine.Coin;
import VendingMachine.Item;

public class HasMoneyState implements State {
    public HasMoneyState(){
        System.out.println("Machine is in Has money state.");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception{
        throw new Exception("Already pressed this button, please insert coins now.");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception{
        machine.getCoinList().add(coin);
        System.out.println("Coin "+ coin.value + " has been inserted.");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception{
        machine.setVendingMachineState(new SelectionState());
    }

    @Override
    public void chooseProduct(VendingMachine machine,int code)throws Exception{
        throw new Exception("Please press product selection confirmation button first.");
    }

    @Override
    public int getChange(int returnChangeMoney)throws Exception{
        throw new Exception("Select the product first to process the refun.");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int code)throws Exception{
        throw new Exception("Please press product selection confirmation button first.");
    }

    @Override
    public int refundFullMoney(VendingMachine machine)throws Exception{
        int sum=0;
        for(Coin coin:machine.getCoinList())sum+=coin.value;
        machine.setVendingMachineState(new IdleState());
        System.out.println("The refund of following amount is processed: "+ sum);
        return sum;
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int code) throws Exception{
        throw new Exception("Can't update inventory in Idle state.");
    }
}
