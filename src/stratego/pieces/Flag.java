package stratego.pieces;

import stratego.Player;
import stratego.Square;

/**
 * A special kind of chess piece that determines the winner of a match.
 */
public class Flag extends ImmobilePiece {

    /**
     * Constructor of Bomb.
     * 
     * @param owner Player of the Flag piece
     * @param square the square where the Flag stands
     */
    public Flag(Player owner, Square square) {
        super(owner, square, 0);
    }

    @Override
    public void beCaptured() {
        this.getOwner().loseGame();
    }
}
