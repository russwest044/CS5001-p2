package stratego.pieces;

import stratego.Player;
import stratego.Square;

import java.util.ArrayList;

public abstract class ImmobilePiece extends Piece{
    
    public ImmobilePiece(Player owner, Square square, int rank){
        super(owner, square, 0);
    }

    @Override
    public ArrayList<Square> getLegalMoves() {
        return null;
    }

    @Override
    public ArrayList<Square> getLegalAttacks() {
        return null;
    }
}
