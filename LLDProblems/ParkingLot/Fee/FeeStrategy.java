package BehaviouralDesignPatterns.LLDProblems.ParkingLot.Fee;


//  Strategy Design Pattern
//  Based on dynamic input condition -> we select one from the family of algorithms.

import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Ticket;

public interface FeeStrategy {
    double calculateFee(Ticket ticket);
}
