package stratego.pieces;

import stratego.CombatResult;
// import stratego.PieceType;
import stratego.Player;
import stratego.Square;

/**
 * A special kind of chess piece that can destroy Bomb without being killed.
 */
public class Miner extends StepMover {

    // private PieceType type;

    /**
     * Constructor of StepMover.
     * 
     * @param owner: Player of the miner piece
     * @param square: the square where the piece stands
     */
    public Miner(Player owner, Square square) {
        super(owner, square, 3);
        // type=PieceType.Miner;
    }

    /**
     * @param targetPiece
     * @return CombatResult
     */
    @Override
    public CombatResult resultWhenAttacking(Piece targetPiece) {
        // if(targetPiece.getType() == PieceType.Bomb){
        // this.getSquare().removePiece();
        // targetPiece.getSquare().removePiece();
        // targetPiece.getSquare().placePiece(this);
        // return CombatResult.WIN;
        // }
        if (targetPiece instanceof Bomb) {
            this.getSquare().removePiece();
            targetPiece.getSquare().removePiece();
            targetPiece.getSquare().placePiece(this);
            return CombatResult.WIN;
        }
        return super.resultWhenAttacking(targetPiece);
    }
}
