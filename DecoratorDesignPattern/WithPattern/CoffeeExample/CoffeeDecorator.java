package BehaviouralDesignPatterns.DecoratorDesignPattern.WithPattern.CoffeeExample;

public abstract class CoffeeDecorator implements Coffee{
    Coffee coffee;

    CoffeeDecorator(Coffee coffee){
        this.coffee = coffee;
    }


    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    @Override
    public double cost() {
        return coffee.cost();
    }
}

//  Decorator 1: MILK

class MilkDecorator extends CoffeeDecorator{

    MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " With Milk ";
    }

    @Override
    public double cost() {
        return super.cost() + 5;
    }
}

//  Decorator 2: SUGAR
class SugarDecorator extends CoffeeDecorator{
    SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " With Sugar ";
    }

    @Override
    public double cost() {
        return super.cost() + 10;
    }
}

//  Decorator 3: CREAM
class CreamDecorator extends CoffeeDecorator{
    CreamDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " With Cream ";
    }

    @Override
    public double cost() {
        return super.cost() + 20;
    }
}
