package BehaviouralDesignPatterns.AbstractFactoryPattern.WithFactoryAbstract;

public class Honda implements Vehicle{

    @Override
    public void drive(){
        System.out.println("Inside driving in Honda...");
    }
}
