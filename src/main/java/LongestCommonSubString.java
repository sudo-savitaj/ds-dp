//https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1/?category[]=Dynamic%20Programming&category[]=Dynamic%20Programming&company[]=Amazon&company[]=Amazon&problemType=functional&page=1&query=category[]Dynamic%20Programmingcompany[]AmazonproblemTypefunctionalpage1company[]Amazoncategory[]Dynamic%20Programming
public class LongestCommonSubString {
    public void display() {
        int lcs = longestCommonSubstr( "ABCDGH", "ACDGHR",6, 6);
        System.out.println(lcs);
    }

    int longestCommonSubstr(String S1, String S2, int n, int m){
        int[][] t= new int[n+1][m+1];

        int max = 0;
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0||j==0) {
                    t[i][j] =0;
                    continue;
                }

                if(S1.charAt(i-1)==S2.charAt(j-1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                    if(t[i][j] > max) max = t[i][j];
                }
                else
                    t[i][j] =0;
            }
        }

        return max;
    }
}
