package BehaviouralDesignPatterns.LLDProblems.ParkingLot.Payments;

public class CreditCard implements PaymentStrategy{
    @Override
    public void processPayment(double amount) {
        System.out.println("Paying the following amount using CreditCard: " + amount);
    }
}
