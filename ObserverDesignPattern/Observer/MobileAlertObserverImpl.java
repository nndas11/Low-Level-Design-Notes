package BehaviouralDesignPatterns.ObserverDesignPattern.Observer;

import BehaviouralDesignPatterns.ObserverDesignPattern.Observable.StockStatusAmazonObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver{
    String userName;
    StockStatusAmazonObservable observable;

//    By doing constructor injection here, we are implementing Strategy pattern here.
//    Also, by doing this we don't need to pass the object in the update method.
//    If passed then we would need to do instance-of check for each type.
//    By this method we can call any concrete class of the observable interface implementation.
//    With constructor injection, we can directly do obj.getData() inside the update() method to get data.
    public MobileAlertObserverImpl (String userName, StockStatusAmazonObservable observable){
        this.observable = observable;
        this.userName = userName;
    }

    @Override
    public void update() {
        sendSMS(userName, "Product is in stock now, so hurry up!");

    }

    public void sendSMS(String userName, String msg){
        System.out.println("SMS has been sent to the user: " + userName + " with the message: " + msg);
    }
}
