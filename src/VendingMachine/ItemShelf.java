package VendingMachine;

public class ItemShelf {
    int code;
    int capacity;
    Item item;
    boolean soldOut;
    int currentItemCount;

    public ItemShelf(int code, int capacity) {
        this.code = code;
        this.capacity = capacity;
        this.currentItemCount = 0;
    }

    public int getCode() {
        return code;
    }

    public void setItem(Item item){
        this.item=item;
    }
    public int getCapacity() {
        return capacity;
    }

    public int getCurrentItemCount() {
        return currentItemCount;
    }

    public void setCurrentItemCount(int currentItemCount) {
        this.currentItemCount = currentItemCount;
    }

    public Item getItem() {
        return item;
    }

    public boolean isSoldOut() {
        return soldOut;
    }

    public void setSoldOut(boolean soldOut) {
        this.soldOut = soldOut;
    }
}
