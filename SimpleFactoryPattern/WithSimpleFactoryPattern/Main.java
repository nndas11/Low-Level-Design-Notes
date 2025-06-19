package BehaviouralDesignPatterns.SimpleFactoryPattern.WithSimpleFactoryPattern;

public class Main {
    public static void main(String[] args) {

        VehicleFactory vehicleFactory = new VehicleFactory();

        Vehicle vehicle1 = vehicleFactory.getVehicleInstance("Car");
        vehicle1.drive();

        Vehicle vehicle2 = vehicleFactory.getVehicleInstance("bus");
        vehicle2.drive();

        Vehicle vehicle3 = vehicleFactory.getVehicleInstance("truck");
        vehicle3.drive();
    }
}
