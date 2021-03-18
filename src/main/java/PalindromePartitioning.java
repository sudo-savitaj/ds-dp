//https://www.geeksforgeeks.org/palindrome-partitioning-dp-17/
public class PalindromePartitioning {
    int[][] t = new int[501][501];
    public void display() {
        int result = palindromicPartition("aaa");
        System.out.println(result);

//        String str = "aaa";
//        System.out.println(isPalindrome(str,0,str.length()-1));

    }

    void setup(int length){
        for(int i=0;i<=length;i++){
            for (int j=0;j<=length;j++){
                t[i][j] = -1;
            }
        }
    }

    int palindromicPartition(String str)
    {
        setup(str.length());
        return palindromicPartition(str,0,str.length()-1);
    }

    private int palindromicPartition(String str, int i, int j) {
        if(t[i][j]!= -1) return t[i][j];

        if(i>=j|| isPalindrome(str,i,j)) {
            t[i][j] = 0;
            return t[i][j];
        }

        int minCuts = Integer.MAX_VALUE;
        for (int k=i;k<j;k++){

            int left;
            if(t[i][k]!=-1) left = palindromicPartition(str, i, k);
            else left = t[i][k];

            int right;
            if(t[k+1][j]!=-1) right= palindromicPartition(str, k + 1, j);
            else right = t[k+1][j];

            int cuts = 1 + left + right;
            if(minCuts > cuts){
                minCuts=cuts;
            }
        }

        t[i][j] = minCuts;
        return t[i][j];
    }

    private boolean isPalindrome(String str, int startIndex, int endIndex) {
        int n = endIndex-startIndex+1;
        int i=startIndex;
        int j=endIndex;
        while(i<=endIndex||j>=startIndex){
            if(str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;


//        return cache[n][n] == n;
//        String subStr = str.substring(startIndex,endIndex+1);
//        StringBuffer buffer = new StringBuffer(subStr);
//        String reverseSubStr = String.valueOf(buffer.reverse());
//        return subStr.equals(reverseSubStr);
//        int lcs = lcs(subStr,reverseSubStr);
//        return lcs == (endIndex-i+1);
    }

    private int lcs(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] cache = new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            for (int j=0;j<=n;j++){

                if(i==0||j==0){
                    cache[i][j] = 0;
                    continue;
                }

                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    cache[i][j] = 1 + cache[i-1][j-1];
                } else{
                    cache[i][j] = Integer.max(cache[i-1][j],cache[i][j-1]);
                }
            }
        }
        return cache[m][n];
    }
}
