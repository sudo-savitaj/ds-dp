//Sequence Pattern Matching
//https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1/?category[]=Dynamic%20Programming&category[]=Dynamic%20Programming&company[]=Amazon&company[]=Amazon&problemType=functional&page=1&query=category[]Dynamic%20Programmingcompany[]AmazonproblemTypefunctionalpage1company[]Amazoncategory[]Dynamic%20Programming
public class LongestCommonSubsequence {
    int[][] cache = new int[101][101];

    public LongestCommonSubsequence() {
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                cache[i][j] = -1;
            }
        }
    }

    public void display() {
        int lcs = lcs(3, 2, "ABC", "AC");
        System.out.println(lcs);

        lcs = lcsTopDown(5, 4, "hetap", "pena");
        System.out.println(lcs);

    }

    int lcs(int p, int q, String s1, String s2) {
        if (p == 0 || q == 0) return 0;

        if (cache[p][q] != -1) return cache[p][q];

        if (s1.charAt(p - 1) == s2.charAt(q - 1)) {
            cache[p][q] = 1 + lcs(p - 1, q - 1, s1, s2);
            return cache[p][q];
        }

        cache[p][q] = Integer.max(lcs(p - 1, q, s1, s2), lcs(p, q - 1, s1, s2));
        return cache[p][q];
    }

    int lcsTopDown(int p, int q, String s1, String s2) {
        int[][] t = new int[p + 1][q + 1];

        for (int i = 0; i <= p; i++) {
            for (int j = 0; j <= q; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                    continue;
                }

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) t[i][j] = 1 + t[i - 1][j - 1];
                else t[i][j] = Integer.max(t[i - 1][j], t[i][j - 1]);
            }
        }
        return t[p][q];
    }


}
