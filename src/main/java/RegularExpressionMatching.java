//Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*' where:
//
//        '.' Matches any single character.​​​​
//        '*' Matches zero or more of the preceding element.
//        The matching should cover the entire input string (not partial)


public class RegularExpressionMatching {
    public void display() {
//        boolean isMatch = isMatch("aab", "c*a*b");
//        System.out.println(isMatch);

        boolean isMatchDP = isMatchDP("aa", "a*");
        System.out.println(isMatchDP);
    }

    boolean isMatch(String str, String pattern) {
        if (pattern.isEmpty()) return str.isEmpty();

        boolean isFirstMatching = !str.isEmpty() && (str.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.');

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return isMatch(str, pattern.substring(2)) || (isFirstMatching && isMatch(str.substring(1), pattern));
        } else
            return isFirstMatching && isMatch(str.substring(1), pattern.substring(1));
    }

    boolean isMatchDP(String str, String pattern) {
        int n = str.length();
        int m = pattern.length();
        boolean[][] t = new boolean[n + 1][m + 1];
        t[n][m] = true;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                boolean isFirstMatching = str.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.';

                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    t[i][j] = t[i][j+2] || (isFirstMatching&& t[i+1][j]);
                }else {
                    t[i][j] = isFirstMatching && t[i+1][j+1];
                }
            }
        }
        return t[0][0];
    }
}
