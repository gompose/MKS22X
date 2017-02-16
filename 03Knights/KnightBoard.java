public class KnightBoard {
    private int[][] board;
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

    private boolean solveH(int row, int col, int level){};

	

}
