package BehaviouralDesignPatterns.LLDProblems.SnakeNLadder.Jump;

public abstract class JumpEntity {
    protected final int start;
    protected final int end;
    protected final JumpEntityType jumpEntityType;

    public JumpEntity(int start, int end, JumpEntityType jumpEntityType) {
        this.start = start;
        this.end = end;
        this.jumpEntityType = jumpEntityType;
    }

    public JumpEntityType getJumpEntityType() {
        return jumpEntityType;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
