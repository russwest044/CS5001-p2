package stratego.pieces;

import java.util.ArrayList;

import stratego.CombatResult;
import stratego.Player;
import stratego.Square;

/**
 * A class to define abstract Piece and implement its basic functions.
 */
public abstract class Piece {
    private Player owner;
    private Square square;
    private int rank;
    // private PieceType type;

    /**
     * Constructor of Piece.
     * 
     * @param owner the Player of the piece
     * @param square the square where the piece stands
     * @param rank rank of piece
     */
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
     * The function for pieces to make a move.
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
     * The function for pieces to make a attack.
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
     * Attack normal StepMover pieces.
     * @param targetSquare
     */
    public void attackNormal(Square targetSquare) {
        CombatResult temp = resultWhenAttacking(targetSquare.getPiece());
        if (temp == CombatResult.WIN) {
            targetSquare.getPiece().beCaptured();
            this.getSquare().removePiece();
            targetSquare.removePiece();
            targetSquare.placePiece(this);
            this.setSquare(targetSquare);
        } else if (temp == CombatResult.LOSE) {
            this.getSquare().removePiece();
            this.beCaptured();
        } else {
            this.getSquare().removePiece();
            this.beCaptured();
            targetSquare.removePiece();
            targetSquare.getPiece().beCaptured();
        }
    }

    /**
     * Attack normal Spy pieces.
     * @param targetSquare
     */
    public void attackSpy(Square targetSquare) {
        if (targetSquare.getPiece() instanceof Spy) {
            targetSquare.getPiece().beCaptured();
            targetSquare.removePiece();
            this.move(targetSquare);
        }
    }

    /**
     * Attack normal Bomb pieces.
     * @param targetSquare
     */
    public void attackBomb(Square targetSquare) {
        if (targetSquare.getPiece() instanceof Bomb) {
            targetSquare.getPiece().beCaptured();
            targetSquare.removePiece();
            this.getSquare().removePiece();
            this.beCaptured();
        }
    }

    /**
     * Attack normal Flag pieces.
     * @param targetSquare
     */
    public void attackFlag(Square targetSquare) {
        if (targetSquare.getPiece() instanceof Flag) {
            // targetSquare.getPiece().getOwner().loseGame();
            targetSquare.getPiece().beCaptured();
            this.getSquare().removePiece();
            targetSquare.placePiece(this);
        }
    }

    /**
     * The function to get the result of combat.
     * @param targetPiece
     * @return CombatResult
     */
    public CombatResult resultWhenAttacking(Piece targetPiece) {
        if (targetPiece instanceof Bomb) {
            return CombatResult.DRAW;
        }
        if (targetPiece instanceof Flag) {
            return CombatResult.WIN;
        } else {
            if (this.getRank() > targetPiece.getRank()) {
                return CombatResult.WIN;
            } else if (this.getRank() == targetPiece.getRank()) {
                return CombatResult.DRAW;
            } else {
                return CombatResult.LOSE;
            }
        }
    }

    /**
     * Once a piece is destoried, that means it is captured and it should be removed.
     */
    public void beCaptured() {
        this.getSquare().removePiece();
        this.setSquare(null);
    }

    /**
     * The function to get current square.
     * @return Square
     */
    public Square getSquare() {
        return this.square;
    }

    /**
     * The function to assign a square to the piece.
     * @param square
     */
    public void setSquare(Square square) {
        this.square = square;
    }

    /**
     * The function to get current player.
     * @return Player
     */
    public Player getOwner() {
        return this.owner;
    }

    /**
     * The function to get rank of current piece.
     * @return int
     */
    public int getRank() {
        return this.rank;
    }

    // public PieceType getType() {
    // return this.type;
    // }
}
