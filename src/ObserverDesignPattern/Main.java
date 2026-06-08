package ObserverDesignPattern;

import ObserverDesignPattern.Observable.IphoneProductObservable;
import ObserverDesignPattern.Observable.StockAvailabilityObservable;
import ObserverDesignPattern.Observer.EmailNotificationObserver;
import ObserverDesignPattern.Observer.PushNotificationObserver;
import ObserverDesignPattern.Observer.StockNotificationObserver;

public class Main {
    public static void main(String[] args){
        System.out.println("------Observer Design Pattern------");

        StockAvailabilityObservable iPhone = new IphoneProductObservable("iPhone18","8421","80K", 5);

        StockNotificationObserver Kshitij = new EmailNotificationObserver("U4563","kshitijgaikwad2001@gmail.com",iPhone);
        StockNotificationObserver Swaraj = new PushNotificationObserver("U2145", "Samsung", iPhone);

        iPhone.purchase(5);//Stocking out initially

        boolean success = iPhone.purchase(1);//someone tries to purchase
        if(!success){//All users clicking on get notifies
            iPhone.addObserver(Kshitij);
            iPhone.addObserver(Swaraj);
        }

        iPhone.restock(10);//new stock arrived

        iPhone.purchase(6);//Kshitij Purchased
        iPhone.removeObserver(Kshitij);

        iPhone.purchase(4);//again making it out of stock
        iPhone.restock(2);//this time swaraj get notified

        iPhone.purchase(2);//swaraj purchased
        iPhone.removeObserver(Swaraj);
    }
}
