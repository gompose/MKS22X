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
	/*addKnight(row, col, level);
	if (solved()) {
	    return true;
	} else {
	    //IF: hasSpaces() then -> solveH(on the space, level+1)
	    //ELSE: removeKnight(row, col)
	    //      Backtrack to 1 previous level
	    //      Recalculate Options

	    
	}
	*/
	addKnight(row, col, level);
	recalculateMoves(row, col);
	if (validOptions[0][0] == 0) {
	    removeKnight(row, col);
	    return false;
	}
	return solveH(validOptions[0][0] + row, validOptions[0][1] + col, level + 1) 
	    || solveH(validOptions[1][0] + row, validOptions[1][1] + col, level + 1)
	    || solveH(validOptions[2][0] + row, validOptions[2][1] + col, level + 1)
	    || solveH(validOptions[3][0] + row, validOptions[3][1] + col, level + 1)
	    || solveH(validOptions[4][0] + row, validOptions[4][1] + col, level + 1)
	    || solveH(validOptions[5][0] + row, validOptions[5][1] + col, level + 1)
	    || solveH(validOptions[6][0] + row, validOptions[6][1] + col, level + 1)
	    || solveH(validOptions[7][0] + row, validOptions[7][1] + col, level + 1);
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
        if (inBounds(row, col, 1) && board[row][col] = 0) {
	    i++;
	}
	return i;
    }

    private boolean inBounds(int row, int col, int option) {
        boolean bounded;
	boolean rowbound = options[option][0] + row >= 0 && options[option][0] + row <= board.length;
	boolean colbound = options[option][1] + col >= 0 && options[option][0] + col <= board[row].length;
	bounded = rowbound && colbound;
    }

    private int recalculateMoves(int row, int col) {
	int possible = 0;
	if (inBounds(row, col, 0)){
	    validOptions[possible] = options[0];
	    possible++;
	}
	if (inBounds(row, col, 1)){
	    validOptions[possible] = options[1];
	    possible++;
	}
	if (inBounds(row, col, 2)){
	    validOptions[possible] = options[2];
	    possible++;
	}
	if (inBounds(row, col, 3)){
	    validOptions[possible] = options[3];
	    possible++;
	}
	if (inBounds(row, col, 4)){
	    validOptions[possible] = options[4];
	    possible++;
	}
	if (inBounds(row, col, 5)){
	    validOptions[possible] = options[5];
	    possible++;
	}
	if (inBounds(row, col, 6)){
	    validOptions[possible] = options[6];
	    possible++;
	}
	if (inBounds(row, col, 7)){
	    validOptions[possible] = options[7];
	    possible++;
	}
	return possible;
    }
	    
    
	

    public static void main(String[] args) {
	KnightBoard c = new KnightBoard(5, 5);
	System.out.println(c);
	c.solve();
	System.out.println(c);
    }


	

}
