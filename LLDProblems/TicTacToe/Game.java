package BehaviouralDesignPatterns.LLDProblems.TicTacToe;

import BehaviouralDesignPatterns.LLDProblems.TicTacToe.PlayingPeice.PlayingPiece;
import BehaviouralDesignPatterns.LLDProblems.TicTacToe.PlayingPeice.PlayingPieceType;
import BehaviouralDesignPatterns.LLDProblems.TicTacToe.PlayingPeice.PlayingPieceX;
import BehaviouralDesignPatterns.LLDProblems.TicTacToe.PlayingPeice.PlayingPieceO;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {
    private Board board;
    private GameStatus gameStatus;
    private Deque<Player> players;

    public Game(Board board, Deque<Player> players) {
        this.board = board;
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.players = players;
    }

    public Game() {
        this.board =  new Board(3);

        Player player1 = new Player("player1", 1, new PlayingPieceX());
        Player player2 = new Player("player2", 2, new PlayingPieceO());
        this.players = new LinkedList<>();
        this.players.addLast(player1);
        this.players.addLast(player2);

        this.gameStatus = GameStatus.IN_PROGRESS;
    }


    public void startGame(){

//        while loop to play the game till win.
        while (this.gameStatus == GameStatus.IN_PROGRESS){

            Player playerTurn = players.removeFirst();

            board.printBoard();

            System.out.println("Turn of the Player: " + playerTurn.getName() + " Enter row and column: ");
            Scanner input = new Scanner(System.in);
            String s = input.nextLine();
            String[] value = s.split(",");
            int row = Integer.parseInt(value[0]);
            int col = Integer.parseInt(value[1]);

            if(!board.makeMove(playerTurn.getPlayingPiece(), row, col)){
                System.out.println("Unable to make this move: this position is already filled: " + row + ", " + col);
                players.addFirst(playerTurn);
                continue;
            }

            if (board.isWinOptimised(row, col, playerTurn.getPlayingPiece())){
                this.gameStatus = GameStatus.WIN;
                board.printBoard();
                System.out.println(playerTurn.getName() + " won the game");
                return;
            }

            players.addLast(playerTurn);

        }
        this.gameStatus = GameStatus.DRAW;
        System.out.println("Game is in a DRAW");
    }


    public Board getBoard() {
        return board;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public Deque<Player> getPlayers() {
        return players;
    }
}
