package BehaviouralDesignPatterns.DecoratorDesignPattern.WithoutPattern;

//  ❌ Problems in the Below Code
//  Class Explosion – Adding more combinations requires multiple new subclasses.
//  Not Flexible – Adding or removing features requires modifying existing classes.
//  Violates Open/Closed Principle – Existing classes need to change for new features.



public class Main {
    public static void main(String[] args) {
        Coffee coffee = new CoffeeWithMilkAndCream();
        System.out.println(coffee.getDescription());
        System.out.println(coffee.getCost());
    }
}

class Coffee{
    public String getDescription(){
        return "Plain Coffee" ;
    }

    public double getCost(){
        return 10;
    }

}

class CoffeeWithMilk extends Coffee{

    @Override
    public String getDescription(){
        return super.getDescription() + " With Milk ";
    }

    @Override
    public double getCost(){
        return super.getCost() + 5;
    }
}

class CoffeeWithMilkAndCream extends CoffeeWithMilk{
    @Override
    public String getDescription() {
        return super.getDescription() + " With Cream ";
    }

    @Override
    public double getCost() {
        return super.getCost() + 5;
    }
}



