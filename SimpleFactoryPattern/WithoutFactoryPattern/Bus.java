package BehaviouralDesignPatterns.SimpleFactoryPattern.WithoutFactoryPattern;


public class Bus implements Vehicle {

    @Override
    public void drive(){
        System.out.println("Inside driving in Bus");
    }
}
