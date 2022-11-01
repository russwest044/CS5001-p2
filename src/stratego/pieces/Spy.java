package stratego.pieces;

import stratego.CombatResult;
// import stratego.PieceType;
import stratego.Player;
import stratego.Square;

public class Spy extends StepMover{

    // private PieceType type;

    public Spy(Player player, Square square){
        super(player, square, 0);
        // type = PieceType.Spy;
    }

    @Override
    public CombatResult resultWhenAttacking(Piece targetPiece) {
        // if(targetPiece.getType() == PieceType.Marshal){
        //     this.getSquare().removePiece();
        //     targetPiece.getSquare().removePiece();
        //     targetPiece.getSquare().placePiece(this);
        //     return CombatResult.WIN;
        // }
        // if(targetPiece.getType() == PieceType.Flag){
        //     targetPiece.getOwner().loseGame();
        //     return CombatResult.WIN;
        // }
        if(targetPiece instanceof StepMover && targetPiece.getRank() == 10){
            this.getSquare().removePiece();
            targetPiece.getSquare().removePiece();
            targetPiece.getSquare().placePiece(this);
            return CombatResult.WIN;
        }
        if(targetPiece instanceof Flag){
            // targetPiece.getOwner().loseGame();
            targetPiece.beCaptured();
            return CombatResult.WIN;
        }
        this.getSquare().removePiece();
        return CombatResult.LOSE;
    }
}
