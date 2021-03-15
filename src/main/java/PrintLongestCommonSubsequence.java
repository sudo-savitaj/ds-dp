public class PrintLongestCommonSubsequence {
    public void display() {
        lcs("ABC", "AC", 3, 2);
    }

    void lcs(String X, String Y, int m, int n) {
        int[][] t = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                    continue;
                }

                if (X.charAt(i - 1) == Y.charAt(j - 1)) t[i][j] = 1 + t[i - 1][j - 1];
                else t[i][j] = Integer.max(t[i - 1][j], t[i][j - 1]);
            }
        }

        int i = m, j = n;
        int lengthOfLongestCommonSubsequence = t[m][n];
        char[] lcs = new char[lengthOfLongestCommonSubsequence];
        int k = lengthOfLongestCommonSubsequence - 1;
        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                lcs[k] = X.charAt(i-1);
                i--;
                j--;
                k--;
            } else {
                if(t[i][j-1] > t[i-1][j]) j--;
                else i--;
            }
        }

        for (char item : lcs) {
            System.out.println(item);
        }
    }

}
