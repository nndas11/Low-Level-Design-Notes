package BehaviouralDesignPatterns.LLDProblems.ParkingLot.Fee;


//  Strategy Design Pattern
//  Based on dynamic input condition -> we select one from the family of algorithms.

//  Fee and Payments are common to a lot of LLD questions -> needed in many questions.

//  With Strategy design pattern -> we can have a strategy processor which will be another layer of abstraction.
//  It will do everything for this -> but again design choice -> talk with interviewer.
//  Less chance to need to implement as time-consuming.

import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Ticket;

public interface FeeStrategy {
    double calculateFee(Ticket ticket);
}
