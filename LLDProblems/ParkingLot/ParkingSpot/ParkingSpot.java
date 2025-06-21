package BehaviouralDesignPatterns.LLDProblems.ParkingLot.ParkingSpot;


import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Vehicle.Vehicle;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Vehicle.VehicleType;


//  We need to find the spot which is nearest to the gate.
//  So for this, we have a variable called distanceFromGate -> which has how far is the spot away.
//  Another way would be to use coordinates for the gate and spot.
//  Then use Euclidean distance formula to find the distance.

public abstract class ParkingSpot {
    protected final int spotNumber;
    protected final VehicleType vehicleType;
    protected boolean isOccupied;
    protected Vehicle vehicle;
    protected final int distanceFromGate;

    public ParkingSpot(int spotNumber, VehicleType vehicleType, int distanceFromGate) {
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
        this.isOccupied = false;
        this.distanceFromGate = distanceFromGate;
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

    public int getDistanceFromGate() {
        return distanceFromGate;
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
