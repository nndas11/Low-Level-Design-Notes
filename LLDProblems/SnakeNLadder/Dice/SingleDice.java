package BehaviouralDesignPatterns.LLDProblems.SnakeNLadder.Dice;

public class SingleDice implements Dice{
    @Override
    public int roll() {
        return (int) (Math.random() * (6) + 1);
    }
}
