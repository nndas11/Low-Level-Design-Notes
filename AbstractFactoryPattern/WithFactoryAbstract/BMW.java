package BehaviouralDesignPatterns.AbstractFactoryPattern.WithFactoryAbstract;

public class BMW implements Vehicle{
    @Override
    public void drive(){
        System.out.println("Inside driving in BMW...");
    }
}
