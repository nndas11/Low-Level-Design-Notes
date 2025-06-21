package BehaviouralDesignPatterns.LLDProblems.ParkingLot;

import BehaviouralDesignPatterns.LLDProblems.ParkingLot.ParkingSpot.ParkingSpot;

import java.util.List;

// Parking Floor and lot will again have park and unpark vehicle.
// But the level of abstraction at each level would be different.
// They would in turn be calling the other method inside.

public class ParkingFloor {
    private final int floorNumber;
    private List<ParkingSpot> parkingSpots;

    public ParkingFloor(int floorNumber, List<ParkingSpot> parkingSpots) {
        this.floorNumber = floorNumber;
        this.parkingSpots = parkingSpots;
    }

    public void addParkingSpot(ParkingSpot parkingSpot){
        parkingSpots.add(parkingSpot);
    }

    public ParkingSpot parkVehicle(){
        return null;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }
}
