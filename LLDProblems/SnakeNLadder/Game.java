package BehaviouralDesignPatterns.LLDProblems.SnakeNLadder;

import BehaviouralDesignPatterns.LLDProblems.SnakeNLadder.Dice.Dice;
import BehaviouralDesignPatterns.LLDProblems.SnakeNLadder.Dice.SingleDice;
import BehaviouralDesignPatterns.LLDProblems.SnakeNLadder.Jump.*;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Game {
    private final Board board;
    private final Dice dice;
    private final Deque<Player> players;

    private static Game instance;

    private Game(Board board, List<Player> players, Dice dice){
        this.board = board;
        this.players = new LinkedList<>(players);
        this.dice = dice;
    }

    private Game(){
        this.board = new Board(100);
        this.dice = new SingleDice();
        this.players = new LinkedList<>(Arrays.asList(new Player("Player 1"), new Player("Player 2")));
        this.board.addJumpEntity(JumpEntityFactory.createJumpEntity(JumpEntityType.SNAKE, 56, 2));
        this.board.addJumpEntity(JumpEntityFactory.createJumpEntity(JumpEntityType.LADDER, 2, 100));
    }

    public static Game getInstance(){
        if(instance == null){
            return new Game();
        }
        return instance;
    }

    public static Game getInstance(Board board, List<Player> players, Dice dice) {
        if (instance == null) {
            instance = new Game(board, players, dice);
        }
        return instance;
    }

    public void startGame(){
        while (true){
            Player player = players.poll();
            System.out.println("Player: " + player.getName() + " currently at position: " + player.getPosition() + " turn to play the game");

            int roll = dice.roll();
            System.out.println("Player: " + player.getName() + " rolled a: " + roll);

            int newPosition = player.getPosition() + roll;
            if(newPosition > board.getSize()){
                System.out.println(player.getName() + " needs an exact roll of: " + (board.getSize() - player.getPosition()) + " to reach the destination: " + board.getSize());
                players.addLast(player);
                continue;
            }

            JumpEntity jumpEntity = board.getJumpEntity(newPosition);
            if(jumpEntity != null){
                System.out.println("Player: "+ player.getName() + " hits a: " + jumpEntity.getJumpEntityType().toString() + " moved from: " + newPosition + " to: "+ jumpEntity.getEnd());
                 newPosition = jumpEntity.getEnd();
            }
            System.out.println("Player: " + player.getName() + " moved to position: "+ newPosition);
            player.setPosition(newPosition);

            if(player.getPosition() == board.getSize()){
                System.out.println("Player: "+ player.getName() + " WON the game!!!!");
                break;
            }

            players.addLast(player);
        }
    }


}
