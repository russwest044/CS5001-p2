package stratego.pieces;

import stratego.CombatResult;
// import stratego.PieceType;
import stratego.Player;
import stratego.Square;

/**
 * A class to define Spy and implement its functions.
 */
public class Spy extends StepMover {

    // private PieceType type;

    /**
     * Constructor of Spy.
     * @param player the Player of the piece
     * @param square the square where the piece stands
     */
    public Spy(Player player, Square square) {
        super(player, square, 0);
        // type = PieceType.Spy;
    }

    /**
     * The function to get special results of the spy combat.
     * @param targetPiece the target piece
     * @return CombatResult
     */
    @Override
    public CombatResult resultWhenAttacking(Piece targetPiece) {
        // if(targetPiece.getType() == PieceType.Marshal){
        // this.getSquare().removePiece();
        // targetPiece.getSquare().removePiece();
        // targetPiece.getSquare().placePiece(this);
        // return CombatResult.WIN;
        // }
        // if(targetPiece.getType() == PieceType.Flag){
        // targetPiece.getOwner().loseGame();
        // return CombatResult.WIN;
        // }
        if (targetPiece instanceof StepMover && targetPiece.getRank() == 10) {
            this.getSquare().removePiece();
            Square temp = targetPiece.getSquare();
            targetPiece.beCaptured();
            temp.placePiece(this);
            this.setSquare(temp);
            return CombatResult.WIN;
        }
        if (targetPiece instanceof Flag) {
            // targetPiece.getOwner().loseGame();
            targetPiece.beCaptured();
            return CombatResult.WIN;
        }
        if (targetPiece instanceof Spy) {
            targetPiece.beCaptured();
            this.beCaptured();
            return CombatResult.DRAW;
        }
        this.getSquare().removePiece();
        return CombatResult.LOSE;
    }
}
