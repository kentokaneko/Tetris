public class Game {
    long startTime;
    int[][] well = new int[20][10];
    Tetromino currentPiece = new Tetromino();

    public Game() {
	this.startTime = System.currentTimeMillis();

	for (int i = 0; i < well.length; i++) {
	    for (int j = 0; j < well[0].length; j++) {
		this.well[i][j] = 0;
	    }
	}
    }    
}
