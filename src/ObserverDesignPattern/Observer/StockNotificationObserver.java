package ObserverDesignPattern.Observer;

public interface StockNotificationObserver {
    void update();
    String getNotificationMethod();
    String getUserId();
}
