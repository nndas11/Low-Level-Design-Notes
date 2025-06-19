package BehaviouralDesignPatterns.SimpleFactoryPattern.WithSimpleFactoryPattern;

public class Bus implements Vehicle{

    @Override
    public void drive(){
        System.out.println("Inside driving in Bus");
    }
}
