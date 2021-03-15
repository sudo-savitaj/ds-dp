public class LongestRepeatingSubSequence {
    void display(){
        int result = longestRepeatingSubsequence("AABEBCDD");

        System.out.println(result);
    }

    int longestRepeatingSubsequence(String str){
        int n = str.length();

        int[][] t = new int[n+1][n+1];

        for(int i=0;i<=n;i++){
            for(int j =0;j<=n;j++){
                if(i==0||j==0){
                    t[i][j] = 0;
                    continue;
                }
                if(str.charAt(i-1) == str.charAt(j-1) && i!=j) t[i][j] = 1 + t[i-1][j-1];
                else t[i][j] = Integer.max(t[i-1][j],t[i][j-1]);

            }
        }

        int lengthOfLongestRepeatingSubSeq = t[n][n];
        char[] longestRepeatingSubSeq = new char[lengthOfLongestRepeatingSubSeq];
        int i=n,j=n;
        int k=lengthOfLongestRepeatingSubSeq-1;

        while(i>0&&j>0){
            if(str.charAt(i-1) == str.charAt(j-1)&& i!=j){
                longestRepeatingSubSeq[k] = str.charAt(i-1);
                i--;
                j--;
                k--;
            } else if(t[i-1][j] > t[i][j-1]) i--;
            else j--;
        }

        for (char item : longestRepeatingSubSeq) {
            System.out.println(item);
        }
        return t[n][n];
    }
}
