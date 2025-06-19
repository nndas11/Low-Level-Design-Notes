package BehaviouralDesignPatterns.SimpleFactoryPattern.WithoutFactoryPattern;

public class Car implements Vehicle {

    @Override
    public void drive(){
        System.out.println("Inside driving in Car");
    }
}
