import java.util.Random;
import java.lang.String;

public class Tetromino {
    final static int[][][] TETROMINOS = {
    {{0}},
    
    {{0,0,0,0},
     {0,0,0,0},
     {1,1,1,1},
     {0,0,0,0}},
     
     {{2,2},
      {2,2}},
     
     {{0,3,0},
      {3,3,3},
      {0,0,0}},
     
     {{4,0,0},
      {4,4,4},
      {0,0,0}},
     
     {{0,0,5},
      {5,5,5},
      {0,0,0}},

     {{0,6,6},
      {6,6,0},
      {0,0,0}},
     
     {{7,7,0},
      {0,7,7},
      {0,0,0}}
};

    private int[][] shape;
    private int[] position;

    public Tetromino() {
	this.shape = generator();
	this.position = new int[2];
    }

    public int[][] getShape() {
	return this.shape;
    }

    public int[] getPosition() {
	return this.position;
    }

    public void setPosition(int[] position) {
	if (position.length == 2) {
	    this.position = position;
	}
    }

    private int[][] generator() {
	Random randomGenerator = new Random();
	int randomNumber = randomGenerator.nextInt(7) + 1;
	
        return TETROMINOS[randomNumber];
    }

    public void translate(int[] translation) {
	if (translation.length == 2) {
	    position = new int[]{position[0] + translation[0],
				      position[1] + translation[1]};
	}
    }
	
    public void rotate(boolean clockwise) {
	if (clockwise) {
	    int[][] newShape = new int[shape.length][shape.length];
	    
	    for (int i = 0; i < shape.length; i++) {
		for (int j = 0; j < shape.length; j++) {
		    newShape[i][j] = shape[shape.length - 1 - j][i];
		}
	    }

	    shape = newShape;
	} else {
	    for (int i = 0; i < 3; i++) {
		rotate(true);
	    }
	}
	
    }

    public static void test() {
	String testString = "";
	
	for (int i = 0; i < 8; i++) {
	    int[][] testShape = TETROMINOS[i];
	    testString += "Tetromino " + i + ": \n";
	    
	    for (int[] row : testShape) {
		for (int element : row) {
		    if (element == 0) {
			testString += "  ";
		    } else {
			testString += "[]";
		    }
		}
		
		testString += "\n";
	    }
	    
	    testString += "\n";
	}
	
	System.out.println(testString);
    }

    public int[][] configuration() {
	if (shape.length == 1) {
	    return new int[][]{new int[]{0,0}};
	}

	int[][] configuration = new int[4][2];
	int count = 0;
	
	for (int i = 0; i < shape.length; i++) {
	    for (int j = 0; j < shape[i].length; j++) {
		if (shape[i][j] != 0) {
		    configuration[count][0] = i;
		    configuration[count++][1] = j;
		}
	    }
	}
	
	return configuration;
    }

    public int type() {
	return shape[configuration()[0][0]][configuration()[0][1]];
    }

    public void resetShape() {
	shape = TETROMINOS[type()];
    }

    public static Tetromino empty() {
	Tetromino empty = new Tetromino();
	empty.shape = TETROMINOS[0];
	return empty;
    }

    public String toString() {
	String description = "";
	
	for (int[] row : shape) {
	    for (int element : row) {
		if (element == 0) {
		    description += "  ";
		} else {
		    description += "[]";
		}
	    }
	    
	    description += "\n";
	}

	description += "(" + position[0] + ", " +
	    position[1] + ")\n";
	
	return description;
    }
}
