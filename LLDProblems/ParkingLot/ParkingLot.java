package BehaviouralDesignPatterns.LLDProblems.ParkingLot;

import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Fee.FeeStrategy;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Fee.FixedFeeStrategy;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Gate.EntryGate;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Gate.ExitGate;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.ParkingSpot.ParkingSpot;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Payments.Cash;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Payments.PaymentStrategy;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Vehicle.Vehicle;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


//  So we have lot -> floor -> spot.
//  To find the correct spot is the responsibility of floor as it contains the spots
//  floor just delegates this responsibility.


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

//    Whenever there is doubt in the usage of streams just use for-loop.

    public List<ParkingSpot> getAvailableSlots(VehicleType vehicleType){
        return parkingFloors.stream()
                .flatMap(floor -> floor.getAvailableSpots(vehicleType).stream())
                .collect(Collectors.toList());

    }

    public Optional<ParkingSpot> getAvailableSpot(VehicleType vehicleType){
        return parkingFloors.stream()
                .map(floor -> floor.getAvailableSpot(vehicleType))
                .filter(Optional::isPresent)                      // Keep only non-empty optionals
                .map(Optional::get)                                // Unwrap the Optional
                .findFirst();
    }

    public ParkingSpot parkVehicle(Vehicle vehicle){
        for (ParkingFloor floor: parkingFloors){
            ParkingSpot spot = floor.parkVehicle(vehicle);
            if(spot != null){
                return spot;
            }

        }
        throw new RuntimeException("Unable to Park Vehicle");
    }

    public boolean unParkVehicle(ParkingSpot parkingSpot){
        return parkingFloors.stream()
                .filter(floor -> floor.getParkingSpots().contains(parkingSpot))
                .findFirst()
                .map(floor -> {
                    floor.unPark(parkingSpot);
                    return true;
                })
                .orElse(false);
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
