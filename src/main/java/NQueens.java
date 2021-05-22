//https://leetcode.com/problems/n-queens/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public void demo(){
        List<List<String>> solutions = solveNQueens(4);

        for (List<String> solution : solutions) {
            System.out.println("-------------");
            for (String str : solution) {
                System.out.println(str);
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board = getBoard(n);
        ArrayList<List<String>> solutions = new ArrayList<>();
        dfs(0, board,solutions);
        return solutions;
    }

    private void dfs(int row, char[][] board,List<List<String>> solutions) {
        if (row == board.length) {
            solutions.add(getSolution(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (canPlace(board, row, col)) {
                board[row][col] = 'Q';
                dfs(row +1, board,solutions);
                board[row][col] = '.';
            }
        }
    }

    private boolean canPlace(char[][] board, int row, int col) {
        for (int i = 0; i < board.length; i++)
            if (board[row][i] == 'Q' || board[i][col] == 'Q') return false;

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q') return false;

        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++)
            if (board[i][j] == 'Q') return false;

        return true;
    }

    private List<String> getSolution(char[][] board) {
        ArrayList<String> solution = new ArrayList<>();
       for(int i=0;i<board.length;i++){
           String soltuionString ="";
           for (int j=0;j<board.length;j++) soltuionString+= board[i][j];
           solution.add(soltuionString);
       }
        return solution;
    }

    private char[][] getBoard(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        return board;
    }
}
