package BehaviouralDesignPatterns.LLDProblems.ParkingLot.ParkingSpot;

import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Vehicle.VehicleType;

public class BikeSpot extends ParkingSpot{
    public BikeSpot(int spotNumber) {
        super(spotNumber, VehicleType.BIKE);
    }
}
