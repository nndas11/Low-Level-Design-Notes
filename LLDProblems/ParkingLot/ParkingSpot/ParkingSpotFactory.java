package BehaviouralDesignPatterns.LLDProblems.ParkingLot.ParkingSpot;

import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Vehicle.VehicleType;

import java.util.concurrent.atomic.AtomicInteger;

public class ParkingSpotFactory {

    // AtomicInteger can be used as a counter -> ensure thread safety.
    // Simple way would be to use a static counter and increment it -> but not thread safe.
    private static final AtomicInteger idGenerator = new AtomicInteger(1);

    public static ParkingSpot createParkingSpot( VehicleType vehicleType, int distanceFromGate) {
        return switch (vehicleType) {
            case CAR -> new CarSpot(idGenerator.getAndIncrement(), distanceFromGate);
            case BIKE -> new BikeSpot(idGenerator.getAndIncrement(), distanceFromGate);
            default -> throw new IllegalArgumentException("Unsupported Parking Spot Type: " + vehicleType);
        };
    }
}
