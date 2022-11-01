package stratego.pieces;

import stratego.Player;
import stratego.Square;

import java.util.ArrayList;

/**
 * Defination of abstract class ImmobliePiece.
 */
public abstract class ImmobilePiece extends Piece {

    /**
     * Constructor of Bomb.
     * 
     * @param owner: Player of the piece
     * @param square: the square where the piece stands
     * @param rank: in fact, ImmobliePiece does not have rank
     */
    public ImmobilePiece(Player owner, Square square, int rank) {
        super(owner, square, 0);
    }

    /**
     * @return ArrayList<Square>
     */
    @Override
    public ArrayList<Square> getLegalMoves() {
        return null;
    }

    /**
     * @return ArrayList<Square>
     */
    @Override
    public ArrayList<Square> getLegalAttacks() {
        return null;
    }
}
