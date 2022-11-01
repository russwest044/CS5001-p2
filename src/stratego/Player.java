package stratego;

/**
 * A class to define Player and implement its functions.
 */
public class Player {
    private String name;
    private int playerNumber;
    private boolean lost = false;

    /**
     * Constructor of Player.
     * 
     * @param name the name of Player
     * @param playerNumber the number of Player
     * 
     */
    public Player(String name, int playerNumber) {
        this.name = name;
        this.playerNumber = playerNumber;
    }

    /**
     * The function to get Player's name.
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * The function to get player's number.
     * @return int
     */
    public int getPlayerNumber() {
        return playerNumber;
    }

    /**
     * The function to give a result of the game.
     */
    public void loseGame() {
        this.lost = true;
    }

    /**
     * The function to judge whether a player loses the game.
     * @return boolean
     */
    public boolean hasLost() {
        return lost;
    }
}
