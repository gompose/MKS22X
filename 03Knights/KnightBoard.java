public class KnightBoard {
    private int[][] board;
    private static final int[][] options = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
    private int[][] validOptions;
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
    
    /*public void solve() {
	solveH(0, 0, 1);
	}

    private boolean solveH(int row, int col, int level){
	addKnight(row, col, level);
	if (solved()) {
	    return true;
	} else {
	    //IF: hasSpaces() then -> solveH(on the space, level+1)
	    //ELSE: removeKnight(row, col)
	    //      Backtrack to 1 previous level
	    //      Recalculate Options

	    // My brain is  like mashed tomatoes right now.
	}

    }
    */
    
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
    /*
    private int openSquares(int row, int col) {
	int i = 0;
        if (inBounds(row, col, 1) && board[row][col] = 0) {
	    i++;
	}

    private boolean inBounds(int row, int col, int option) {
        boolean bounded;
	boolean rowbound = options[option][0] + row >= 0 && options[option][0] + row <= board.length;
	boolean colbound = options[option][1] + col >= 0 && options[option][0] + col <= board[row].length;
	bounded = rowbound && colbound;
    }
	    
    */
    
	

    public static void main(String[] args) {
	KnightBoard c = new KnightBoard(7, 7);
	System.out.println(c);
    }


	

}
