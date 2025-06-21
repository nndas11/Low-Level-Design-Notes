package BehaviouralDesignPatterns.LLDProblems.ParkingLot.Fee;

import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Ticket;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Vehicle.VehicleType;

import java.util.Map;

public class VehicleBasedFreeStrategy implements FeeStrategy{

    private final static Map<VehicleType, Double> hourlyRate = Map.of(
            VehicleType.CAR, 20.0,
            VehicleType.BIKE, 10.0
    );

    @Override
    public double calculateFee(Ticket ticket) {
        long duration = ticket.getExitTimeStamp() - ticket.getEntryTimeStamp();
        long hours = (duration/(1000*60*60)) + 1;
        return hours * hourlyRate.get(ticket.getVehicle().getVehicleType());
    }
}
