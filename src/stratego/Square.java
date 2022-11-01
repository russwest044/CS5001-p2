package stratego;

import stratego.pieces.Piece;;

/**
 * Objects, every square on the chessboard.
 */

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

    
    /** 
     * @param piece
     */
    public void placePiece(Piece piece){
        if (this.piece != null || this.isWater == true) {
            throw new IllegalArgumentException();
        }
        this.piece = piece;
    }

    public void removePiece(){
        this.piece = null;
    }

    
    /** 
     * @return Game
     */
    public Game getGame(){
        return this.game;
    }

    
    /** 
     * @return Piece
     */
    public Piece getPiece(){
        return this.piece;
    }

    
    /** 
     * @return int
     */
    public int getRow(){
        return row;
    }

    
    /** 
     * @return int
     */
    public int getCol(){
        return col;
    }

    
    /** 
     * @return boolean
     */
    public boolean canBeEntered(){
        return !isWater;
    }
}
