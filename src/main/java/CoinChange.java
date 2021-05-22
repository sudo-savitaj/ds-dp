//https://practice.geeksforgeeks.org/problems/coin-change2448/1/?category[]=Dynamic%20Programming&category[]=Dynamic%20Programming&company[]=Amazon&company[]=Amazon&problemType=functional&page=1&query=category[]Dynamic%20Programmingcompany[]AmazonproblemTypefunctionalpage1company[]Amazoncategory[]Dynamic%20Programming
public class CoinChange {
    public void display() {
        int[] cents = {1, 2, 3};
        int sum = 4;

        long count = count(cents, cents.length, sum);
        System.out.println(count);

        count = countDp(cents, cents.length, sum);
        System.out.println(count);
    }

    long count(int S[], int n, int sum) {
        if (sum == 0) return 1;

        if (n == 0) return 0;

        if (S[n - 1] > sum) return count(S, n - 1, sum);
        ;
        return count(S, n, sum - S[n - 1]) + count(S, n - 1, sum);
    }

    long countDp(int S[], int n, int sum) {
        long[][] t = new long[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {

                if (j == 0) {
                    t[i][j] = 1;
                    continue;
                }
                if (i == 0) {
                    t[i][j] = 0;
                    continue;
                }

                if(S[i-1]>j) t[i][j] = t[i-1][j];
                else t[i][j] = t[i][j-S[i-1]] +t[i-1][j];
            }
        }


        return t[n][sum];
    }



}
