import java.util.List;

import stratego.Game;
import stratego.Player;
import stratego.Square;
import stratego.pieces.*;

public class Test {
    public static void main(String[] args) {
        // Player p0 = new Player("Michael", 0);
        // Player p1 = new Player("Ozgur", 1);
        // Game game = new Game(p0, p1);
        // Piece marshal = new StepMover(p0, game.getSquare(0, 3), 10);
        // // Piece sergeant = new StepMover(p1, game.getSquare(0, 2), 4);
        // // Piece captain = new StepMover(p1, game.getSquare(1, 2), 6);
        // List<Square> moves = marshal.getLegalMoves();
        // System.out.println(moves.contains(game.getSquare(0, 4)));
        // System.out.println(moves.contains(game.getSquare(1, 3)));
        // System.out.println(moves.contains(game.getSquare(0, 2)));
        
        // Player p0 = new Player("Michael", 0);
        // Player p1 = new Player("Ozgur", 1);
        // Game game = new Game(p0, p1);
        // Flag flag = new Flag(p0, game.getSquare(0, 3));
        // StepMover attacker = new StepMover(p1, game.getSquare(1, 3), 5);

        // attacker.attack(game.getSquare(0, 3));

        // // Flag is gone
        // System.out.println(flag.getSquare());
        // // assertNull(flag.getSquare());

        // // Attacker takes flag's place
        // System.out.println(game.getSquare(0, 3).equals(attacker.getSquare()));
        // // assertEquals(game.getSquare(0, 3), attacker.getSquare());

        // // Flag is captured and its owner loses the game
        // System.out.println(flag.getOwner().hasLost());
        // // assertTrue(flag.getOwner().hasLost());
        // System.out.println(p1.equals(game.getWinner()));
        // // assertEquals(p1, game.getWinner());

        // Player p0 = new Player("Michael", 0);
        // Player p1 = new Player("Ozgur", 1);
        // Game game = new Game(p0, p1);
        // StepMover marshal = new StepMover(p0, game.getSquare(0, 3), 10);
        // StepMover sergeant = new StepMover(p1, game.getSquare(0, 2), 4);
        // StepMover captain = new StepMover(p1, game.getSquare(1, 2), 6);

        // // It can attack the sergeant next to it
        // List<Square> attacks = marshal.getLegalAttacks();
        // System.out.println(attacks.size() == 1);
        // // assertEquals(1, attacks.size());
        // System.out.println(attacks.contains(game.getSquare(0, 2)));
        // // assertTrue(attacks.contains(game.getSquare(0, 2)));  // contains sergeant
        // System.out.println(attacks.contains(game.getSquare(1, 2)));
        // assertFalse(attacks.contains(game.getSquare(1, 2)));  // captain is diagonal
        // Miner miner = new Miner(p0, game.getSquare(0, 3));
        // Bomb bomb = new Bomb(p1, game.getSquare(1, 3));
        // StepMover sergeant = new StepMover(p1, game.getSquare(0, 2), 4);

        // miner.attack(game.getSquare(1, 3));

        // // Bomb is safely defused and miner is safe
        // System.out.println(bomb.getSquare());
        // // assertNull(bomb.getSquare());
        // System.out.println(game.getSquare(1, 3).equals(miner.getSquare()));
        // assertEquals(game.getSquare(1, 3), miner.getSquare());



        // Square land = new Square(null, 1, 2, false);  // null game, but should still work
        // Square land2 = new Square(null, 1, 3, false);
        // Square land3 = new Square(null, 0, 3, false);
        // Square water = new Square(null, 3, 1, true);
        // Square water2 = new Square(null, 4, 1, true);

        // Player michael = new Player("Michael", 0);

        // Scout lance = new Scout(michael, land);
        // StepMover general = new StepMover(michael, land3, 9);

        // System.out.println(land.canBeEntered());



    }
}
