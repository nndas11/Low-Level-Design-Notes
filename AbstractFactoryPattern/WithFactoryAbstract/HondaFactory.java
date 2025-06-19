package BehaviouralDesignPatterns.AbstractFactoryPattern.WithFactoryAbstract;

public class HondaFactory implements VehicleFactory{

    @Override
    public Vehicle createVehicle(){
        return new Honda();
    }
}
