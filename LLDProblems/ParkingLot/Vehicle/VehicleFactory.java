package BehaviouralDesignPatterns.LLDProblems.ParkingLot.Vehicle;

public class VehicleFactory {

    // can be static or not -> depends on use cases.
    public static Vehicle createVehicle(String licensePlate, VehicleType vehicleType){
        return switch (vehicleType) {
            case CAR -> new Car(licensePlate);
            case BIKE -> new Bike(licensePlate);
            default -> throw new IllegalArgumentException("Unsupported Vehicle Type: " + vehicleType);
        };
    }
}
