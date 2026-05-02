package VendingMachine;

import VendingMachine.VendingStates.State;

import java.util.List;

public class Main {
    public static void main(String[] args){
        VendingMachine machine = new VendingMachine();
        try{
            System.out.println("Filling up the machine...");

            fillUpInventory(machine);
            displayInventory(machine);

            System.out.println("Clicking on insert coin button.");

            State machineState = machine.getVendingMachineState();
            machineState.clickOnInsertCoinButton(machine);

            machineState = machine.getVendingMachineState();
            machineState.insertCoin(machine,Coin.DIME);
            machineState.insertCoin(machine,Coin.QUARTER);
            machineState.clickOnStartProductSelectionButton(machine);

            machineState = machine.getVendingMachineState();
            machineState.chooseProduct(machine,105);

            displayInventory(machine);
        }
        catch(Exception e){
            displayInventory(machine);
        }
    }

    private static void fillUpInventory(VendingMachine machine){
        List<ItemShelf> slots = machine.getInventory().getInventory();
        System.out.println("Slot size when filling inventory called "+ slots.size());

        for(int i=0;i<slots.size();i++){
            Item newItem = new Item();
            if(i>=0 && i<3){
                newItem.setType(ItemType.COKE);
                newItem.setPrice(15);
            }
            else if(i>=3 && i<6){
                newItem.setType(ItemType.JUICE);
                newItem.setPrice(16);
            }
            else if(i>=6 && i<8){
                newItem.setType(ItemType.PEPSI);
                newItem.setPrice(35);
            }
            else{
                newItem.setType(ItemType.SODA);
                newItem.setPrice(40);
            }
            try {
                machine.getInventory().addItem(newItem,i+101);
                machine.getInventory().addItem(newItem,i+101);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static void displayInventory(VendingMachine machine){
        List<ItemShelf> slots = machine.getInventory().getInventory();
        System.out.println("Size of the inventory: " + slots.size());

        for(int i=0;i<slots.size();i++){
            System.out.println(slots.get(i).getCode()+" "+slots.get(i).getItem().getType()
                    +" Price: "+slots.get(i).getItem().getPrice()+" Count: " + slots.get(i).getCurrentItemCount() +
                    " isSoldOut: "+slots.get(i).isSoldOut());
        }
    }
}
