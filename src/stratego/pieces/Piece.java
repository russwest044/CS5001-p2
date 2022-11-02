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

    /**
     * The function to return legalmove squares, need to be overrided.
     * @return ArrayList<Square>
     */
    public abstract ArrayList<Square> getLegalMoves();

    /**
     * The function to return legalattack squares, need to be overrided.
     * @return ArrayList<Square>
     */
    public abstract ArrayList<Square> getLegalAttacks();

    /**
     * The function for pieces to make a move.
     * @param toSquare the target square to be placed
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
     * @param targetSquare the square where the target piece stands
     */
    public void attack(Square targetSquare) {
        if (targetSquare.getPiece() == null || this instanceof Bomb || this instanceof Flag) {
            throw new IllegalArgumentException();
        } else {
            // attackSpy(targetSquare);
            // attackBomb(targetSquare);
            // attackFlag(targetSquare);
            // attackNormal(targetSquare);
            CombatResult temp = resultWhenAttacking(targetSquare.getPiece());
            if (temp == CombatResult.WIN) {
                targetSquare.getPiece().beCaptured();
                this.getSquare().removePiece();
                targetSquare.placePiece(this);
                this.setSquare(targetSquare);
            }
            if (temp == CombatResult.LOSE) {
                this.beCaptured();
            }
            if (temp == CombatResult.DRAW) {
                this.beCaptured();
                targetSquare.getPiece().beCaptured();
                targetSquare.removePiece();
            }
        }
    }

    // /**
    //  * Attack normal StepMover pieces.
    //  * @param targetSquare the square where the target piece stands
    //  */
    // public void attackNormal(Square targetSquare) {
    //     CombatResult temp = resultWhenAttacking(targetSquare.getPiece());
    //     if (temp == CombatResult.WIN) {
    //         targetSquare.getPiece().beCaptured();
    //         targetSquare.removePiece();
    //         this.getSquare().removePiece();
    //         targetSquare.placePiece(this);
    //         this.setSquare(targetSquare);
    //     } else if (temp == CombatResult.LOSE) {
    //         this.getSquare().removePiece();
    //         this.beCaptured();
    //     } else {
    //         this.getSquare().removePiece();
    //         this.beCaptured();
    //         targetSquare.getPiece().beCaptured();
    //         targetSquare.removePiece();
    //     }
    // }

    // /**
    //  * Attack normal Spy pieces.
    //  * @param targetSquare the square where the target piece stands
    //  */
    // public void attackSpy(Square targetSquare) {
    //     if (targetSquare.getPiece() instanceof Spy) {
    //         targetSquare.getPiece().beCaptured();
    //         targetSquare.removePiece();
    //         this.move(targetSquare);
    //     }
    // }

    // /**
    //  * Attack normal Bomb pieces.
    //  * @param targetSquare the square where the target piece stands
    //  */
    // public void attackBomb(Square targetSquare) {
    //     if (targetSquare.getPiece() instanceof Bomb) {
    //         targetSquare.getPiece().beCaptured();
    //         this.beCaptured();
    //     }
    // }

    // /**
    //  * Attack normal Flag pieces.
    //  * @param targetSquare the square where the target piece stands
    //  */
    // public void attackFlag(Square targetSquare) {
    //     if (targetSquare.getPiece() instanceof Flag) {
    //         // targetSquare.getPiece().getOwner().loseGame();
    //         targetSquare.getPiece().beCaptured();
    //         this.getSquare().removePiece();
    //         targetSquare.placePiece(this);
    //     }
    // }

    /**
     * The function to get the result of combat.
     * @param targetPiece the target piece to be attacked
     * @return CombatResult
     */
    public CombatResult resultWhenAttacking(Piece targetPiece) {
        if (targetPiece instanceof Bomb) {
            return CombatResult.DRAW;
        }
        if (targetPiece instanceof Flag) {
            targetPiece.beCaptured();
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
        return square;
    }

    /**
     * The function to assign a square to the piece.
     * @param square change the square state of current piece
     */
    public void setSquare(Square square) {
        this.square = square;
    }

    /**
     * The function to get current player.
     * @return Player
     */
    public Player getOwner() {
        return owner;
    }

    /**
     * The function to get rank of current piece.
     * @return int
     */
    public int getRank() {
        return rank;
    }

    // public PieceType getType() {
    // return this.type;
    // }
}
