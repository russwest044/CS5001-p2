package stratego;

import stratego.pieces.Piece;;

/**
 * A class to define class Square and implement its functions.
 */
public class Square {
    private Game game;
    private int row;
    private int col;
    private boolean isWater = false;
    private Piece piece = null;

    /**
     * Constructor of square.
     * 
     * @param game the game
     * @param row row number
     * @param col column number
     * @param isWater whether a piece can be put on the square
     */
    public Square(Game game, int row, int col, boolean isWater) {
        this.game = game;
        this.row = row;
        this.col = col;
        this.isWater = isWater;
    }

    /**
     * The function to place piece on current square.
     * @param piece the piece that will be put on
     */
    public void placePiece(Piece piece) {
        if (this.piece != null || this.canBeEntered()) {
            throw new IllegalArgumentException();
        }
        this.piece = piece;
    }

    /**
     * The fuction to remove the piece on the current square.
     */
    public void removePiece() {
        this.piece = null;
    }

    /**
     * The function to get current game.
     * @return Game
     */
    public Game getGame() {
        return game;
    }

    /**
     * The function to get the piece that stands on current square.
     * @return Piece
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * The function to get current row number.
     * @return int
     */
    public int getRow() {
        return row;
    }

    /**
     * The function to get current colunmn number.
     * @return int
     */
    public int getCol() {
        return col;
    }

    /**
     * The function to decide whether the suare is in water area.
     * @return boolean
     */
    public boolean canBeEntered() {
        return !isWater;
    }
}
