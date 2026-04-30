package VendingMachine.VendingStates.Impl;

import VendingMachine.VendingMachine;
import VendingMachine.VendingStates.State;
import VendingMachine.Coin;
import java.util.ArrayList;
import VendingMachine.Item;

public class IdleState implements State {
    public IdleState(){
        System.out.println("Machine is in Idle State.");
    }

    public IdleState(VendingMachine machine){
        System.out.println("Machine is in Idle State.");
        machine.setCoinList(new ArrayList<>());
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws  Exception {
        machine.getVendingMachineState(new HasMoneyState());
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception{
        throw new Exception("Cant insert coin in idle state.");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception{
        throw new Exception("Please click on insert coin button first, add coins and select product selection button.");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int code) throws Exception{
        throw new Exception("Please first insert coins and choose product seletion button.");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception{
        throw new Exception("Which change? Have you even paid?");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int code) throws Exception{
        throw new  Exception("Can't dispense product in idle state");
    }

    @Override
    public int refundFullMoney(VendingMachine machine) throws Exception{
        throw new Exception("Can't refund full money in idle state");
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int code) throws Exception{
        machine.getInventory().addItem(item,code);
    }
}
