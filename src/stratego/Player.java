package stratego;

public class Player {
    private String name;
    private int playerNumber;
    private boolean lost = false;

    public Player(String name, int playerNumber){
        this.name = name;
        this.playerNumber = playerNumber;
    }

    public String getName(){
        return name;
    }

    public int getPlayerNumber(){
        return playerNumber;
    }

    public void loseGame(){
        this.lost = true;
    }

    public boolean hasLost(){
        return lost;
    }
}
