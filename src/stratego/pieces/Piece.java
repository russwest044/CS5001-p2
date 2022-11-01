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

    
    /** 
     * @param toSquare
     */
    public void move(Square toSquare) {
        if (toSquare.getPiece() == null && toSquare.canBeEntered()) {
            this.getSquare().removePiece();
            toSquare.placePiece(this);
            setSquare(toSquare);
        } else {
            throw new IllegalArgumentException();
        }
    }

    
    /** 
     * @param targetSquare
     */
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

    
    /** 
     * @param targetSquare
     */
    public void attackNormal(Square targetSquare) {
        CombatResult temp = resultWhenAttacking(targetSquare.getPiece());
        if (temp == CombatResult.WIN) {
            targetSquare.getPiece().beCaptured();
            this.getSquare().removePiece();
            targetSquare.removePiece();
            targetSquare.placePiece(this);
        } else if (temp == CombatResult.LOSE) {
            this.getSquare().removePiece();
            this.beCaptured();
            targetSquare.removePiece();
        } else {
            this.getSquare().removePiece();
            this.beCaptured();
            targetSquare.removePiece();
            targetSquare.getPiece().beCaptured();
        }
    }

    
    /** 
     * @param targetSquare
     */
    public void attackSpy(Square targetSquare) {
        if (targetSquare.getPiece() instanceof Spy) {
            targetSquare.removePiece();
            this.move(targetSquare);
        }
    }

    
    /** 
     * @param targetSquare
     */
    public void attackBomb(Square targetSquare) {
        if (targetSquare.getPiece() instanceof Bomb) {
            targetSquare.removePiece();
            this.getSquare().removePiece();
        }
    }

    
    /** 
     * @param targetSquare
     */
    public void attackFlag(Square targetSquare) {
        if (targetSquare.getPiece() instanceof Flag) {
            //targetSquare.getPiece().getOwner().loseGame();
            targetSquare.getPiece().beCaptured();
            this.getSquare().removePiece();
            targetSquare.placePiece(this);
        }
    }

    
    /** 
     * @param targetPiece
     * @return CombatResult
     */
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
        this.setSquare(null);
    }

    
    /** 
     * @return Square
     */
    public Square getSquare() {
        return this.square;
    }

    
    /** 
     * @param square
     */
    public void setSquare(Square square) {
        this.square = square;
    }

    
    /** 
     * @return Player
     */
    public Player getOwner() {
        return this.owner;
    }

    
    /** 
     * @return int
     */
    public int getRank() {
        return this.rank;
    }

    // public PieceType getType() {
    //     return this.type;
    // }
}
