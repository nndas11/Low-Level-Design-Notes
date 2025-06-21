package BehaviouralDesignPatterns.LLDProblems.ParkingLot.Payments;

public class Cash implements PaymentStrategy{
    @Override
    public void processPayment(double amount) {
        System.out.println("Paying the following amount using Cash: " + amount);
    }
}
