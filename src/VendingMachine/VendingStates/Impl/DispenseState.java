package VendingMachine.VendingStates.Impl;

import VendingMachine.VendingMachine;
import VendingMachine.VendingStates.State;
import VendingMachine.Coin;
import VendingMachine.Item;

public class DispenseState implements State {
    public DispenseState(VendingMachine machine, int code) throws Exception {
        System.out.println("Dispensing your item "+machine.getInventory().findItem(code).getType());
        dispenseProduct(machine, code);
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception{
        throw new Exception("Can't click on insert coin button while machine is dispensing. ");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception{
        throw new Exception("Can't insert coin while being in dispensing state. ");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception{
        throw new Exception("Can't select product while machine is dispensing. ");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int code) throws Exception{
        throw new Exception("Can't choose product while machine is dispensing. ");
    }

    @Override
    public int getChange(int returnChangeMoney)throws Exception{
        throw new Exception("Can't get change while machine is dispensing. ");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int code) throws Exception{
        System.out.println("Item dispensed, thank you!");
        Item item = machine.getInventory().getItem(code);
        machine.setVendingMachineState(new IdleState(machine));
        return item;
    }

    @Override
    public int refundFullMoney(VendingMachine machine) throws Exception{
        throw new Exception("Can't refund while machine is dispensing. ");
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int code) throws Exception{
        throw new Exception("Can't update inventory while machine is dispensing. ");
    }
}
