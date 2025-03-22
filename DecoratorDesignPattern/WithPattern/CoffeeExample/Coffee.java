package BehaviouralDesignPatterns.DecoratorDesignPattern.WithPattern.CoffeeExample;

public interface Coffee {
    String getDescription();
    double cost();
}

class PlainCoffee implements Coffee{
    @Override
    public String getDescription() {
        return "Plain Coffee ";
    }

    @Override
    public double cost() {
        return 100;
    }
}
