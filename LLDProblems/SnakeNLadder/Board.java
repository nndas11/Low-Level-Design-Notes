package BehaviouralDesignPatterns.LLDProblems.SnakeNLadder;

import BehaviouralDesignPatterns.LLDProblems.SnakeNLadder.Jump.JumpEntity;
import BehaviouralDesignPatterns.LLDProblems.SnakeNLadder.Jump.JumpEntityType;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private final int size;
    private Map<Integer, JumpEntity> jumps;

    public Board(int size) {
        this.size = size;
        this.jumps = new HashMap<>();
    }

    public int getSize() {
        return size;
    }

    public void addJumpEntity(JumpEntity jumpEntity){
        this.jumps.put(jumpEntity.getStart(), jumpEntity);
    }

    public JumpEntity getJumpEntity(int position){
        return jumps.get(position);
    }

    public Map<Integer, JumpEntity> getJumps() {
        return jumps;
    }
}
