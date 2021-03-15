public class ShortestCommonSupersequence {
    public void display() {
        int shortestCommonSupersequence = shortestSuperSequence( "AGGTAB", "GXTXAYB");
        System.out.println(shortestCommonSupersequence);
    }

    int shortestSuperSequence(String X, String Y){
        int lcs = lcs(X,Y,X.length(),Y.length());
        return X.length() + Y.length() - lcs ;
    }

    int lcs(String S1, String S2, int n, int m) {
        int[][] t = new int[n+1][m+1];

        for(int i=0;i<=n;i++){
            for (int j=0;j<=m;j++){
                if(i==0||j==0){
                    t[i][j] = 0;
                    continue;
                }

                if(S1.charAt(i-1) == S2.charAt(j-1)) t[i][j] = 1+ t[i-1][j-1];
                else t[i][j] = Integer.max(t[i-1][j],t[i][j-1]);

            }
        }
        return t[n][m];
    }
}
