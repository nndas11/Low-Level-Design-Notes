package BehaviouralDesignPatterns.LLDProblems.SnakeNLadder.Jump;

public class JumpEntityFactory {
    public static JumpEntity createJumpEntity(JumpEntityType jumpEntityType, int start, int end){
        return switch (jumpEntityType) {
            case SNAKE -> new Snake(start, end);
            case LADDER -> new Ladder(start, end);
            default -> throw new IllegalArgumentException("Unsupported Jump Entity Type: " + jumpEntityType);
        };
    }
}
