package BehaviouralDesignPatterns.LLDProblems.ParkingLot.Fee;

import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Ticket;

public class FixedFeeStrategy implements FeeStrategy{

    private static final double RATE_PER_HOUR = 10.0;

    @Override
    public double calculateFee(Ticket ticket) {
        long duration = ticket.getExitTimeStamp() - ticket.getEntryTimeStamp();
        long hours = (duration/(1000*60*60)) + 1;
        return hours * RATE_PER_HOUR;
    }
}
