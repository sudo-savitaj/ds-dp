//https://www.geeksforgeeks.org/check-if-a-string-is-a-scrambled-form-of-another-string/
public class ScrambleString {
    public void display() {
        Boolean isScramble = isScramlbeString("great", "rgeat");

        System.out.println(isScramble);
    }

    private Boolean isScramlbeString(String s1, String s2) {
        if (s1.equals(s2)) return true;

        if (s1.length() != s2.length()) return false;

        int n = s1.length();
        for (int i = 1; i < n; i++) {

            if (isScramlbeString(s1.substring(0, i), s2.substring(n - i, n)) && isScramlbeString(s1.substring(i, n), s2.substring(0, n - i)))
                return true;

            if (isScramlbeString(s1.substring(0, i), s2.substring(0, i)) && isScramlbeString(s1.substring(i, n), s2.substring(i, n)))
                return true;
        }

        return false;
    }


}
