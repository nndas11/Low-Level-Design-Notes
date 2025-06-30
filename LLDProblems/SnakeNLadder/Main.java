package BehaviouralDesignPatterns.LLDProblems.SnakeNLadder;

import BehaviouralDesignPatterns.LLDProblems.SnakeNLadder.Dice.Dice;
import BehaviouralDesignPatterns.LLDProblems.SnakeNLadder.Dice.SingleDice;
import BehaviouralDesignPatterns.LLDProblems.SnakeNLadder.Jump.Ladder;
import BehaviouralDesignPatterns.LLDProblems.SnakeNLadder.Jump.Snake;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Game snakeAndLadder = new Game();
        Game.getInstance().startGame();

//        Board board = new Board(100);
//        board.addJumpEntity(new Snake(99, 54));
//        board.addJumpEntity(new Snake(70, 55));
//        board.addJumpEntity(new Snake(52, 42));
//        board.addJumpEntity(new Snake(25, 2));
//
//        board.addJumpEntity(new Ladder(6, 25));
//        board.addJumpEntity(new Ladder(11, 40));
//        board.addJumpEntity(new Ladder(60, 85));
//        board.addJumpEntity(new Ladder(46, 90));
//
//        List<Player> players = Arrays.asList(new Player("Alice"), new Player("Bob"));
//        Dice dice = new SingleDice(); // or new MultiDice(2);
//        new Game(board, players, dice).startGame();
    }
}
