package BehaviouralDesignPatterns.LLDProblems.ParkingLot;

import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Fee.FeeStrategy;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Fee.FixedFeeStrategy;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Gate.EntryGate;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Gate.ExitGate;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.ParkingSpot.ParkingSpot;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Vehicle.Vehicle;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;


//  Need to convert to singleton design pattern.
public class ParkingLot {

    private static ParkingLot parkingLotInstance;
    private FeeStrategy feeStrategy;

    private final int id;
    private final List<ParkingFloor> parkingFloors;
    private List<EntryGate> entryGates;
    private List<ExitGate> exitGates;


//  SINGLETON DESIGN PATTERN.
    private ParkingLot(int id) {
        this.id = id;
        this.parkingFloors = new ArrayList<>();
        this.entryGates = new ArrayList<>();
        this.exitGates = new ArrayList<>();
        this.feeStrategy = new FixedFeeStrategy();
    }

    public static synchronized ParkingLot getInstance(){
        if(parkingLotInstance == null)
            return new ParkingLot(1);
        return parkingLotInstance;
    }


    public List<ParkingSpot> getAvailableSlots(VehicleType vehicleType){
        return null;
    }

    public ParkingSpot parkVehicle(Vehicle vehicle){
        return null;
    }

    public boolean unParkVehicle(ParkingSpot parkingSpot){
        return true;
    }

    public void addParkingFloor(ParkingFloor parkingFloor){
        parkingFloors.add(parkingFloor);
    }

    public void addEntryGates(EntryGate entryGate){
        entryGates.add(entryGate);
    }

    public void addExitGates(ExitGate exitGate){
        exitGates.add(exitGate);
    }

    public void setFeeStrategy(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    public int getId() {
        return id;
    }

    public FeeStrategy getFeeStrategy() {
        return feeStrategy;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }
}
