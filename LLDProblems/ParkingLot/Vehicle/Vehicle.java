package BehaviouralDesignPatterns.LLDProblems.ParkingLot.Vehicle;

public abstract class Vehicle {
    protected String licensePlate;
    protected VehicleType vehicleType;

    public Vehicle(String licensePlate, VehicleType vehicleType) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    //  Not using setters -> as we only need to assign them during object creation and not before as they are immutable
    //  This is the case usually.
    //  They should be immutable -> as licensePlate and type does not change for a vehicle.
}
