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
    /*public void solve() {
	solveH(0, 0, 1);
	}*/

    //private boolean solveH(int row, int col, int level){};

    private boolean addKnight(int x, int y, int number) {
	if (board[x][y] == 0) {
	    board[x][y] = number;
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

    /*
    private boolean solved() {
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
    }
    */
	

    public static void main(String[] args) {
	KnightBoard c = new KnightBoard(7, 7);
	System.out.println(c);
    }


	

}
