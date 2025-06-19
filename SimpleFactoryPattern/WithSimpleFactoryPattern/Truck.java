package BehaviouralDesignPatterns.SimpleFactoryPattern.WithSimpleFactoryPattern;

public class Truck implements Vehicle{

    @Override
    public void drive(){
        System.out.println("Inside driving in Truck");
    }
}
