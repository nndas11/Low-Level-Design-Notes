package BehaviouralDesignPatterns.LLDProblems.ParkingLot.Gate;

import BehaviouralDesignPatterns.LLDProblems.ParkingLot.ParkingLot;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Ticket;

public class ExitGate extends Gate{
    public ExitGate(int gateId, ParkingLot parkingLot) {
        super(gateId, GateType.EXIT_GATE, parkingLot);
    }

    public double calculateTicketPrice(Ticket ticket){
        return parkingLot.getFeeStrategy().calculateFee(ticket);
    }

    public double unParkVehicle(Ticket ticket){
        if(!parkingLot.unParkVehicle(ticket.getParkingSpot()))
            throw new RuntimeException("Unable to Unpark the Vehicle with Ticket: " + ticket);
        ticket.setExitTimeStamp();
        return calculateTicketPrice(ticket);
    }

}
