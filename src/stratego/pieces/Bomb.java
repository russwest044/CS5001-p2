package stratego.pieces;

// import stratego.PieceType;
import stratego.Player;
import stratego.Square;

/**
 * A special kind of piece that destroys itself and its attacker, except for miners.
 */

public class Bomb extends ImmobilePiece{

    // private PieceType type;
    public Bomb(Player owner, Square square){
        super(owner, square, 0);
        // type = PieceType.Bomb; 
    }
}
