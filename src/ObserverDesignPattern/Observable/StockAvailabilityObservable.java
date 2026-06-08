package ObserverDesignPattern.Observable;

import ObserverDesignPattern.Observer.StockNotificationObserver;

public interface StockAvailabilityObservable {
    void addObserver(StockNotificationObserver observer);
    void removeObserver(StockNotificationObserver observer);
    void notifyObserver();
    boolean purchase(int quantity);
    void restock(int quantity);
    String getProductName();
}
