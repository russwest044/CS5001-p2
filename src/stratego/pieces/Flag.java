package stratego.pieces;

import stratego.Player;
import stratego.Square;

public class Flag extends ImmobilePiece{

    public Flag(Player owner, Square square){
        super(owner, square, 0);
    }

    @Override
    public void beCaptured(){
        this.getSquare().removePiece();
        this.getOwner().loseGame();
    }
}
