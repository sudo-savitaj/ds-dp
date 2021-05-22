//https://leetcode.com/problems/n-queens-ii/
class NQueenII {
    char queenCharacter = 'Q';
    int count=0;

    public void display() {
        System.out.println(backtrackNQueens(1));
    }

    public int backtrackNQueens(int n) {
        char[][] board = new char[n][n];
        backtrackNQueens(board,0);
        return count;
    }

    private void backtrackNQueens(char[][] board, int row) {
        if (row == board.length) {
            count++;
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (!isAttackingPos(board, row, col)) {
                placequeen(board, row, col);
               backtrackNQueens(board, row + 1);
                removeQueen(board,row,col);
            }
        }
    }

    private void removeQueen(char[][] board, int row, int col) {
        board[row][col] = ' ';
    }

    private void placequeen(char[][] board, int row, int col) {
        board[row][col] = queenCharacter;
    }

    private boolean isAttackingPos(char[][] board, int row, int col) {
        for (int j = 0; j < board.length; j++) {
            if (board[row][j] == queenCharacter || board[j][col] == queenCharacter) {
                return true;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == queenCharacter)
                return true;
        }

        for (int i = row, j = col;  i >= 0   && j < board.length; i--, j++) {
            if (board[i][j] == queenCharacter)
                return true;
        }
        return false;
    }
}
