//https://practice.geeksforgeeks.org/problems/boolean-parenthesization5610/1/?category[]=Dynamic%20Programming&category[]=Dynamic%20Programming&company[]=Amazon&company[]=Amazon&problemType=functional&page=2&query=category[]Dynamic%20Programmingcompany[]AmazonproblemTypefunctionalpage2company[]Amazoncategory[]Dynamic%20Programming
public class BooleanParenthesization {
    public void display() {

    }

    int countWays(int N, String S){
        return countWays(N,S, "",0,0);
    }

    private int countWays(int n, String str, String res, int open, int close) {
        if(close == n/2) return evaluateExpression() == true ? 1:0;

        int startIndex = res.length() - open - close;
        int ways=0;
        for (int k = startIndex; k<n;k++){
            if(open<n/2) {
                ways += countWays(n, str, "("+res, open + 1, close);
            }

            if(open<close) {
                ways += countWays(n, str,  res+")", open, close+1);
            }


        }
        return n;
    }

    private boolean evaluateExpression() {
        return true;
    }
}
