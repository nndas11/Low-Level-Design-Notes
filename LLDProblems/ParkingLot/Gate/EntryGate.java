package BehaviouralDesignPatterns.LLDProblems.ParkingLot.Gate;

import BehaviouralDesignPatterns.LLDProblems.ParkingLot.ParkingLot;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.ParkingSpot.ParkingSpot;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Ticket;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Vehicle.Vehicle;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Vehicle.VehicleType;

import java.util.List;

public class EntryGate extends Gate{

    public EntryGate(int gateId, ParkingLot parkingLot) {
        super(gateId, GateType.ENTRY_GATE, parkingLot) ;
    }

    public List<ParkingSpot> getAvailableSpots(VehicleType vehicleType){
        return parkingLot.getAvailableSlots(vehicleType);
    }

    public Ticket parkVehicle(Vehicle vehicle){
        ParkingSpot parkingSpot = parkingLot.parkVehicle(vehicle);
        if (parkingSpot != null){
            return new Ticket(vehicle, parkingSpot);
        }
        throw new RuntimeException("Unable to Park the Vehicle: " + vehicle.getLicensePlate());
    }
}
