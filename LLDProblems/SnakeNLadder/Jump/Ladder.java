package BehaviouralDesignPatterns.LLDProblems.SnakeNLadder.Jump;

public class Ladder extends JumpEntity{
    public Ladder(int start, int end) {
        if(start >= end)    throw new IllegalArgumentException("Ladder start < end required");
        super(start, end, JumpEntityType.LADDER);
    }
}
