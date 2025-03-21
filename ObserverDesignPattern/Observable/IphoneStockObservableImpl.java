package BehaviouralDesignPatterns.ObserverDesignPattern.Observable;

import BehaviouralDesignPatterns.ObserverDesignPattern.Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneStockObservableImpl implements StockStatusAmazonObservable{
    //Q1: Why we are using NotificationAlertObserver

//    These are the list of customers(observers) who clicked on "notify-me" button for the iphone.
    public List<NotificationAlertObserver> observerList = new ArrayList<>();
    public int stockCount = 0;

    @Override
    public void add(NotificationAlertObserver observer) {
        observerList.add(observer);

    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        observerList.remove(observer);

    }

    @Override
    public void notifySubscribers() {
        //Q2: understand the for loop
        for (NotificationAlertObserver observer: observerList){
            observer.update();
        }

    }

    @Override
    public void setStockCount(int newStockAdded) {
//        we are notifying on item is not more out-of-stock -> changes as per the question.
//        Business Logic will mostly go here.
        if(stockCount == 0){
            notifySubscribers();
        }
        stockCount = stockCount + newStockAdded;
        System.out.println(stockCount);

    }

    @Override
    public int getStockCount() {
        System.out.println(stockCount);
        return stockCount;
    }
}
