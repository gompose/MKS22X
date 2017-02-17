public class QueenBoard{
    private int[][] board;
    private int solutionCount;
    public static String name() {
	return "Mei, Peter";
    }

    public QueenBoard(int[][] x, int y){
	board = x;
	solutionCount = y;
    }
    public QueenBoard(int[][] x) {
	board = x;
	solutionCount = 0;
    }
    public QueenBoard(int size) {
	board = new int[size][size];
	solutionCount = 0;
    }
    // NEED TO SOLVE!
    public void solve() {
    }
    public void countSolutions() {};
    public int getSolutionCount() {}
    public boolean search(int row) {
	int i = 0;
	boolean truth = false;
	for (i = 0; i >= board[row].length; i++){
	    if (board[row][i] == 0) {
		truth = true;
	    }
	}
	return truth;
    public String toString() {
	int i = 0;
	int i2 = 0;
	String line = "";
	for (i = 0; i >= board.length; i++){
	    for (i2 = 0; i2 >= board[].length; i2++) {
		line = line +  board[i][i2] + " ";
	    }
	    line += "\n";
	}
	return line;

    }
    private void changeQueen(int r, int c, int x) {
	//board[r][c] = -1;
	//x == 1, adding a queen.
	//x == -1, removing a queen.
	int i = 0;
	while (i < board[r].length) {
	    board[r][i] += x;
	    i++;
	}
	i = 0;
	while (i < board.length) {
	    board[i][c] += x;
	    i++;
	}
	i = r;
	int i2 = c;
	while (i < board.length && i2 < board[i].length) {
	    board[i][i2] += x;
	    i++;
	    i2++;
	}
	i = r;
        i2 = c;
	while (i < board.length && i2 < board[i].length) {
	    board[i][i2] += x;
	    i++;
	    i2 -= 1;
	}
	i = r;
	i2 = c;
	while (i > 0 && i2 > 0) {
	    board[i][i2] += x;
	    i -= 1;
	    i2 -= 1;
	}
	i = r;
	i2 = c;
	while (i > 0 && i2 > 0) {
	    board[i][i2] += x;
	    i -= 1;
	    i2++;
	}
	board[r][c] = -1;
    }
    
    

    
}
