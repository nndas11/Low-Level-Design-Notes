package BehaviouralDesignPatterns.LLDProblems.TicTacToe;

import BehaviouralDesignPatterns.LLDProblems.TicTacToe.PlayingPeice.PlayingPiece;

public class Player {
    private final String name;
    private final int id;
    private final PlayingPiece playingPiece;

    public Player(String name, int id, PlayingPiece playingPiece) {
        this.name = name;
        this.id = id;
        this.playingPiece = playingPiece;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public PlayingPiece getPlayingPiece() {
        return playingPiece;
    }


}
