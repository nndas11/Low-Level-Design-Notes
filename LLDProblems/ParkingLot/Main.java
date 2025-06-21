package BehaviouralDesignPatterns.LLDProblems.ParkingLot;

import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Fee.FixedFeeStrategy;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Gate.EntryGate;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Gate.ExitGate;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Gate.Gate;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.ParkingSpot.ParkingSpot;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.ParkingSpot.ParkingSpotFactory;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Payments.Cash;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Payments.CreditCard;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Payments.PaymentStrategy;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Vehicle.Vehicle;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Vehicle.VehicleFactory;
import BehaviouralDesignPatterns.LLDProblems.ParkingLot.Vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        Initialising

        ParkingLot parkingLot = ParkingLot.getInstance();

        Vehicle car1 = VehicleFactory.createVehicle("KL55J111", VehicleType.CAR);
        Vehicle car2 = VehicleFactory.createVehicle("KL55J222", VehicleType.CAR);

        Vehicle bike1 = VehicleFactory.createVehicle("KL55J333", VehicleType.BIKE);
        Vehicle bike2 = VehicleFactory.createVehicle("KL55J444", VehicleType.BIKE);


        EntryGate entryGate = new EntryGate(1, parkingLot);
        ExitGate exitGate = new ExitGate(1, parkingLot);


        List<ParkingSpot> parkingSpotsFloor1 = List.of(
//                ParkingSpotFactory.createParkingSpot(VehicleType.CAR, 1),
//                ParkingSpotFactory.createParkingSpot(VehicleType.CAR, 2),
//                ParkingSpotFactory.createParkingSpot(VehicleType.CAR, 3),
//                ParkingSpotFactory.createParkingSpot(VehicleType.BIKE, 10),
                ParkingSpotFactory.createParkingSpot(VehicleType.CAR, 8)
        );

        List<ParkingSpot> parkingSpotsFloor2 = List.of(
                ParkingSpotFactory.createParkingSpot(VehicleType.CAR, 11),
                ParkingSpotFactory.createParkingSpot(VehicleType.CAR, 22),
                ParkingSpotFactory.createParkingSpot(VehicleType.CAR, 33),
                ParkingSpotFactory.createParkingSpot(VehicleType.BIKE, 21)
        );

        ParkingFloor parkingFloor1 = new ParkingFloor(1, parkingSpotsFloor1);
        ParkingFloor parkingFloor2 = new ParkingFloor(2, parkingSpotsFloor2);

        parkingLot.addParkingFloor(parkingFloor1);
        parkingLot.addParkingFloor(parkingFloor2);

        parkingLot.addEntryGates(entryGate);
        parkingLot.addExitGates(exitGate);

        parkingLot.setFeeStrategy(new FixedFeeStrategy());
        PaymentStrategy cash = new Cash();
        PaymentStrategy creditCard = new CreditCard();

        try{
            Ticket ticket1 = entryGate.parkVehicle(car1);
            System.out.println("Vehicle: " + car1.getLicensePlate() + " Parked at a distance of: " + ticket1.getParkingSpot().getDistanceFromGate());
            System.out.println("Available slot of CAR: " + parkingLot.getAvailableSlots(car2.getVehicleType()));
            Ticket ticket2 = entryGate.parkVehicle(car2);

//
            double amount = exitGate.exitVehicle(ticket1, cash);
            System.out.println(amount);

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }




    }
}
