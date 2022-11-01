package stratego.pieces;

import java.util.ArrayList;

import stratego.CombatResult;
import stratego.Player;
import stratego.Square;

public abstract class Piece {
    private Player owner;
    private Square square;
    private int rank;
    //private PieceType type;

    public Piece(Player owner, Square square, int rank) {
        if (square.getPiece() != null) {
            throw new IllegalArgumentException();
        }
        this.owner = owner;
        this.rank = rank;
        square.placePiece(this);
        this.square = square;
    }

    public abstract ArrayList<Square> getLegalMoves();

    public abstract ArrayList<Square> getLegalAttacks();

    public void move(Square toSquare) {
        if (toSquare.getPiece() == null && toSquare.canBeEntered()) {
            this.getSquare().removePiece();
            toSquare.placePiece(this);
            setSquare(toSquare);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void attack(Square targetSquare) {
        if (targetSquare.getPiece() == null) {
            throw new IllegalArgumentException();
        } else {
            attackSpy(targetSquare);
            attackBomb(targetSquare);
            attackFlag(targetSquare);
            attackNormal(targetSquare);
        }
    }

    public void attackNormal(Square targetSquare) {
        CombatResult temp = resultWhenAttacking(targetSquare.getPiece());
        if (temp == CombatResult.WIN) {
            this.getSquare().removePiece();
            targetSquare.removePiece();
            targetSquare.placePiece(this);
        } else if (temp == CombatResult.LOSE) {
            this.getSquare().removePiece();
            targetSquare.removePiece();
        } else {
            this.getSquare().removePiece();
        }
    }

    public void attackSpy(Square targetSquare) {
        if (targetSquare.getPiece() instanceof Spy) {
            targetSquare.removePiece();
            this.move(targetSquare);
        }
    }

    public void attackBomb(Square targetSquare) {
        if (targetSquare.getPiece() instanceof Bomb) {
            targetSquare.removePiece();
            this.getSquare().removePiece();
        }
    }

    public void attackFlag(Square targetSquare) {
        if (targetSquare.getPiece() instanceof Flag) {
            //targetSquare.getPiece().getOwner().loseGame();
            targetSquare.getPiece().beCaptured();
            this.getSquare().removePiece();
            targetSquare.placePiece(this);
        }
    }

    public CombatResult resultWhenAttacking(Piece targetPiece) {
        if(targetPiece instanceof Bomb){
            return CombatResult.DRAW;
        }
        if(targetPiece instanceof Flag){
            return CombatResult.WIN;
        }
        else{
            if (this.getRank() > targetPiece.getRank()) {
                return CombatResult.WIN;
            } else if (this.getRank() == targetPiece.getRank()) {
                return CombatResult.DRAW;
            } else {
                return CombatResult.LOSE;
            }
        }
    }

    public void beCaptured() {
    }

    public Square getSquare() {
        return this.square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    public Player getOwner() {
        return this.owner;
    }

    public int getRank() {
        return this.rank;
    }

    // public PieceType getType() {
    //     return this.type;
    // }
}
