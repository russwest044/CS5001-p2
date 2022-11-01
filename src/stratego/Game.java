package stratego;

public class Game{
    public static int HEIGHT = 10;
    public static int WIDTH = 10;
    public static int[] WATER_ROWS = {4, 5};
    public static int[] WATER_COLS = {2, 3, 6, 7};

    private Player p0;
    private Player p1;

    private Square[][] GameBoard;

    public Game(Player p0, Player p1){
        this.p0 = p0;
        this.p1 = p1;
        for(int i = 0; i < HEIGHT; i++){
            for(int j = 0; j < WIDTH; j++){
                GameBoard[i][j] = new Square(this, i, j, IsWater(i, j));
            }
        }
    }

    // public boolean setPiece(Player owner, int x, int y, int rank){
    //     if(GameBoard[x][y].getPiece() != null){
    //         return false;
    //     }
    //     GameBoard[x][y].placePiece(new Piece(owner, GameBoard[x][y], rank));
    //     return true;
    // }

    public boolean IsWater(int x, int y){
        for(int i = 0; i < WATER_ROWS.length; i++){
            for(int j = 0; j < WATER_ROWS.length; j++){
                if(x == i && y == j){
                    return true;
                }
            }
        }
        return false;
    }

    public Player getPlayer(int playerNumber) {
        if(this.p0.getPlayerNumber() == playerNumber) {
            return p0;
        }else{
            return p1;
        }
    }

    public Player getWinner(){
        if (this.p0.hasLost()) {
            return this.p1;
        }
        if (this.p1.hasLost()) {
            return this.p0;
        }
        return null;
    }

    public Square getSquare(int row, int col) {
        try {
            if(row >= HEIGHT || row < 0 || col >= WIDTH || col < 0){
                return null;
            }
            return GameBoard[row][col];
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}