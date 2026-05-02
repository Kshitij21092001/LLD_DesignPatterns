package VendingMachine;

import VendingMachine.VendingStates.Impl.HasMoneyState;
import VendingMachine.VendingStates.Impl.IdleState;
import VendingMachine.VendingStates.State;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private State vendingMachineState;
    private Inventory inventory;
    private List<Coin> coinList;

    public VendingMachine(){
        this.vendingMachineState = new IdleState();
        this.inventory = new Inventory(10,3);
        this.coinList = new ArrayList<>();
    }

    public void setVendingMachineState(State vendingMachineState){
        this.vendingMachineState = vendingMachineState;
    }

    public State getVendingMachineState(){
        return  this.vendingMachineState;
    }

    public void setInventory(Inventory inventory){
        this.inventory = inventory;
    }

    public Inventory getInventory(){
        return this.inventory;
    }

    public void setCoinList(List<Coin> coinList){
        this.coinList = coinList;
    }

    public List<Coin> getCoinList(){
        return  this.coinList;
    }
}
