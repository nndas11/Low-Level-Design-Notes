package BehaviouralDesignPatterns.StrategyDesignPattern.WithStrategyPattern;


// Strategy design pattern  helps achieve OCP by defining a family of algorithms (strategies) that can be selected at runtime.

//Key Takeaways
//          ✔ Loose Coupling                – Business logic is decoupled from specific payment methods.
//          ✔ Open/Closed Principle (OCP)   – We can add new strategies without modifying existing code.
//          ✔ Scalability                   – Easy to extend, test, and maintain.

// Same as the payment method example for the Open/ Closed principle.

// Parent class have one default definition, then for example, among 3 child class 2 need to override the default
// behaviour with special one but both are same, then will result in code duplication.
// So we do is create an interface with that method and then implement this interface with different classes which have different behaviour(like payment methods or driving capability)
// Then the class will have an object of the type interface, and we do constructor injection, so anything can be passed.

public class Main {

    public static void main(String[] args) {
        Vehicle vehicle1 = new OffloadVehicle();
        vehicle1.drive();
        Vehicle vehicle2 = new Passenger();
        vehicle2.drive();

    }
}
