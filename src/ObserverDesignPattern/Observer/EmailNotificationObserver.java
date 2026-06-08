package ObserverDesignPattern.Observer;

import ObserverDesignPattern.Observable.StockAvailabilityObservable;

public class EmailNotificationObserver implements StockNotificationObserver{
    private final String userID;
    private final String emailID;
    private final StockAvailabilityObservable stockAvailabilityObservable;

    public EmailNotificationObserver(String userID, String emailID, StockAvailabilityObservable stockAvailabilityObservable) {
        this.userID = userID;
        this.emailID = emailID;
        this.stockAvailabilityObservable = stockAvailabilityObservable;
    }


    @Override
    public void update() {
        sendEmail();
    }

    public void sendEmail() {
        System.out.println("Sending email to " + emailID + " " + stockAvailabilityObservable.getProductName()+ " is in stock!");
    }

    @Override
    public String getNotificationMethod() {
        return "Email Notification";
    }

    @Override
    public String getUserId() {
        return userID;
    }
}
