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
     * @param owner Player of the piece
     * @param square the square where the piece stands
     * @param rank in fact, ImmobliePiece does not have rank
     */
    public ImmobilePiece(Player owner, Square square, int rank) {
        super(owner, square, 0);
    }

    /**
     * The function to return legalmove squares.
     * @return ArrayList<Square> for ImmobliePiece, there is no legal move
     */
    @Override
    public ArrayList<Square> getLegalMoves() {
        return new ArrayList<>();
    }

    /**
     * The function to return legalattack squares.
     * @return ArrayList<Square> for ImmobliePiece, cannot attack
     */
    @Override
    public ArrayList<Square> getLegalAttacks() {
        return new ArrayList<>();
    }
}
