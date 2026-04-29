package VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<ItemShelf> inventory = null;

    public Inventory(int itemCount, int shelfCapacity) {
        inventory = new ArrayList<ItemShelf>(itemCount);
        initialEmptyInventory(shelfCapacity);
    }

    public List<ItemShelf> getInventory() {
        return inventory;
    }

    void initialEmptyInventory(int shelfCapacity) {
        int code=101;
        for (int i = 0; i < inventory.size(); i++) {
            ItemShelf newShelf = new ItemShelf(code,shelfCapacity);
            newShelf.setSoldOut(true);
            inventory.add(i,newShelf);
            code++;
        }
    }

    public void addItem(Item item, int code) throws Exception {
        for(ItemShelf itemShelf : inventory){
            if(itemShelf.getCode()==code){
                if(itemShelf.getCurrentItemCount()< itemShelf.getCapacity()){
                    if(itemShelf.getCurrentItemCount()==0)itemShelf.item=item;
                    itemShelf.setCurrentItemCount(itemShelf.getCurrentItemCount()+1);
                    itemShelf.setSoldOut(false);
                }
                else{
                    throw new Exception("Capacity full");
                }
            }
        }
    }

    public Item getItem(int code) throws Exception{
        for(ItemShelf itemShelf : inventory){
            if(itemShelf.getCode()==code){
                if(!itemShelf.isSoldOut()){
                    itemShelf.setCurrentItemCount(itemShelf.getCurrentItemCount()-1);
                    if(itemShelf.getCurrentItemCount()==0){
                        itemShelf.setSoldOut(true);
                    }
                    return itemShelf.getItem();
                }
                else throw new Exception("Sold out");
            }
        }
        throw new Exception("Item not found");
    }
}
