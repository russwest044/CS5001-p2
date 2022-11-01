package stratego.pieces;

import java.util.ArrayList;

import stratego.Player;
import stratego.Square;

/**
 * A class to define normal pieces called StepMover and implement its functions.
 */
public class StepMover extends Piece {

    /**
     * Constructor of StepMover
     * @param owner: the Player of the piece
     * @param square: the square where the piece stands
     * @param rank: rank of the piece
     */
    public StepMover(Player owner, Square square, int rank) {
        super(owner, square, rank);
    }

    /**
     * @return ArrayList<Square>
     */
    @Override
    public ArrayList<Square> getLegalMoves() {
        ArrayList<Square> moveArea = new ArrayList<>();
        int x = super.getSquare().getRow();
        int y = super.getSquare().getCol();

        moveArea.add(super.getSquare().getGame().getSquare(x - 1, y));
        moveArea.add(super.getSquare().getGame().getSquare(x + 1, y));
        moveArea.add(super.getSquare().getGame().getSquare(x, y - 1));
        moveArea.add(super.getSquare().getGame().getSquare(x, y + 1));

        return moveArea;
    }

    /**
     * @return ArrayList<Square>
     */
    @Override
    public ArrayList<Square> getLegalAttacks() {
        ArrayList<Square> attackArea = new ArrayList<>();
        int x = super.getSquare().getRow();
        int y = super.getSquare().getCol();

        if (super.getSquare().getGame().getSquare(x - 1, y).getPiece() != null) {
            attackArea.add(super.getSquare().getGame().getSquare(x - 1, y));
        }
        if (super.getSquare().getGame().getSquare(x + 1, y).getPiece() != null) {
            attackArea.add(super.getSquare().getGame().getSquare(x + 1, y));
        }
        if (super.getSquare().getGame().getSquare(x, y - 1).getPiece() != null) {
            attackArea.add(super.getSquare().getGame().getSquare(x, y - 1));
        }
        if (super.getSquare().getGame().getSquare(x, y + 1).getPiece() != null) {
            attackArea.add(super.getSquare().getGame().getSquare(x, y + 1));
        }

        return attackArea;
    }
}
