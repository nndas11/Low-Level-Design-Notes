package BehaviouralDesignPatterns.LLDProblems.ParkingLot;

import BehaviouralDesignPatterns.LLDProblems.ParkingLot.ParkingSpot.ParkingSpot;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Vehicle.Vehicle;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Ticket {

    private static final AtomicInteger id = new AtomicInteger(1);

    private final int ticketId;
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;
    private final long entryTimeStamp;
    private long exitTimeStamp;

    public Ticket( Vehicle vehicle, ParkingSpot parkingSpot) {
        this.ticketId = id.getAndIncrement();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTimeStamp = new Date().getTime();
    }

    public void setExitTimeStamp(){
        this.exitTimeStamp = new Date().getTime();
    }

    public int getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public long getEntryTimeStamp() {
        return entryTimeStamp;
    }

    public long getExitTimeStamp() {
        return exitTimeStamp;
    }
}
