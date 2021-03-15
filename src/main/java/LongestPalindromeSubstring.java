public class LongestPalindromeSubstring {

    void display() {
        System.out.println(longestPalindromeViaRecursive("babad"));
    }

    private String longestPalindromeViaDp(String str) {
        int length = str.length();
        int[][] cache = new int[length][length];

        int maxlength = 0;
        int start = 0;
        for (int g = 0; g < length; g++) {
            for (int i=0, j = g; j < length;i++, j++) {

                if(g == 0) cache[i][j] = 1;
                else if (str.charAt(i) == str.charAt(j)){
                    if(g==1) cache[i][j]=1;
                    else if(cache[i + 1][j - 1] == 1) cache[i][j] =1;
                }

                if (cache[i][j] == 1 && g+1 > maxlength) {
                    start = i;
                    maxlength = g+1;
                }
            }
        }
        return str.substring(start, start + maxlength);
    }

    private String longestPalindromeViaRecursive(String str) {
        if (str == null || str.length() < 1) return "";
        int start = 0,end=0;
        for(int i=0;i<str.length();i++){
            int len1 = expandAroundCenter(str,i,i);
            int len2 = expandAroundCenter(str,i,i+1);
            int len = Integer.max(len1,len2);
            if(len > end-start){
                start = i -((len-1)/2);
                end = i + (len/2);
            }
        }
        return str.substring(start,end+1);
    }

    private int expandAroundCenter(String str, int i, int j) {
        while(i>=0&&j<str.length()&& str.charAt(i) == str.charAt(j))
        {
            i--;
            j++;
        }
        return j-i -1;
    }

    public String longestPalindromeViaLongestCommonSubstring(String str) {
        int length = str.length();
        StringBuffer buffer = new StringBuffer(str);
        String reverse = String.valueOf(buffer.reverse());

        int[][] cache = new int[length + 1][length + 1];

        int max = -1;
        int locI = -1;
        int locJ = -1;
        for (int i = 0; i <= length; i++) {
            for (int j = 0; j <= length; j++) {
                if (i == 0 || j == 0) {
                    cache[i][j] = 0;
                    continue;
                }

                if (str.charAt(i - 1) == reverse.charAt(j - 1)) {
                    cache[i][j] = 1 + cache[i - 1][j - 1];
                    if (cache[i][j] > max) {
                        max = cache[i][j];
                        locI = i;
                        locJ = j;
                    }
                } else cache[i][j] = 0;
            }
        }
        char[] arr = new char[max];
        int i = 0;
        while (cache[locI][locJ] > 0 && locI > 0 && locJ > 0) {
            arr[i] = str.charAt(locI - 1);
            i++;
            locI--;
            locJ--;
        }

        return String.valueOf(arr);
    }
}
