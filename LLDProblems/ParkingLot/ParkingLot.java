package BehaviouralDesignPatterns.LLDProblems.ParkingLot;

import java.util.List;


//  Need to convert to singleton design pattern.
public class ParkingLot {
    private final int id;
    private final List<ParkingFloor> parkingFloors;

    public ParkingLot(int id, List<ParkingFloor> parkingFloors) {
        this.id = id;
        this.parkingFloors = parkingFloors;
    }

    public int getId() {
        return id;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }
}
