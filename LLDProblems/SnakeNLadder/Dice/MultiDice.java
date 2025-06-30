package BehaviouralDesignPatterns.LLDProblems.SnakeNLadder.Dice;

public class MultiDice implements Dice{
    private final int count;

    public MultiDice(int count) {
        this.count = count;
    }

    @Override
    public int roll() {
        int sum = 0;
        for (int i=0;i<count;i++){
            sum += (int) (Math.random() * (6));
        }
        return sum;
    }

    public int getCount() {
        return count;
    }
}
