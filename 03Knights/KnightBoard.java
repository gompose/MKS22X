import java.util.Arrays;

public class KnightBoard {
    private int[][] board;
    private static final int[][] options = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
    private int[][] validOptions = {{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0,0}, {0, 0}, {0, 0}};

    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];
    }

    public String toString() {
	String boardstate = "";
	for(int i = 0; i < board.length; i++) {
	    for(int n = 0; n < board[i].length; n++) {
		if (board[i][n] < 10) {
		    boardstate = boardstate + "_" + board[i][n] + " ";
		} else {
		    boardstate = boardstate + board[i][n] + " ";
		}
	    }
	    boardstate = boardstate + "\n";
	}
	return boardstate;
    }
    
    public void solve() {
	solveH(0, 0, 1);
	}

    private boolean solveH(int row, int col, int level){
	removeGreater(level);
	int i = recalculateMoves(row, col);
	while (i > recalculateMoves(row, col)){
	    wipe(validOptions[i]);
	    i -= 1;
	}
       
	int[][] validOptionsCurrent = validOptions;
	addKnight(row, col, level);
        
	System.out.println("" + row + col + level);
	System.out.println(Arrays.deepToString(validOptionsCurrent));
	System.out.println(toString());
	try {
	    Thread.sleep(300);
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
        if (i == 0 && (!(solved()))) {
	    removeKnight(row, col);
	    return false;
	}
	if (i == 0 && solved()) {
	    return true;
	}
	if (i == 1) {
	    return solveH(validOptionsCurrent[0][0] + row, validOptionsCurrent[0][1] + col, level + 1);
	}
	if (i == 2) {
	    return solveH(validOptionsCurrent[0][0] + row, validOptionsCurrent[0][1] + col, level + 1) 
		|| solveH(validOptionsCurrent[1][0] + row, validOptionsCurrent[1][1] + col, level + 1);
	}
	if (i == 3) {
	    return solveH(validOptionsCurrent[0][0] + row, validOptionsCurrent[0][1] + col, level + 1) 
		|| solveH(validOptionsCurrent[1][0] + row, validOptionsCurrent[1][1] + col, level + 1)
		|| solveH(validOptionsCurrent[2][0] + row, validOptionsCurrent[2][1] + col, level + 1);
	}
	if (i == 4) {
	    return solveH(validOptionsCurrent[0][0] + row, validOptionsCurrent[0][1] + col, level + 1) 
		|| solveH(validOptionsCurrent[1][0] + row, validOptionsCurrent[1][1] + col, level + 1)
		|| solveH(validOptionsCurrent[2][0] + row, validOptionsCurrent[2][1] + col, level + 1)
		|| solveH(validOptionsCurrent[3][0] + row, validOptionsCurrent[3][1] + col, level + 1);
	}
	if (i == 5) {
	    return solveH(validOptionsCurrent[0][0] + row, validOptionsCurrent[0][1] + col, level + 1) 
		|| solveH(validOptionsCurrent[1][0] + row, validOptionsCurrent[1][1] + col, level + 1)
		|| solveH(validOptionsCurrent[2][0] + row, validOptionsCurrent[2][1] + col, level + 1)
		|| solveH(validOptionsCurrent[3][0] + row, validOptionsCurrent[3][1] + col, level + 1)
		|| solveH(validOptionsCurrent[4][0] + row, validOptionsCurrent[4][1] + col, level + 1);
	}
	if (i == 6) {
	    return solveH(validOptionsCurrent[0][0] + row, validOptionsCurrent[0][1] + col, level + 1) 
		|| solveH(validOptionsCurrent[1][0] + row, validOptionsCurrent[1][1] + col, level + 1)
		|| solveH(validOptionsCurrent[2][0] + row, validOptionsCurrent[2][1] + col, level + 1)
		|| solveH(validOptionsCurrent[3][0] + row, validOptionsCurrent[3][1] + col, level + 1)
		|| solveH(validOptionsCurrent[4][0] + row, validOptionsCurrent[4][1] + col, level + 1)
		|| solveH(validOptionsCurrent[5][0] + row, validOptionsCurrent[5][1] + col, level + 1);
	}
	if (i == 7) {
	    return solveH(validOptionsCurrent[0][0] + row, validOptionsCurrent[0][1] + col, level + 1) 
		|| solveH(validOptionsCurrent[1][0] + row, validOptionsCurrent[1][1] + col, level + 1)
		|| solveH(validOptionsCurrent[2][0] + row, validOptionsCurrent[2][1] + col, level + 1)
		|| solveH(validOptionsCurrent[3][0] + row, validOptionsCurrent[3][1] + col, level + 1)
		|| solveH(validOptionsCurrent[4][0] + row, validOptionsCurrent[4][1] + col, level + 1)
		|| solveH(validOptionsCurrent[5][0] + row, validOptionsCurrent[5][1] + col, level + 1)
		|| solveH(validOptionsCurrent[6][0] + row, validOptionsCurrent[6][1] + col, level + 1);
	} else {
	    return solveH(validOptionsCurrent[0][0] + row, validOptionsCurrent[0][1] + col, level + 1) 
		|| solveH(validOptionsCurrent[1][0] + row, validOptionsCurrent[1][1] + col, level + 1)
		|| solveH(validOptionsCurrent[2][0] + row, validOptionsCurrent[2][1] + col, level + 1)
		|| solveH(validOptionsCurrent[3][0] + row, validOptionsCurrent[3][1] + col, level + 1)
		|| solveH(validOptionsCurrent[4][0] + row, validOptionsCurrent[4][1] + col, level + 1)
		|| solveH(validOptionsCurrent[5][0] + row, validOptionsCurrent[5][1] + col, level + 1)
		|| solveH(validOptionsCurrent[6][0] + row, validOptionsCurrent[6][1] + col, level + 1)
		|| solveH(validOptionsCurrent[7][0] + row, validOptionsCurrent[7][1] + col, level + 1);
	}
    }
    
    
    private boolean addKnight(int x, int y, int level) {
	if (board[x][y] == 0) {
	    board[x][y] = level;
	    return true;
	} else {
	    return false;
	}
    }
    private boolean removeKnight(int x, int y) {
	if (board[x][y] != 0) {
	    board[x][y] = 0;
	    return true;
	} else {
	    return false;
	}
    }

    
    private boolean solved() {
	boolean isSolved = true;
	for(int i = 0; i < board.length; i++) {
	    for(int n = 0; n < board[i].length; n++) {
		if (board[i][n] == 0) {
		    isSolved = false;
		}
	    }
	}
	return isSolved;
    }
    
    private int openSquares(int row, int col) {
	int i = 0;
        if (inBounds(row, col, 1) && board[row][col] == 0) {
	    i++;
	}
	return i;
    }

    private boolean inBounds(int row, int col, int option) {
        boolean bounded;
	boolean rowbound = options[option][0] + row >= 0 && options[option][0] + row <= board.length - 1;
	boolean colbound = options[option][1] + col >= 0 && options[option][1] + col <= board[row].length - 1;
	bounded = rowbound && colbound;
	return bounded;
    }

    private int recalculateMoves(int row, int col) {
	int possible = 0;
	if (inBounds(row, col, 0) && board[row + options[0][0]][col + options[0][1]] == 0){
	    validOptions[possible] = options[0];
	    possible++;
	}
	if (inBounds(row, col, 1) && board[row + options[1][0]][col + options[1][1]] == 0){
	    validOptions[possible] = options[1];
	    possible++;
	}
	if (inBounds(row, col, 2) && board[row + options[2][0]][col + options[2][1]] == 0){
	    validOptions[possible] = options[2];
	    possible++;
	}
	if (inBounds(row, col, 3) && board[row + options[3][0]][col + options[3][1]] == 0){
	    validOptions[possible] = options[3];
	    possible++;
	}
	if (inBounds(row, col, 4) && board[row + options[4][0]][col + options[4][1]] == 0){
	    validOptions[possible] = options[4];
	    possible++;
	}
	if (inBounds(row, col, 5) && board[row + options[5][0]][col + options[5][1]] == 0){
	    validOptions[possible] = options[5];
	    possible++;
	}
	if (inBounds(row, col, 6) && board[row + options[6][0]][col + options[6][1]] == 0){
	    validOptions[possible] = options[6];
	    possible++;
	}
	if (inBounds(row, col, 7) && board[row + options[7][0]][col + options[7][1]] == 0){
	    validOptions[possible] = options[7];
	    possible++;
	}
	return possible;
    }
    private void wipe(int[] arr) {
	arr[0] = 0;
	arr[1] = 0;
    }
    private void removeGreater(int level){
	for(int i = 0; i < board.length; i++) {
	    for(int n = 0; n < board[i].length; n++) {
		if (board[i][n] >= level) {
		    board[i][n] = 0;
		}
	    }
	}
    }
	
	    
    
	

    public static void main(String[] args) {
	KnightBoard c = new KnightBoard(5, 5);
	System.out.println(c);
	c.solve();
       	System.out.println(c);
    }


	

}
