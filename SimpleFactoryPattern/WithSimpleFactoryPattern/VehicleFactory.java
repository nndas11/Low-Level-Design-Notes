package BehaviouralDesignPatterns.SimpleFactoryPattern.WithSimpleFactoryPattern;

public class VehicleFactory {

   //   Factory Method -> takes care of the object creation based on our input parameter.
   //   Object creation is decoupled from its business logic.
   //   Now we have central area which takes care of all object creation.
   //   When we have something to change in the future we can do this here, instead of changing code in many areas.
   //   Scalable, encapsulation.
    public Vehicle getVehicleInstance(String vehicleType){

        if(vehicleType == null){
            return null;
        }

        switch (vehicleType.toLowerCase()){
            case "car":
                return new Car();
            case "bus":
                return new Bus();
            case "truck":
                return new Truck();
            default:
                throw new IllegalArgumentException("Unknown Vehicle Type");
        }
    }
}
