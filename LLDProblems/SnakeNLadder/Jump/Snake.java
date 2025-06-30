package BehaviouralDesignPatterns.LLDProblems.SnakeNLadder.Jump;

public class Snake extends JumpEntity{
    public Snake(int start, int end) {
        if(start <= end) throw new IllegalArgumentException("For snake head(start) > tail(end) required");
        super(start, end, JumpEntityType.SNAKE);
    }
}
