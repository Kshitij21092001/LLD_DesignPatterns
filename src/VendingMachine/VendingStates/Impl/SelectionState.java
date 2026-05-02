package VendingMachine.VendingStates.Impl;

import VendingMachine.VendingMachine;
import VendingMachine.VendingStates.State;
import VendingMachine.Coin;
import VendingMachine.Item;
public class SelectionState implements State {
    public SelectionState(){
        System.out.println("Machine is in product selection state.");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception{
        throw new Exception("Can't click on this button while being in product selection state.");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception{
        throw new Exception("Coins already inserted.");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception{
        throw new Exception("Already in product selection state.");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int code)throws Exception{
        Item item= machine.getInventory().findItem(code);
        System.out.println("Selected product code "+code+ " item "+ item.getType());
        int amountPaid=0;

        for(Coin coin:machine.getCoinList())amountPaid+=coin.value;

        if(amountPaid< item.getPrice()){
            System.out.println("Amount paid is less than product price, price: "+item.getPrice());
            refundFullMoney(machine);
            throw new Exception("Insufficient funds.");
        }
        else if(amountPaid>=item.getPrice()){
            if(amountPaid>item.getPrice())getChange(amountPaid-item.getPrice());
            System.out.println("Preparing item to dispatch: "+item.getType());
            machine.setVendingMachineState(new DispenseState(machine,code));
        }
    }

    @Override
    public int getChange(int returnChangeMoney)throws Exception{
        System.out.println("Change money: "+returnChangeMoney);
        return returnChangeMoney;
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int code)throws Exception{
        throw new Exception("Can't dispense product while in product selection state.");
    }

    @Override
    public int refundFullMoney(VendingMachine machine) throws Exception{
        int sum=0;
        for(Coin coin:machine.getCoinList())sum+=coin.value;
        machine.setVendingMachineState(new IdleState());
        System.out.println("The refund of following amount is processed: "+ sum);
        return sum;
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int code)throws Exception{
        throw new Exception("Can't update inventory while in product selection state.");
    }
}
