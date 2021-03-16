//https://leetcode.com/problems/unique-paths/
public class UniquePath {

    public void display() {
        int possibleUniquePath = uniquePathsDP(3, 7);

        System.out.println(possibleUniquePath);
    }

    public int uniquePaths(int m, int n) {
        if (m == 1 && n == 1) return 1;
        if (m < 1 || n < 1) return 0;
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }

    public int uniquePathsDP(int m, int n) {
        int[][] cache = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) cache[i][j] = 0;
                else if (i == 1 && j == 1) cache[i][j] = 1;
                else cache[i][j] = cache[i-1][j] + cache[i][j-1];

            }
        }
        return cache[m][n];
    }
}
