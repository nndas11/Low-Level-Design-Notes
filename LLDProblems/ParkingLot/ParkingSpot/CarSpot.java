package BehaviouralDesignPatterns.LLDProblems.ParkingLot.ParkingSpot;

import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Vehicle.Vehicle;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Vehicle.VehicleType;

public class CarSpot extends ParkingSpot{
    public CarSpot(int spotNumber) {
        super(spotNumber, VehicleType.CAR);
    }
}
