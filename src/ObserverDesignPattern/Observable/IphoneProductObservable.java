package ObserverDesignPattern.Observable;

import ObserverDesignPattern.Observer.StockNotificationObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class IphoneProductObservable implements StockAvailabilityObservable{
    private final String productName;
    private final String productID;
    private final String productPrice;
    private final List<StockNotificationObserver> stockNotificationObservers;
    private int stockQuantity;

    public IphoneProductObservable(String productName, String productID, String productPrice, int  stockQuantity) {
        this.productName = productName;
        this.productID = productID;
        this.productPrice = productPrice;
        this.stockQuantity = stockQuantity;
        this.stockNotificationObservers = new ArrayList<>();
    }

    @Override
    public void addObserver(StockNotificationObserver observer) {
        stockNotificationObservers.add(observer);
        System.out.println("New observer added "+ observer.getUserId()+ " stock update of "+ productName);
    }

    @Override
    public void removeObserver(StockNotificationObserver observer) {
        stockNotificationObservers.remove(observer);
        System.out.println("Observer removed "+ observer.getUserId()+ " stock update of "+ productName);
    }

    @Override
    public void notifyObserver() {
        if(stockQuantity>0 && !stockNotificationObservers.isEmpty()){
            List<StockNotificationObserver> tempList = new ArrayList<>(stockNotificationObservers);

            for(StockNotificationObserver observer : tempList){
                System.out.println("Update sent to " + observer.getUserId());
                observer.update();
            }
        }
    }

    @Override
    public boolean purchase(int quantity) {
        if(quantity<=stockQuantity){
            stockQuantity -= quantity;
            System.out.println("Purchase successful for "+ productID+ " count "+ quantity);
            return true;
        }
        else{
            System.out.println("Purchase failed for "+ productID+ " count "+ quantity);
        }
        return false;
    }

    @Override
    public void restock(int quantity) {
        boolean isOutOfStck = stockQuantity ==0;
        stockQuantity +=quantity;
        System.out.println("Restock successful for "+ productID+ " count "+ quantity + "Current count "+ stockQuantity);
        if(isOutOfStck && stockQuantity>0){
            notifyObserver();
        }
    }

    @Override
    public String getProductName() {
        return productName;
    }
}
