package BehaviouralDesignPatterns.SimpleFactoryPattern.WithoutFactoryPattern;

public class Main {
    public static void main(String[] args) {

//        The vehicle creation logic can change in the future -> so not good
//        More type can be added in the future -> maintenance can become a nightmare.
        Vehicle vehicle1 = new Car();
        vehicle1.drive();

        Vehicle vehicle2 = new Bus();
        vehicle2.drive();
    }
}
