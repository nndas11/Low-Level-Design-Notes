package BehaviouralDesignPatterns.SimpleFactoryPattern.WithSimpleFactoryPattern;

public class Car implements Vehicle{

    @Override
    public void drive(){
        System.out.println("Inside Driving in Car");
    }
}
