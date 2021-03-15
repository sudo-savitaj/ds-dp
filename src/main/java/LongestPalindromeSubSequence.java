public class LongestPalindromeSubSequence {
    public void display() {

        int lps = lps("GEEKSFORGEEKS");
        System.out.println(lps);

        int minimumNoOfInsertionToFormPalidrome = minimumNoOfInsertionToFormPalidrome("abcde");
        System.out.println(minimumNoOfInsertionToFormPalidrome);
    }

    int lps(String seq){
        StringBuffer builder = new StringBuffer(seq);
        return lcs(seq, String.valueOf(builder.reverse()));
    }

    private int lcs(String seq, String reverse) {
        int m = seq.length();
        int n = reverse.length();
        int[][] t = new int[m+1][n+1];
        for (int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0||j==0){
                    t[i][j] = 0;
                    continue;
                }

                if(seq.charAt(i-1)==reverse.charAt(j-1)) t[i][j] = 1 + t[i-1][j-1];
                else t[i][j] = Integer.max(t[i-1][j],t[i][j-1]);
            }
        }
        return t[m][n];
    }

    int minimumNoOfInsertionToFormPalidrome(String str){
        int lps = lps(str);
        return str.length() - lps;
    }

}
