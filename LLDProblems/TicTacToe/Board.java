package BehaviouralDesignPatterns.LLDProblems.TicTacToe;

import BehaviouralDesignPatterns.LLDProblems.TicTacToe.PlayingPeice.PlayingPiece;
import BehaviouralDesignPatterns.LLDProblems.TicTacToe.PlayingPeice.PlayingPieceType;

import java.util.HashMap;
import java.util.Map;

public class Board  {
    private final int size;
//    Doubt can it be final
    private PlayingPiece[][] board;

    private Map<PlayingPiece, Integer>[] rowCount;
    private Map<PlayingPiece, Integer>[] colCount;
    private Map<PlayingPiece, Integer> diagonalCount;
    private Map<PlayingPiece, Integer> antiDiagonalCount;

    public Board(int size) {
        this.size = size;
        this.board = new PlayingPiece[size][size];

        this.rowCount = new HashMap[size];
        this.colCount = new HashMap[size];
        this.diagonalCount = new HashMap<>();
        this.antiDiagonalCount = new HashMap<>();

        for (int i=0;i<size;i++){
            rowCount[i] = new HashMap<>();
            colCount[i] = new HashMap<>();
        }

    }


    public int getSize() {
        return size;
    }

    public PlayingPiece[][] getBoard() {
        return board;
    }

    public void printBoard(){
        for (int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                if(board[i][j] != null)
                    System.out.print(board[i][j].getPlayingPieceType().name() + " ");
                else
                    System.out.print("  ");
            }
            System.out.println(" | ");
        }

    }

//    this takes O(n) time -> we can make it constant.
//    we can create array for each row, col and for both diagonal count -> like did in SUDUKO problem.
//    so simple way create arrays -> use +1 and -1 for X and O -> if absolute value reaches 3 -> then won
//    But if needed to make it extensible then we would need map ->
    public boolean isWinOptimised(int r, int c, PlayingPiece playingPiece){
        return this.rowCount[r].getOrDefault(playingPiece,0) == size ||
                this.colCount[c].getOrDefault(playingPiece, 0) == size ||
                this.diagonalCount.getOrDefault(playingPiece, 0) == size ||
                this.antiDiagonalCount.getOrDefault(playingPiece, 0) == size;
    }

    public boolean isWin(int r, int c, PlayingPieceType playingPieceType){

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;


//        check in that row
        for(int i=0;i< size;i++){
            if (board[r][i] == null || board[r][i].getPlayingPieceType() != playingPieceType) {
                rowMatch = false;
                break;
            }

        }

        for(int i=0;i< size;i++){
            if (board[i][c] == null || board[i][c].getPlayingPieceType() != playingPieceType) {
                columnMatch = false;
                break;
            }

        }

        for (int i=0, j=0;i< size;i++,j++){
            if (board[i][j] == null || board[i][j].getPlayingPieceType() != playingPieceType) {
                diagonalMatch = false;
                break;
            }
        }


        for(int i=0, j=size-1; i<size;i++,j--) {
            if (board[i][j] == null || board[i][j].getPlayingPieceType() != playingPieceType) {
                antiDiagonalMatch = false;
                break;
            }
        }


        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }

    public boolean makeMove(PlayingPiece playingPiece, int r, int c){

        if (board[r][c] != null)
            return false;

        this.board[r][c] = playingPiece;
        this.rowCount[r].put(playingPiece, this.rowCount[r].getOrDefault(playingPiece, 0) + 1);
        this.colCount[c].put(playingPiece, this.colCount[c].getOrDefault(playingPiece, 0) + 1);

        if(r == c)
            this.diagonalCount.put(playingPiece, this.diagonalCount.getOrDefault(playingPiece, 0) + 1);

        if(r + c == size - 1)
            this.antiDiagonalCount.put(playingPiece, this.antiDiagonalCount.getOrDefault(playingPiece, 0) + 1);

        return true;
    }

}
