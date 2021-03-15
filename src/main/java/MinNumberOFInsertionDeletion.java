public class MinNumberOFInsertionDeletion {

    public void display() {
        System.out.println(minOperations("efaebad", "gehide"));
    }

    int minOperations(String str1, String str2) {
        int lcs = lcs(str1, str2, str1.length(), str2.length());
        return str1.length()+str2.length() -(2*lcs);
    }

    private int lcs(String str1, String str2, int m, int n) {
        int[][] t = new int[m + 1][n + 1];
        int max = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                    continue;
                }

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else t[i][j] = Integer.max(t[i-1][j],t[i][j-1]);

            }
        }
        return t[m][n];
    }

}
