package stratego.pieces;

import java.util.ArrayList;

import stratego.Player;
import stratego.Square;

/**
 * A class to define Scout and implement its functions.
 */
public class Scout extends Piece {

    /**
     * Constructor of Scout
     * @param owner: the Player of the piece
     * @param square: the square where the piece stands
     */
    public Scout(Player owner, Square square) {
        super(owner, square, 2);
    }

    /**
     * @return ArrayList<Square>
     */
    @Override
    public ArrayList<Square> getLegalMoves() {
        ArrayList<Square> moveArea = new ArrayList<>();
        int x = super.getSquare().getRow();
        int y = super.getSquare().getCol();

        while (super.getSquare().getGame().getSquare(x + 1, y) != null
        && super.getSquare().getGame().getSquare(x + 1, y).canBeEntered()
        && super.getSquare().getGame().getSquare(x + 1, y).getPiece() == null) {
            moveArea.add(super.getSquare().getGame().getSquare(x + 1, y));
            x++;
        }
        x = super.getSquare().getRow();

        while (super.getSquare().getGame().getSquare(x - 1, y) != null
        && super.getSquare().getGame().getSquare(x - 1, y).canBeEntered()
        && super.getSquare().getGame().getSquare(x - 1, y).getPiece() == null) {
            moveArea.add(super.getSquare().getGame().getSquare(x - 1, y));
            x--;
        }
        x = super.getSquare().getRow();

        while (super.getSquare().getGame().getSquare(x, y + 1) != null
        && super.getSquare().getGame().getSquare(x, y + 1).canBeEntered()
        && super.getSquare().getGame().getSquare(x, y + 1).getPiece() == null) {
            moveArea.add(super.getSquare().getGame().getSquare(x, y + 1));
            y++;
        }
        y = super.getSquare().getCol();

        while (super.getSquare().getGame().getSquare(x, y - 1) != null
        && super.getSquare().getGame().getSquare(x, y - 1).canBeEntered()
        && super.getSquare().getGame().getSquare(x, y - 1).getPiece() == null) {
            moveArea.add(super.getSquare().getGame().getSquare(x, y - 1));
            y--;
        }
        y = super.getSquare().getCol();

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
