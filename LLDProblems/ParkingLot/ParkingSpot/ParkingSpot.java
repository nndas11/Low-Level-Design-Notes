package BehaviouralDesignPatterns.LLDProblems.ParkingLot.ParkingSpot;


import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Vehicle.Vehicle;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Vehicle.VehicleType;

public abstract class ParkingSpot {
    protected final int spotNumber;
    protected final VehicleType vehicleType;
    protected boolean isOccupied;
    protected Vehicle vehicle;

    public ParkingSpot(int spotNumber, VehicleType vehicleType) {
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
        this.isOccupied = false;
    }

//    synchronized -> is for ensuring thread safety
//    At the same time multiple thread can try to park the vehicle
//    So using this keyword -> we can make sure at a time only one thread is executing and others have to wait for their turn.
    public synchronized boolean park(Vehicle vehicle){
        if(!this.isOccupied && vehicle.getVehicleType() == this.vehicleType ){
            isOccupied = true;
            this.vehicle = vehicle;
            return true;
        }
        return false;
    }

    public synchronized void unPark(){
        isOccupied = false;
        vehicle = null;
    }

    public synchronized boolean isAvailable(){
        return !isOccupied;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }


    public Vehicle getVehicle() {
        return vehicle;
    }
}
