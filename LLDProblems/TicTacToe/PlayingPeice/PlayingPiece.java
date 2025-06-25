package BehaviouralDesignPatterns.LLDProblems.TicTacToe.PlayingPeice;

public abstract class PlayingPiece {
    protected PlayingPieceType playingPieceType;

    public PlayingPiece(PlayingPieceType playingPieceType) {
        this.playingPieceType = playingPieceType;
    }

    public PlayingPieceType getPlayingPieceType() {
        return playingPieceType;
    }
}
