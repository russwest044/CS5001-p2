package stratego;

import stratego.pieces.Piece;;

public class Square {
    private Game game;
    private int row;
    private int col;
    private boolean isWater = false;
    private Piece piece = null;

    public Square(Game game, int row, int col, boolean isWater){
        this.game = game;
        this.row = row;
        this.col = col;
        this.isWater = isWater;
    }

    public void placePiece(Piece piece){
        if (this.piece != null || this.isWater == true) {
            throw new IllegalArgumentException();
        }
        this.piece = piece;
    }

    public void removePiece(){
        this.piece = null;
    }

    public Game getGame(){
        return this.game;
    }

    public Piece getPiece(){
        return this.piece;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    public boolean canBeEntered(){
        return !isWater;
    }
}
