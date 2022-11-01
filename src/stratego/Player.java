package stratego;

public class Player {
    private String name;
    private int playerNumber;
    private boolean lost = false;

    public Player(String name, int playerNumber){
        this.name = name;
        this.playerNumber = playerNumber;
    }

    
    /** 
     * @return String
     */
    public String getName(){
        return name;
    }

    
    /** 
     * @return int
     */
    public int getPlayerNumber(){
        return playerNumber;
    }

    public void loseGame(){
        this.lost = true;
    }

    
    /** 
     * @return boolean
     */
    public boolean hasLost(){
        return lost;
    }
}
