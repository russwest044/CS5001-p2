package stratego.pieces;

import java.util.ArrayList;

import stratego.Player;
import stratego.Square;

/**
 * A class to define normal pieces called StepMover and implement its functions.
 */
public class StepMover extends Piece {

    /**
     * Constructor of StepMover.
     * 
     * @param owner  the Player of the piece
     * @param square the square where the piece stands
     * @param rank   rank of the piece
     */
    public StepMover(Player owner, Square square, int rank) {
        super(owner, square, rank);
    }

    /**
     * The function to return legalmove squares.
     * 
     * @return ArrayList<Square>
     */
    @Override
    public ArrayList<Square> getLegalMoves() {
        ArrayList<Square> moveArea = new ArrayList<>();
        int x = this.getSquare().getRow();
        int y = this.getSquare().getCol();

        if (this.getSquare().getGame().isInBounds(x - 1, y)
                && this.getSquare().getGame().getSquare(x - 1, y).canBeEntered()) {
            moveArea.add(this.getSquare().getGame().getSquare(x - 1, y));
        }
        if (this.getSquare().getGame().isInBounds(x + 1, y)
                && this.getSquare().getGame().getSquare(x + 1, y).canBeEntered()) {
            moveArea.add(this.getSquare().getGame().getSquare(x + 1, y));
        }
        if (this.getSquare().getGame().isInBounds(x, y - 1)
                && this.getSquare().getGame().getSquare(x, y - 1).canBeEntered()) {
            moveArea.add(this.getSquare().getGame().getSquare(x, y - 1));
        }
        if (this.getSquare().getGame().isInBounds(x, y + 1)
                && this.getSquare().getGame().getSquare(x, y + 1).canBeEntered()) {
            moveArea.add(this.getSquare().getGame().getSquare(x, y + 1));
        }
        // moveArea.add(this.getSquare().getGame().getSquare(x - 1, y));
        // moveArea.add(this.getSquare().getGame().getSquare(x + 1, y));
        // moveArea.add(this.getSquare().getGame().getSquare(x, y - 1));
        // moveArea.add(this.getSquare().getGame().getSquare(x, y + 1));

        return moveArea;
    }

    /**
     * The function to return legalattack squares.
     * 
     * @return ArrayList<Square>
     */
    @Override
    public ArrayList<Square> getLegalAttacks() {
        ArrayList<Square> attackArea = new ArrayList<>();
        int x = this.getSquare().getRow();
        int y = this.getSquare().getCol();

        if (this.getSquare().getGame().isInBounds(x - 1, y)
                && this.getSquare().getGame().getSquare(x - 1, y).getPiece() != null) {
            attackArea.add(this.getSquare().getGame().getSquare(x - 1, y));
        }
        if (this.getSquare().getGame().isInBounds(x + 1, y)
                && this.getSquare().getGame().getSquare(x + 1, y).getPiece() != null) {
            attackArea.add(this.getSquare().getGame().getSquare(x + 1, y));
        }
        if (this.getSquare().getGame().isInBounds(x, y - 1)
                && this.getSquare().getGame().getSquare(x, y - 1).getPiece() != null) {
            attackArea.add(this.getSquare().getGame().getSquare(x, y - 1));
        }
        if (this.getSquare().getGame().isInBounds(x, y + 1)
                && this.getSquare().getGame().getSquare(x, y + 1).getPiece() != null) {
            attackArea.add(this.getSquare().getGame().getSquare(x, y + 1));
        }

        return attackArea;
    }
}
