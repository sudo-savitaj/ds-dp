public class MinimumNumberOfDeletionInStringToMakeITPalindrome {
    public void display() {
        int minimumNumberOfDeletions = minimumNumberOfDeletions("");

        System.out.println(minimumNumberOfDeletions);

        boolean result = isSamePattern("akcy","gajkcuoy");
        System.out.println(result);
    }

    int minimumNumberOfDeletions(String str){
        int lps = lps(str);
        return str.length() - lps;
    }

    private int lps(String str) {
        StringBuffer buffer = new StringBuffer();
        int lcs = lcs(str,String.valueOf(buffer.reverse()));
        return lcs;
    }

    private int lcs(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] t = new int[m +1][n +1];

        for (int i=0;i<=m;i++){
            for (int j=0;j<=n;j++){
                if(i==0||j==0) {
                    t[i][j] = 0;
                    continue;
                }

                if(str1.charAt(i-1) == str2.charAt(j-1)) t[i][j] = 1 + t[i-1][j-1];
                else t[i][j] = Integer.max(t[i-1][j],t[i][j-1]);
            }
        }
        return t[m][n];
    }

    boolean isSamePattern(String str1,String str2){
        int lcs = lcs(str1, str2);
        if(str1.length()< str2.length()) return str1.length() == lcs;
        return  str2.length() == lcs;
    }
}
