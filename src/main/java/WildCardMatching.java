//https://leetcode.com/problems/wildcard-matching/
public class WildCardMatching {

    public void display() {

//        System.out.println("a".substring(1));

        boolean isMatched = isMatch("zacabz", "*a?b*");
        boolean isMatched2 = isMatchDp("zacabz", "*a?b*");
        System.out.println(isMatched);
        System.out.println(isMatched);
    }

    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();

        if (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?'))
            return isMatch(s.substring(1), p.substring(1));
        else if (p.charAt(0) == '*') {
            boolean subMatch1 = s.isEmpty() ? false: isMatch(s.substring(1), p);
            boolean subMatch2 = isMatch(s, p.substring(1));
            return subMatch1 || subMatch2;
        }
        return false;
    }

    public boolean isMatchDp(String s, String p) {
        int writeIndex =0;
        char[] pattern = p.toCharArray();

        boolean isFrirst = true;
        for(int i=0;i<pattern.length;i++){
            if(pattern[i] == '*'){
                if(isFrirst) {
                    pattern[writeIndex]= pattern[i];
                    isFrirst=false;
                }
            } else {
                pattern[writeIndex]= pattern[i];
                isFrirst=true;
            }

        }

        boolean[][] cache = new boolean[s.length()+1][writeIndex+1];

        for(int i=0;i<=s.length();i++){
            for (int j=0;j<=writeIndex;j++){
                if(i==0&&j==0) {
                    cache[i][j] = true;
                    continue;
                } else if(i==0&& j==1&&pattern[0]=='*')
                {
                    cache[i][j] = true;
                    continue;
                }
                else if(i==0||j==0) {
                    cache[i][j] = false;
                    continue;
                }

                if(i>0 && (s.charAt(i-1) == pattern[j-1] || pattern[j-1] == '?'))
                    cache[i][j] = cache[i-1][j-1];
                else if (pattern[j-1] == '*')
                    cache[i][j] = cache[i-1][j] || cache[i][j-1];

            }
        }

        return cache[s.length()][writeIndex];
    }
}

