package BehaviouralDesignPatterns.LLDProblems.ParkingLot.ParkingSpot;

import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Vehicle.Vehicle;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Vehicle.VehicleType;

public class CarSpot extends ParkingSpot{
    public CarSpot(int spotNumber, int distanceFromGate) {
        super(spotNumber, VehicleType.CAR, distanceFromGate);
    }
}
