package BehaviouralDesignPatterns.LLDProblems.ParkingLot.Gate;

import BehaviouralDesignPatterns.LLDProblems.ParkingLot.ParkingLot;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Payments.PaymentStrategy;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Ticket;

//  This payment and fee, we can keep this in the gate level or parking lot level or create a separate process and do the earlier stuff.
//  If we keep both at lot level -> then all gates will have same payment and fee calculation.
//  With gate level -> each can have different.
//  This is all design choices -> which we take based on our needs.
//  Talk with interviewer and decide.

public class ExitGate extends Gate{
    public ExitGate(int gateId, ParkingLot parkingLot) {
        super(gateId, GateType.EXIT_GATE, parkingLot);
    }

    public double calculateTicketPrice(Ticket ticket){
        return parkingLot.getFeeStrategy().calculateFee(ticket);
    }

//    1. Calculate Fee.
//    2. Pay the Fee.
//    3. Unpark and exit.

//    Payment strategy passed here as usually it's the choice of user.
//    Again a design choice.

    public double exitVehicle(Ticket ticket, PaymentStrategy paymentStrategy){
        ticket.setExitTimeStamp();
        double amount = calculateTicketPrice(ticket);
        paymentStrategy.processPayment(amount);


        if(!parkingLot.unParkVehicle(ticket.getParkingSpot()))
            throw new RuntimeException("Unable to Unpark the Vehicle with Ticket: " + ticket);

        return amount;
    }

}
