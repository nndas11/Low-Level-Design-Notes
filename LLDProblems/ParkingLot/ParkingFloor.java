package BehaviouralDesignPatterns.LLDProblems.ParkingLot;


import BehaviouralDesignPatterns.LLDProblems.ParkingLot.ParkingSpot.ParkingSpot;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Vehicle.Vehicle;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Vehicle.VehicleType;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;

// Parking Floor and lot will again have park and unpark vehicle.
// But the level of abstraction at each level would be different.
// They would in turn be calling the other method inside.

public class ParkingFloor {
    private final int floorNumber;
    private List<ParkingSpot> parkingSpots;
    private PriorityQueue<ParkingSpot> availableSpots;

    public ParkingFloor(int floorNumber, List<ParkingSpot> parkingSpots) {
        this.floorNumber = floorNumber;
        this.parkingSpots = parkingSpots;
        this.availableSpots = new PriorityQueue<>(
                Comparator.comparingInt(ParkingSpot::getDistanceFromGate)
        );

        for(ParkingSpot spot: parkingSpots){
            if(spot.isAvailable()){
                availableSpots.add(spot);
            }
        }
    }

    public void addParkingSpot(ParkingSpot parkingSpot){
        parkingSpots.add(parkingSpot);
        if (parkingSpot.isAvailable())
            availableSpots.add(parkingSpot);
    }

    public ParkingSpot parkVehicle(Vehicle vehicle){
        Optional<ParkingSpot> parkingSpot = this.getAvailableSpot(vehicle.getVehicleType());
        if(parkingSpot.isPresent()){
            ParkingSpot spot = parkingSpot.get();
            if (spot.park(vehicle)){
                availableSpots.remove(spot);
                return spot;
            }
        }
        return null;
    }

    public void unPark(ParkingSpot parkingSpot){
        parkingSpot.unPark();
        availableSpots.add(parkingSpot);
    }

    public Optional<ParkingSpot> getAvailableSpot(VehicleType vehicleType){
        return availableSpots.stream()
                .filter(spot -> spot.getVehicleType() == vehicleType)
                .min(Comparator.comparingInt(ParkingSpot::getDistanceFromGate));
    }

    public List<ParkingSpot> getAvailableSpots(VehicleType vehicleType){
        return parkingSpots.stream()
                .filter(spot -> spot.isAvailable() && spot.getVehicleType() == vehicleType)
                .toList();
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }
}
