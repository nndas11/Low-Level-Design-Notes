package BehaviouralDesignPatterns.AbstractFactoryPattern.WithFactoryAbstract;


//  So if we need to add new company like toyota, we just create new Factory Class

public class Main {
    public static void main(String[] args) {

        VehicleFactory vehicleFactory = new HondaFactory();
        Vehicle honda = vehicleFactory.createVehicle();
        honda.drive();

        VehicleFactory vehicleFactory1 = new BMWFactory();
        Vehicle bmw = vehicleFactory1.createVehicle();
        bmw.drive();

    }
}
