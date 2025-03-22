package BehaviouralDesignPatterns.DecoratorDesignPattern.WithPattern.CoffeeExample;


//  Similar can be done for Pizza toppings and Vehicles with features.
public class Main {
    public static void main(String[] args) {
        Coffee coffee = new MilkDecorator(new SugarDecorator(new PlainCoffee()));
        System.out.println(coffee.getDescription());
        System.out.println(coffee.cost());
    }
}
