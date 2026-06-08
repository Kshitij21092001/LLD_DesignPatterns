package ObserverDesignPattern.Observer;

import ObserverDesignPattern.Observable.StockAvailabilityObservable;

public class PushNotificationObserver implements StockNotificationObserver{
    private final String userID;
    private final String deviceID;
    private final StockAvailabilityObservable stockAvailabilityObservable;

    public PushNotificationObserver(String userID, String deviceID,  StockAvailabilityObservable stockAvailabilityObservable) {
        this.userID = userID;
        this.deviceID = deviceID;
        this.stockAvailabilityObservable = stockAvailabilityObservable;
    }

    @Override
    public void update() {
        sendPushNotification();
    }

    public void sendPushNotification(){
        System.out.println("Push Notification: "+ deviceID + " " + stockAvailabilityObservable.getProductName() + " is in Stock!");
    }

    @Override
    public String getNotificationMethod() {
        return "Push Notification";
    }

    @Override
    public String getUserId() {
        return userID;
    }
}
