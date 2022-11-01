package stratego.pieces;

import stratego.CombatResult;
// import stratego.PieceType;
import stratego.Player;
import stratego.Square;

public class Miner extends StepMover{

    // private PieceType type;

    public Miner(Player owner, Square square){
        super(owner, square, 3);
        // type=PieceType.Miner;
    }

    @Override
    public CombatResult resultWhenAttacking(Piece targetPiece) {
        // if(targetPiece.getType() == PieceType.Bomb){
        //     this.getSquare().removePiece();
        //     targetPiece.getSquare().removePiece();
        //     targetPiece.getSquare().placePiece(this);
        //     return CombatResult.WIN;
        // }
        if(targetPiece instanceof Bomb){
            this.getSquare().removePiece();
            targetPiece.getSquare().removePiece();
            targetPiece.getSquare().placePiece(this);
            return CombatResult.WIN;
        }
        return super.resultWhenAttacking(targetPiece);
    }
}
